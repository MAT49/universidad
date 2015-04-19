<?php
session_start();
$errmsg_arr = array();
$errflag = false;
// configuration

$dbhost 	= "localhost";
$dbname		= "group04db";
$dbuser		= "root";
$dbpass		= "";

/*
$dbhost 	= "cs4370.com";
$dbname		= "group04db";
$dbuser		= "g04admin";
$dbpass		= "C&*%uR-IIQ^1";
*/

 
// database connection, top one for local develop, bottom for ftp site

$conn = new PDO("mysql:host=$dbhost;dbname=$dbname",$dbuser,$dbpass);
//$conn = new PDO("mysql:host=$dbhost;dbname=$dbname",'g04web','bo2QC6DyKnzi');

$firstname = $_POST['firstname'];
$lastname = $_POST['lastname'];
$username = $_POST['username'];
$password = md5($_POST['password']."BLDCL048D2");
$email = $_POST['email'];

if( $firstname =='' || $lastname == '' || $username =='' || password =='')
{
	header("location: registercopy.php");
}
 
elseif(isset($firstname, $lastname, $username, $password, $email))
{
/*

	$sql = "INSERT INTO users ( user_name, password, email ) VALUES ( :username, :password, :email )";


		
	$result = $conn->prepare("SELECT * FROM tbl_persons WHERE lastname = ? OR username = ? ");
	$result->bindParam(1, $lastname);
	$result->bindParam(2, $username);
	$result->execute();
	$rows = $result->fetch(PDO::FETCH_NUM);
	
	$query = $query->execute(array(
	$firstname, 
	$lastname, 
	$username, 
	$password, 
	$email
	));
	
*/	
		$query = "INSERT INTO tbl_persons (firstname, lastname, username, password, email) VALUES (:firstname, :lastname, :username, :password, :email)";
		
		
		$q = $conn->prepare($query);
	
		$q->execute(array(':firstname'=>$firstname,		
                  ':lastname'=>$lastname,
				  ':username'=>$username,
				  ':password'=>$password,
				  ':email'=>$email
				  
				  ));



		header("location: indexcopy.php");
		
		//echo "Database updated";
		
} else
{
	header("location: registercopy.php");
}
	
	if($errflag) {
		$_SESSION['ERRMSG_ARR'] = $errmsg_arr;
		session_write_close();
		header("location: registercopy.php");
		exit();
	}



?>