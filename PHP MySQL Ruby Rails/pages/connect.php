<?php

//Connects to the group database.
$hostname="cs4370.com:3306";
$username="g04admin";
$password="C&*%uR-IIQ^1";
$database="group04db"; 
$con=mysql_connect($hostname,$username,$password);

if(! $con)
{
die('Connection Failed'.mysql_error());
}

mysql_select_db($database,$con);

?>