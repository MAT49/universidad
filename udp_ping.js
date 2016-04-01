/*
	Network UDP Ping Pong Program
	Ha K Hwang	
	11/25/2015

	This node.js program requires node installed in your computer.
	Or, you may use online node.js IDE, such as	http://www.tutorialspoint.com/execute_nodejs_online.php
	
	This program takes initial command in the following form:
		command:	node udp_ping.js 127.0.0.1 4000
		argv[]:	 [0]	  [1]           [2]     [3]  
	
	argv[0] is node command
	argv[1] is the file name to run
	argv[2] specifies destination IP address (String)
	argv[3] specifies destination port number (String that gets converted to Int)
	
	On the very bottom of this page is a simple UDP server that can be used to test this program.
	User can disable that server and use their own UDP server.
	
	Node.js has asynchronous loops, and it operates based on events.
	The results are very fast.	
*/


// Require dgram module     
var dgram = require('dgram');

// Getsdestination address and port number from initial command
// command:	node udp_ping.js 127.0.0.1 4000
// argv[]:	 [0]	  [1]       [2]     [3]  
var host = process.argv[2];
var port = parseInt(process.argv[3], 10);

// pingPong method takes an int and a string
// then prints out destination address, port, and round trip time in milliseconds
function pingPong(port, host) {	

	// Create client
	var client = dgram.createSocket('udp4');

	// Create sending timestamp var
	var sendTime;

	// Create message (i.e. "ping")
	var message = new Buffer('ping');


	// Send ping message to server and timestamp.
	client.send(message, 0, message.length, port, host, function(err, bytes) {
		if (err) throw err;
		sendTime = process.hrtime();	
		//console.log('UDP message sent to ' + host +':'+ port + ' ' + message);  
	});

	// Listen for messages from server and calculate round trip time in milliseconds
	//	process.hrtime is "high resolution real time" used best for stop watch functions
	client.on('message', function (message, remote) {		
		var diffTime = process.hrtime(sendTime);
		var rtt = diffTime[0] * 1e3 + diffTime[1]/1e6;		
		if (rtt < 1e3) {
			console.log(remote.address + ':' + remote.port + '     ' + rtt + ' ms');		
		} else {
			console.log('taking too long, packet is lost');
		}
		client.close();
	});
	
	// Error handling
	client.on('error', function (err) {
		console.log("client error:\n" + err.stack);
		throw err;
	});
}

// Call pingPong methods
var count = 0;
var N = 10;
function loop() {
    if (count <= N) {
		pingPong(port, host);
		setTimeout(function() {}, 1000);
		count++;
		loop();
        };
}

// main driver method, calls loop method
loop();






//----------------------------------------------------------------------------------------------
// DISABLE this part if you wish to test on your own UDP server
// Simple UDP server
// Can be used to test client program

var server = dgram.createSocket('udp4');
server.on('message', function (message, remote) {
	//console.log( 'message received from ' + remote.address + ':' + remote.port + ' - ' + message );
    server.send( message, 0, message.length, remote.port, remote.address );
	//console.log('UDP reply sent to ' + remote.address +':'+ remote.port);  
});
server.bind(port, host);

