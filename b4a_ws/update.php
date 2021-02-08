<?php

require_once("koneksi.php");

$kodeitem = $_POST['kodeitem'];
$kategori = $_POST['kategori'];
$namaitem = $_POST['namaitem'];
$hargaitem = $_POST['hargaitem'];

$sql = "UPDATE tbl_item SET
			kategori = '$kategori',
			namaitem = '$namaitem',
			hargaitem = '$hargaitem'
		WHERE
			kodeitem = '$kodeitem'
		";

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