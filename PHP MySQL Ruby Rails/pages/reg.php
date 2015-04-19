<?php
session_start();
$errmsg_arr = array();
$errflag = false;
// configuration
/*
$dbhost 	= "localhost";
$dbname		= "group04db";
$dbuser		= "root";
$dbpass		= "";
*/

$dbhost 	= "cs4370.com";
$dbname		= "group04db";
$dbuser		= "g04admin";
$dbpass		= "C&*%uR-IIQ^1";


 
// database connection, top one for local develop, bottom for ftp site

//$conn = new PDO("mysql:host=$dbhost;dbname=$dbname",$dbuser,$dbpass);
$conn = new PDO("mysql:host=$dbhost;dbname=$dbname",'g04web','bo2QC6DyKnzi');
 
// new data 
$user = $_POST['username'];
$password = $_POST['password'];
 
if($user == '') {
	$errmsg_arr[] = 'You must enter your Username';
	$errflag = true;
}
if($password == '') {
	$errmsg_arr[] = 'You must enter your Password';
	$errflag = true;
}
 
// query
$result = $conn->prepare("SELECT * FROM tbl_persons WHERE username= ? AND password= ?");
$result->bindParam(1, $user);
$result->bindParam(2, $password);
$result->execute();
$rows = $result->fetch(PDO::FETCH_NUM);
if($rows > 0) {
header("location: indexcopy.php");
}
else{
	$errmsg_arr[] = 'Username and Password are not found';
	$errflag = true;
}
if($errflag) {
	$_SESSION['ERRMSG_ARR'] = $errmsg_arr;
	session_write_close();
	header("location: login.php");
	exit();
}
 
?>