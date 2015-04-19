<?php 
    if ( !empty($_POST)) {
        require ('connect2.php');
        // validation errors
        $fnameError     = null;
        $lnameError     = null;
        
        // post values
        $fname  = $_POST['fname'];
        $lname  = $_POST['lname'];
        
        // validate input
        $valid = true;
        if(empty($fname)) {
            $fnameError = 'Please enter First Name';
            $valid = false;
        }
        
        if(empty($lname)) {
            $lnameError = 'Please enter Last Name';
            $valid = false;
        }
        
        // insert data
        if ($valid) {
            $PDO->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql = "INSERT INTO tbl_persons (firstname,lastname) values(?, ?)";
            $stmt = $PDO->prepare($sql);
            $stmt->execute(array($fname,$lname));
            $PDO = null;
            header("Location: index.php");
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

    <title>Enron Expense Report</title>

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

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Registration Form</h3>
                    </div>
                    <div class="panel-body">
					
					
					

					 <form method="POST" action="">
						<div class="form-group <?php echo !empty($fnameError)?'has-error':'';?>">
							<label for="inputFName">First Name</label>
							<input type="text" class="form-control" required="required" id="inputFName" value="<?php echo !empty($fname)?$fname:'';?>" name="fname" placeholder="First Name">
							<span class="help-block"><?php echo $fnameError;?></span>
						</div>
						<div class="form-group <?php echo !empty($lnameError)?'has-error':'';?>">
							<label for="inputLName">Last Name</label>
							<input type="text" class="form-control" required="required" id="inputLName" value="<?php echo !empty($lname)?$lname:'';?>" name="lname" placeholder="Last Name">
							<span class="help-block"><?php echo $lnameError;?></span>
						</div>
						
						<div class="form-actions">
							<button type="submit" class="btn btn-success">Create</button>
							<a class="btn btn-default" href="index.php">Back</a>
						</div>
							
							
							
							
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
