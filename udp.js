/*
var client = dgram.createSocket('udp4');
client.bind(1234, function() {
  client.addMembership('224.0.0.114');
});
*/





var host = 'localhost', port = 33334;

var dgram = require( "dgram" );

var client = dgram.createSocket( "udp4" );

client.on( "message", function( msg, rinfo ) {
    console.log( "The packet came back" );
});

// client listens on a port as well in order to receive ping
client.bind( port, host );

// proper message sending
// NOTE: the host/port pair points at server
var message = new Buffer( "My KungFu is Good!" );
client.send(message, 0, message.length, 33333, 'localhost' );






log = require('sys').log
dgram = require('./lib/dgram')
var Buffer = require('buffer').Buffer;

var endat = 10;
var count = 0;
socket = dgram.createSocket();
socket.addListener('message', function (msg, rinfo) {
  log('got message from '+ rinfo.address +' port: '+ rinfo.port);
  log('data len: '+ rinfo.size + " data: "+ msg.toString('ascii', 0, rinfo.size));
  socket.send(rinfo.port, rinfo.address, msg, 0, rinfo.size);
  count += 1
  if (count == endat) {
    socket.close();
    process.exit();
  }
});
socket.bind(8000);

setInterval(function() {
  sock = dgram.createSocket();
  var l = 8;
  buf = new Buffer(l);
  for (var i = 0; i < l; i++) {
    buf[i] = 100;
  }

  log('sending ping...');
  sock.addListener('message', function(msg, rinfo) {
    log('got pong from '+ rinfo.address +":"+ rinfo.port);
  });
  sock.send(8000, "localhost", buf, 0, buf.length);
}, 1000);





var net = require('net');

// the machine to scan
var host = 'localhost';
// starting from port number
var start = 1;
// to port number
var end = 10000;
// sockets should timeout asap to ensure no resources are wasted
// but too low a timeout value increases the likelyhood of missing open sockets, so be careful
var timeout = 2000;

// the port scanning loop 
while (start <= end) {
    
    // it is always good to give meaningful names to your variables
    // since the context is changing, we use `port` to refer to current port to scan 
    var port = start;
    
    // we create an anonynous function, pass the current port, and operate on it
    // the reason we encapsulate the socket creation process is because we want to preseve the value of `port` for the callbacks 
    (function(port) {
        // console.log('CHECK: ' + port);
        var s = new net.Socket();
        
        s.setTimeout(timeout, function() { s.destroy(); });
        s.connect(port, host, function() {
            console.log('OPEN: ' + port);
            // we don't destroy the socket cos we want to listen to data event
            // the socket will self-destruct in 2 secs cos of the timeout we set, so no worries
        });
        
        // if any data is written to the client on connection, show it
        s.on('data', function(data) {
            console.log(port +': '+ data);
            s.destroy();
        });
        
        s.on('error', function(e) {
            // silently catch all errors - assume the port is closed
            s.destroy();
        });
    })(port);
    
    start++;
}