<?php

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: *');
header('Access-Control-Allow-Headers: *');

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "db_b4a";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
 	die("Connection failed: " . $conn->connect_error);
}

?>