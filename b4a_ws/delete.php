<?php

require_once("koneksi.php");

$kodeitem = $_POST['kodeitem'];

$sql = "DELETE FROM tbl_item
		WHERE kodeitem = '$kodeitem'";

if ($conn->query($sql) === TRUE) 
{
	echo "sukses";
} 
else 
{
  	echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>