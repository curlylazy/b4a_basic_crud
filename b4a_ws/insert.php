<?php

require_once("koneksi.php");

$kodeitem = $_POST['kodeitem'];
$kategori = $_POST['kategori'];
$namaitem = $_POST['namaitem'];
$hargaitem = $_POST['hargaitem'];

$sql = "INSERT INTO tbl_item(kodeitem, kategori, namaitem, hargaitem)
		VALUES ('$kodeitem', '$kategori', '$namaitem', '$hargaitem')";

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