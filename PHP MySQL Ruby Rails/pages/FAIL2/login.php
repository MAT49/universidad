<?php
error_reporting(0);
include("/config.php");
checkIfLoggedIn();


if(isset($_POST['submit']))
{
	$username = $_POST['email'];		
	$password = md5($_POST['password']."BLDCL048D2");			

	$q = $conn->prepare('SELECT * FROM tbl_persons WHERE email = ?, password = ?');
	$query = $q->execute(array(
		$username,
		$password
	));

	$count = $q->rowCount();
	if ($count == 1)
	{
		$_SESSION['Email'] = $username;
		header("Location: /index.php");
		return;
	} else
	{
		echo "Wrong password<br />";		
		//header("Location: /login.php");
		//return;
	}
}
?>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div style="background-color:white">

    <div class="container">
        <div class="row">
            <h1 align="middle"><img src="http://www.auplod.com/u/puolad52a33.png"><img/><h1/>
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
								<fieldset>
								<form id='login' action='' method='POST'
                                  accept-charset='UTF-8'>
									<div class="form-group">
										<input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password" name="password" type="password" value="">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<a href="salespersonland.html" class="btn btn-lg btn-success btn-block">Employee Login</a>
									<a href="accountantland.html" class="btn btn-lg btn-success btn-block">Admin Login</a>
									<a href="registration.php" class="btn btn-lg btn-success btn-block">Register</a><br/>
									<a href="forgotpassword.html" class="btn btn-lg btn-danger">Forgot Password?</a>
								</form>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    </div>
</body>

</html>
