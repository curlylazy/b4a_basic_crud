<?php

require_once("koneksi.php");

$kodeitem = $_POST['kodeitem'];

$arrData = array();
$sql = "SELECT * FROM tbl_item
		WHERE kodeitem = '$kodeitem'";

$result = $conn->query($sql);

if ($result->num_rows > 0) 
{
	while($row = $result->fetch_assoc()) 
	{
		$arrtemp = array(
			"kodeitem" => $row['kodeitem'],
			"kategori" => $row['kategori'],
			"namaitem" => $row['namaitem'],
			"hargaitem" => $row['hargaitem'],
		);

		array_push($arrData, $arrtemp);
	}

	echo json_encode($arrData);
} 
else 
{
  	echo "0 results";
}

$conn->close();

?>