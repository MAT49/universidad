<?php
session_start();
include("/connection.php");

function checkIfLoggedIn()
{
	if ((!$_SESSION['Email']) == "")
	{
		header("Location: /login.php");
		return;
	}
}

?>