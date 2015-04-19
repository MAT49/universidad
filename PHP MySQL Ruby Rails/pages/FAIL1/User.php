<?php
error_reporting(0);
include_once('connection.php');

class User{
	
	private $db;
		
	public function __construct(){
		$this->db = new Connection();
		$this->db = $this->db->dbConnect();
	}
		
	public function Login($name, $pass){
		$this->db = new Connection();
		$this->db = $this->db->dbConnect();

		if(!empty($name) && !empty($pass)){
			$st = $this->db->prepare("SELECT * FROM tbl_persons WHERE email=? AND password=?");
			$st->bindParam(1, $name);
			$st->bindParam(6, $pass);
			$st->execute();
			
			if($st->rowCount() == 1){
				echo "User verified, Access granted.";
			} else {
				echo "Incorrect email or password";
			}
			
			
		} else {
			echo "Please enter email and password";
		}
	}

}

?>