<?php


require_once('config.php');



function showDetails(){

	try {
         $pdo = new PDO(DBCONNSTRING,DBUSER,DBPASS);
         $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


	$sql = "select * from album where name = '".$_GET['title']."'";
         $result = $pdo->query($sql);
         while ($row = $result->fetch()) {
            echo "<h1>Song count: ".$row['songCount']."</h1>";
         }
         $pdo = null;


} catch (PDOException $e) {
      die( $e->getMessage() );
   }

	
}


		 








?>







<!DOCTYPE html>
<html>
<head>
	<title><?php echo "Album"; ?></title>
	<link rel="stylesheet" type="text/css" href="songDetails.css">
</head>
<body>

<?php showDetails(); 

echo "<h1>Test</h1>";	

?>

</body>
</html>