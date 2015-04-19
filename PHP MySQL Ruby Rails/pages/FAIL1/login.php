<?php

include_once('User.php');


if(isset($_POST['login'])) {
	$name = $_POST['email'];
	$pass = $_POST['pass'];
	
	$object = new User();
	$object->Login($name, $pass);
	
} 


?>



<html>
<head></head>

<body>
	<form method="POST" action="login.php">
		Email: <input type="text" name="email"/>
		Password: <input type="text" name="pass"/>
		<input type="submit" name="login" value="Login"/>
	</form>
</body>

</html>