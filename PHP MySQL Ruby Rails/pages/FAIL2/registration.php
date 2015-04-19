<?php
error_reporting(0);
include("/connection.php");

$fname = $_POST['fname'];
$lname = $_POST['lname'];
$email = $_POST['email'];
$password = md5($_POST['password']."BLDCL048D2");
$confirm = md5($_POST['confirm']."BLDCL048D2");
$department = $_POST['department'];
echo "test";
if(isset($fname, $lname, $email, $password, $confirm, $department))
{
	if($password == $confirm )
	{
		$query = $conn->prepare("SELECT * FROM tbl_persons WHERE last_name = ? OR email = ? ");
		$query = $query->execute(array(
			$lname,
			$email
		));
		$count = mysql_num_rows($query);
		//$count = $query->rowCount();
		if($count == 0 )
		{
			$query = $conn->prepare("INSERT INTO tbl_persons SET first_name = ?, last_name = ?, email = ?, password = ?, department_id = ?");
			$query = $query->execute(array(
				$fname, 
				$lname, 
				$email, 
				$password, 
				$department
			));
			if($query)
			{
				echo "Your account has been registered, you may login";
			}
		} else
		{
			echo "A user already exists with that name/email";
		}

	} else
	{
		echo "Passwords do not match! Please try again.";
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

    <title>Register</title>

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
                    <h3 class="panel-title">Registration Form</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <form id='register' action='' method='POST' accept-charset='UTF-8'>                                
                                    <div class="form-group">
                                        <input class="form-control" placeholder="First Name" name="fname" type="fname" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Last Name" name="lname" type="lname" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="E-mail" name="email" type="email" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Enter Password" name="password" type="password" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Confirm Password" name="confirm" type="confirm" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Department" name="department" type="department" value="">
                                    </div>
                                </form>
                            <!-- Change this to a button or input when using this as a form 
							<a href="index.html" class="btn btn-lg btn-success btn-block">Register</a> -->
							<input type="submit" name="submit" value="Register">
                            
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

</body>

</html>
