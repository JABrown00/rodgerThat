<?php

require_once('config.php');


function userOption (){


	echo "<table>";
	echo "<tr>";
	echo "<th>What would you like to do?</tr>";
	echo "<br/>";
	echo "<tr>";
	echo "<td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=1'>1. Show all songs</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=2'>2. Show all albums</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=3'>3. Search a song</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=4'>4. Advanced Search</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=5'>5. Create a Playlist</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=6'>6. Select a PLaylist</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=7'>7. Edit a Playlist</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=8'>8. Show All Playlists</a></td></tr>";
	echo "<tr><td><a href = '".$_SERVER['SCRIPT_NAME']."/?option=99'>99. Developer Mode</a></td></tr>";
	echo "</table>";








}



function searchSong($title){
	try {
         $pdo = new PDO(DBCONNSTRING,DBUSER,DBPASS);
         $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


	echo "Searching ".$title." now from database";

	$sql = "select name, aname from song where name LIKE '%".$title."%'";
	$result = $pdo->query($sql);
	if (empty($result)) {
		echo "No song matches ".$title;
	}
	else{
		$counter = 1;
	while($row = $result->fetch()){

		echo "<br/>";
		echo $counter.". <a href='http://localhost/songProject/songDetails.php?name=".$row['name']."'>".$row['name']." by ".$row['aname']."</a><br/>";

		$counter++;
	}//end of while
}//end of else
	$pdo = null;

	}
   catch (PDOException $e) {
      die( $e->getMessage() );
   }


}







function evalUserOption(){
try {
         $pdo = new PDO(DBCONNSTRING,DBUSER,DBPASS);
         $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
         

	if (isset($_GET['option'])){

		echo "<br/>";
		$option = $_GET['option'];

		echo "Option selected: ".$option;
		echo "<br/>";

		if($option == 1){
			$counter = 1;
			echo "Showing all songs<br/>";
			$sql = "select name,aname from song order by name";
         $result = $pdo->query($sql);
         while ($row = $result->fetch()) {
            echo '<a href="http://localhost/songProject/songDetails.php?name=' . $row['name'] . '" class="';
            if (isset($_GET['name']) && $_GET['name'] == $row['name']) echo 'active ';
            echo 'item">';
            echo $counter.". ".$row['name']. ' by '.$row['aname'].'</a><br/>';

            $counter++;
         }
         $pdo = null;





		}
		elseif ($option == 2) {
			echo "<div id = 'albums'>";
         	echo "<table class='listed'> ";
				echo "<tr><th>Showing all albums</th></tr><br/><br/>";
				$sql = "select name,aname from album order by name limit 0,30";
         $result = $pdo->query($sql);
         while ($row = $result->fetch()) {
            echo '<tr><td><a href="http://localhost/songProject/albumDetails.php/?title='.$row['name'].'" class="';
            if (isset($_GET['name']) && $_GET['name'] == $row['name']) echo 'active ';
            echo 'item">';
            echo $row['name']. ' by '.$row['aname'].'</a></td></tr><br/>';
            echo "</div>";
         }
         $pdo = null;
			}	

		elseif ($option == 3) {
			echo "Search a song by title <br/>";
			echo "<form>";
			echo "Title: <br/>";
			echo "<input type='text' name = 'title'><br/>";
			echo "<button type='submit' name = 'submit'>";
			echo "Submit </button>";
			echo "</form>";


		}
		elseif ($option == 4) {
			

		}
		elseif ($option == 99) {

			echo "<form>";
			echo "Type in the password below:<br/>";
			echo "<input type='password' name = 'pass'";
			echo "<button type='submit' name = 'submit'>";
			echo "Submit </button>";
			echo "</form>";

		}

	}
	
   }
   catch (PDOException $e) {
      die( $e->getMessage() );
   }

	
}









?>


<!DOCTYPE html>
<html>
<head>
	<title>songProject</title>
	<link rel="stylesheet" href= "http://localhost/songProject/index.css"> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  
</head>
<body id="body" >
<header>

<div>
<h1>Welcome to your Song Project</h1>
</div><!--end of header div-->


</header>

<div class="container">
	
<div class="row">
	
	<div class="col-md-3">

		<br/>
		<?php 

		userOption(); 
		evalUserOption();

		if(isset($_GET['title'])){
			
			$title = $_GET['title'];
			searchSong($title);
		
		}

		if (isset($_GET['pass'])) {
			
			$pw = $_GET['pass'];
			if (strcmp($pw, DEVPASS)==0) {
				echo "<a href='http://localhost/songProject/developerMode.php'>";
			echo "<button type='submit' name = 'submit'>";
			echo "Enter Developer Mode </button></a>";
			}
			else{

				echo "<h3>Sorry... You aren't authorized for Developer Mode!</h3>";

			}

		}

		?>

	</div>

</div>



</div>





</body>
</html>
