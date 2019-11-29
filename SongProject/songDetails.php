<?php

require_once('config.php');



function showDetails(){

	try {
         $pdo = new PDO(DBCONNSTRING,DBUSER,DBPASS);
         $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


	$sql = "select * from song where name = '".$_GET['name']."'";
         $result = $pdo->query($sql);
         while ($row = $result->fetch()) {
            echo "Song Title: ".$row['name']."<br/>";
            echo "<div class='container'>";

            $title;
            $isAlbum = true;
            if(strcmp("NULL", $row['album'])==0){
            	$title = $row['name'];
            	$isAlbum = false;
            }
            else{
            	$title = $row['album'];
            }
            if($isAlbum){
            echo "<a href='http://localhost/songProject/albumDetails.php/?title=".$title."'>";}
        	
            echo "<img class='thumbnail' src='http://localhost/songProject/images/".$title.".jpeg'><br/>";
            if(strcmp("NULL", $row['album'])==1){
            
            echo "Album: ".$row['album']."</a>";
        		}
            echo "</div><br/>";
            echo "Artist Name: ".$row['aname']."<br/>";
            echo "Genre: ".$row['genre']."<br/>";
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
	<title>Details</title>
	<link rel="stylesheet" type="text/css" href="songDetails.css">
</head>
<body>

<h1>
	<?php

	if (isset($_GET['name'])) {
		
		showDetails();



	}


	?>



</h1>



</body>
</html>