
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;


public class songProject {

	static final int MAX_N = 9999999;
	static final boolean DEBUG = false;

    public static void main(String args[]) {
	
	Scanner kbd = new Scanner(System.in);
	boolean cont = true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

	if(DEBUG){

            Statement stat = mycon.createStatement();
            ResultSet rs = stat.executeQuery("select * from album");

            while (rs.next())
                System.out.println(rs.getString(1) + "," +
                      rs.getString(2) + "," + rs.getDate(3) + "," + rs.getString(4)
			+ "," + rs.getInt(5));

	}//end of debug print

		System.out.println();

	do{

	try{

	int userChoice = getUserOption();
	switch(userChoice){

		case 1:
			System.out.println("Printing all songs");
			System.out.println("");
			printAllSongs();
			break;
		case 2:
			System.out.println("Printing all albums");
			System.out.println("");
			printAllAlbums();
			break;
		case 3:
			System.out.println("Type in the song title: ");
			String title = kbd.nextLine();
			searchSongTitle(title);
			break;
		case 4:
			System.out.println("Title your playlist:");
			String playTitle = kbd.nextLine();
			addPlaylist(playTitle);
			break;
		case 5:
			System.out.println("Advanced Search:");
			advSearch();
			break;
		case 6:
			System.out.println("Which playlist would you like to edit?");
			String playName = kbd.nextLine();
			editPlaylist(playName);
			break;
		case 7:			
			selectPlaylist();
			break;
		case 8:
			printPlaylists();
			break;
		case 99:
			boolean temp = verifyDev();			
			if(temp)
				developerMode();
			else
				System.out.println("Sorry... You aren't authorized!");
			break;
		default:
			System.out.println("Default option");
			System.out.println("Goodbye!");
			cont = false;

			}//end of switch

		} catch (InputMismatchException e){
		
			System.out.println("Goodbye!");
			return;

					}//end of try-catch

	}while(cont);//end of do-while


            mycon.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//end of main method





/*--------------------------------------------------------------------------------------------------*/



//GET OPTIONS




	
	public static int getDevOption(){

	Scanner kbd = new Scanner(System.in);
	System.out.println("What would you like to do?");
	System.out.println("1. Add a song");
	System.out.println("2. Add an album");
	System.out.println("3. Print all songs");
	System.out.println("4. Print all albums");
	System.out.println("5. Delete a playlist");
	System.out.println("6. Add a playlist");
	System.out.println("7. Show all playlists");
	System.out.println("Any other button: Exit");
	int choice = kbd.nextInt();
	return choice;
  	}   //end of getDevOption


	public static int getUserOption(){

	Scanner kbd = new Scanner(System.in);
	System.out.println("What would you like to do?");
	System.out.println("1. Print all songs");
	System.out.println("2. Print all albums");
	System.out.println("3. Search a song");
	System.out.println("4. Create a playlist");
	System.out.println("5. Advanced Search");
	System.out.println("6. Edit playlist");
	System.out.println("7. Select a playlist");
	System.out.println("8. Show all playlists");
	System.out.println("99. Enter Developer Mode");
	System.out.println("Any other button: Exit");
	int choice = kbd.nextInt();
	return choice;
  	}   


//end of getUserOption

	



/*--------------------------------------------------------------------------------------------------*/





//ADD SONG




	public static void addSong(){

	char testChar = 'd';

	Scanner kbd = new Scanner(System.in);
	 try {
            Connection mycon2 = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



	String query = "insert into song values (?,?,?,?,?,?,?,?,?)";

	PreparedStatement song = mycon2.prepareStatement(query);

	try {

	//int temp = 1; //for error message printing

	System.out.println("Enter song name: ");
	String songName = kbd.nextLine();
	/*if(Character.isDigit(songName)==0)
		songName = "'" + songName + "'"; */
	song.setString(1,songName);
	System.out.println("Enter song length: ");
	String temp = kbd.nextLine();
	
	char letter;
	double songLength= 0.00;
	int length = temp.length();
	/*for(int i = 0; i < length;i++){
		letter = temp.charAt(i);
		if(Character.isLetter(testChar) = 0)
			throw new SongLengthError();}
	System.out.println("No error");*/
	songLength = Double.parseDouble(temp);
	song.setDouble(2,songLength);
	System.out.println("Enter song size: ");
	double songSize = kbd.nextDouble();
	song.setDouble(3,songSize);
	//System.out.println("Enter artist name: ");
	/*String artistName = */kbd.nextLine();
	//song.setString(4,artistName);
	System.out.println("Enter artist name: ");
	String artistName = kbd.nextLine();
	song.setString(4,artistName);
	System.out.println("Enter album name: ");
	String albumName = kbd.nextLine();
	song.setString(5,albumName);
	System.out.println("Enter genre: ");
	String genre = kbd.nextLine();
	song.setString(6,genre);
	System.out.println("Enter release date: ");
	String relDate = kbd.nextLine();
	song.setString(7,relDate);
	System.out.println("Enter featured artist's name: ");
	String aFeat = kbd.nextLine();
	song.setString(8,aFeat);
	System.out.println("Enter language: ");
	String lang= kbd.nextLine();
	song.setString(9,lang);

	song.executeUpdate();	

	song.close();
	mycon2.close();

	}	
	catch (SongLengthError e){



				}//end of songLengthException

	catch (InputMismatchException e){
		
	

		System.out.println("Error...");


				}//end of inputMismatch try-catch

	catch (NumberFormatException e){
		
	

		System.out.println("Error...");


				}//end of inputMismatch try-catch

	} catch (SQLException e) {
            e.printStackTrace();
       
			 }//end of SQL try-catch

	}


//end of addSong





/*--------------------------------------------------------------------------------------------------*/




//ADD ALBUM




	public static void addAlbum(){


		Scanner kbd = new Scanner(System.in);
	 try {
            Connection mycon2 = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



	String query = "insert into album values (?,?,?,?,?)";

	PreparedStatement album = mycon2.prepareStatement(query);

	System.out.println("Enter album name: ");
	String albumName = kbd.nextLine();
	album.setString(1,albumName);
	System.out.println("Enter album length (hh:mm:ss): ");
	String albumLength = kbd.nextLine();
	album.setString(2,albumLength);
	System.out.println("Enter release date: ");
	String relDate = kbd.nextLine();
	album.setString(3,relDate);
	System.out.println("Enter artist name: ");
	String artistName = kbd.nextLine();
	album.setString(4,artistName);
	System.out.println("Enter song count: ");
	int count = kbd.nextInt();
	album.setInt(5,count);
	

	album.executeUpdate();	

	album.close();
	mycon2.close();
	} catch (SQLException e) {
            e.printStackTrace();
        }



}//end of addAlbum




/*--------------------------------------------------------------------------------------------------*/



//PRINT ALL SONGS



	public static void printAllSongs(){


	try {
            Connection mycon3 = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

	Statement all = mycon3.createStatement();
	ResultSet rs = all.executeQuery("select * from song;");

	int counter = 1;
	 while (rs.next()){

                System.out.println("#"+counter+" Song name: " + rs.getString(1) + ", Song length: " +
                rs.getDouble(2) + "(M:ss), Song size " + rs.getDouble(3) + 
		"(MB), Artist Name: " + rs.getString(4) + ", Album Name: " + rs.getString(5) + 
		", Genre: " + rs.getString(6) + ", Release Date: " + rs.getDate(7) + 
		"(YYYY-MM-dd), Featured Artist(s):  " + rs.getString(8) + 
		", Language: " + rs.getString(9) );

		counter++;

		System.out.println();
				}
	

		}catch(SQLException e){e.printStackTrace();}//end of try catch
	
		return;	
	
	}

//end of printAllSongs




/*--------------------------------------------------------------------------------------------------*/



//PRINT ALL ALBUMS



	public static void printAllAlbums(){


	try {
            Connection mycon3 = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

	Statement all = mycon3.createStatement();
	ResultSet rs = all.executeQuery("select * from album;");

	int counter = 1;
	 while (rs.next()){

                System.out.println("#"+counter+" Album name: " + rs.getString(1) + ", Album length: " 			+ rs.getString(2) + "(hh:mm:ss), Artist Name: " + rs.getString(4) + ",Release Date: " 			+ rs.getDate(3) + "(YYYY-MM-dd), Song Count:  " + rs.getInt(5) );

		counter++;

		System.out.println();
				}
	

		}catch(SQLException e){e.printStackTrace();}//end of try catch
	
		return;	
	
	}



//end of printAllAlbums





/*--------------------------------------------------------------------------------------------------*/




//VERIFY DEV



	public static boolean verifyDev(){
		
		boolean dev;
		Scanner kbd = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Type in the password to enter developer mode: ");
		String pass = kbd.nextLine();

		if(pass.compareTo("") == 0)
			dev = true;

		else
			dev = false;

		return dev;
		

}

//end of verifyDev





/*--------------------------------------------------------------------------------------------------*/




//DEVELOPER MODE



	public static void developerMode(){

	Scanner kbd = new Scanner(System.in);

	System.out.println("Welcome to Developer Mode!");
	System.out.println();



	boolean cont = true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");
	

		System.out.println();


	try {

	

	do{


	

		int userChoice = getDevOption();
		
		
			

						

	switch(userChoice){

		case 1:
			System.out.println("Adding a song");
			System.out.println("");
			addSong();
			break;
		case 2:
			System.out.println("Adding an album");
			System.out.println("");
			addAlbum();
			break;
		case 3:
			System.out.println("Printing all songs");
			System.out.println("");
			printAllSongs();
			break;
		case 4:
			System.out.println("Printing all albums");
			System.out.println("");
			printAllAlbums();
			break;
		case 5:
			devDeletePlaylist();
			break;
		case 6:
			System.out.println("Title your playlist: ");
			String playName = kbd.nextLine();
			addPlaylist(playName);
			break;
		case 7:
			printPlaylists();
			break;
		default:
			System.out.println("Default option");
			System.out.println("Goodbye!");
			cont = false;

			}//end of switch

		


	}while(cont);//end of do-while

	
	} catch(InputMismatchException e){

			System.out.println("Returning to main menu...");
			return;


					}//end of input mismatch try-catch


            mycon.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }





}

//end of developer mode




/*--------------------------------------------------------------------------------------------------*/


//SEARCH SONG BY TITLE


	public static void searchSongTitle(String title){

		Scanner kbd = new Scanner(System.in);

		String[] songArray = new String[MAX_N];
		String[] artistArray = new String[MAX_N]; 

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

			String query = "select name, aname from song where name LIKE '%" + 
					title + "%'";
			Statement search = mycon.createStatement();
			ResultSet songs = search.executeQuery(query);
		
			int i = 0;
			int counter = 0;

			if(songs.next()==false){

				System.out.println("No songs match: '"+title+"'");

					}//end of no-match if

			else {


			songs = search.executeQuery(query);			
			
			while(songs.next()){

				songArray[counter] = songs.getString(1);
				artistArray[counter] = songs.getString(2);			
				counter++;

					}//end of while for storing

			

			//Print out song list

			while(i >=0 && i<counter){

				System.out.println("#"+(i+1)+": "+songArray[i]+ " by: "+ 
				artistArray[i]);
				System.out.println();
				
				i++;
					}//end of printing songs




			//Ask which song to play

			try{

			int choice = 0;
			System.out.println("Select which song to play or "+
					"type any other button to return to the main "+
					"menu" );
			choice = kbd.nextInt();		
			System.out.println();			

			if(choice > 0 && choice <= counter){
				choice--;
				String songToPlay = songArray[choice];
				if(DEBUG)
					System.out.println("Song to play: " + songToPlay);
				playSong(songToPlay);
					}//end of if

			}catch(InputMismatchException e){return;}


			}//end of no match if-else
						
		
		} catch(SQLException e){e.printStackTrace();}//end of try-catch

	//return "";

}

//end searchSongTitle







/*--------------------------------------------------------------------------------------------------*/






//ADVANCED SEARCH





	public static void advSearch(){

		Scanner kbd = new Scanner(System.in);


		try{

			System.out.println("What would you like to search for? ");
			System.out.println();
			System.out.println("1. Search all singles");
			System.out.println("2. Search by artist");
			System.out.println("3. Search by genre");
			System.out.println("4. Search by language");
			System.out.println("5. Search all instrumentals");
			System.out.println("(Any other button will quit)");
			System.out.println();



			int choice = kbd.nextInt();
			

			switch (choice){

				case 1:
					searchSingles();
					break;
				case 2: 
					searchByArtist();
					break;
				case 3:
					searchByGenre();
					break;
				case 4:
					searchByLang();
					break;
				case 5:
					searchInstrumentals();
					break;
				default:
					return;


					}//end of switch


			} catch(InputMismatchException e){

				if(DEBUG)
					e.printStackTrace();
				System.out.println("Returning to main menu...");

							}//end of invalid input try-catch

	}


//end of advSearch






/*--------------------------------------------------------------------------------------------------*/





//PLAY SONG




	public static void playSong(String title){

		String name = "";
		String artist = "";

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");


		String query = "select name, aname from song where name = '" + 
					title + "'";
			Statement search = mycon.createStatement();
			ResultSet song = search.executeQuery(query);

			while(song.next()){
			
				name = song.getString(1);
				artist = song.getString(2);

				}//end of while

		//Print out song playing
/*
		System.out.println("Now playing: " + name + " by " + artist);
		System.out.println();
*/

		JOptionPane.showMessageDialog(null,"Now playing: " + name + " by " +
					 artist);		

		//Show recommendations in same genre


		showRecommendations(name,artist);


		}catch(SQLException e){e.printStackTrace();}

	}

//end of playSong






/*--------------------------------------------------------------------------------------------------*/





//ADD PLAYLIST




	public static void addPlaylist(String title){
			
		//check if first playlist
		playlistTable();
	
		//create playlist
		Playlist play1 = new Playlist(title);

		//add to PLAYLISTS table
		addToList(title);


		//display message if successfully created
		JOptionPane.showMessageDialog(null, "Your playlist was added successfully!\n "+
		"Click ok" );

	}

//end of addPlaylist






/*--------------------------------------------------------------------------------------------------*/




//EDIT PLAYLIST


	public static void editPlaylist(String title){

		title = title.toUpperCase();
		Scanner kbd = new Scanner(System.in);

		try {
            	Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



		//Check if playlist exists
		
		int i = -1;
		while(i == -1){

		

		try {

			int length = title.length();
			for(int j = 0; j < length;j++){
				char letter = title.charAt(j);
				if(Character.isDigit(letter)==true){

					throw new SQLException();
				}
			}


		String query = "create table " + title +" (song varchar(40), length DOUBLE, "+
				"aname varchar(40), album varchar(40), genre varchar(40), "+
				"afeatured varchar(40), lang varchar(20)," +
				" PRIMARY KEY (song,album))";
		

		Statement stat = mycon.createStatement();
		stat.executeUpdate(query);

			} catch(SQLException e){


				if(DEBUG)
					e.printStackTrace();
				i = 1;
			
				if(DEBUG)
					System.out.println("Table exists!! "+
						"\n i: "+ i);				
						
						}//end of try-catch

				
		if(i == -1){

			String query = "drop table " + title;
		

		Statement stat = mycon.createStatement();
		stat.executeUpdate(query);
	
			System.out.println("Playlist doesn't exist! Would you like to: \n"+ 
						"1. Create a playlist\n2. Return to menu "+
						"(Any other button will return to menu)?");

			int choice = kbd.nextInt();
			switch (choice){
		

				case 1:
					System.out.println("Title your playlist: ");
					String play = kbd.nextLine();
					addPlaylist(play);
					break;
				default:
					return;
					}//end of switch
					

				}//end of if

			}//end of while

		System.out.println("What would you like to do?");
		
		try {

		System.out.println("1. Add a song");
		System.out.println("2. Remove a song");
		System.out.println("3. Delete Playlist");
		System.out.println("(Any other button will quit)");

		int choice = kbd.nextInt();
		switch (choice){

			case 1: 
				addPlaylistSong(title);
				break;
			case 2: 
				removePlaylistSong(title);
				break;
			case 3:
				deletePlaylist(title);
				break;
			default:
				return;

				}//end of switch


			} catch(InputMismatchException e){

				System.out.println("Returning to main menu...");
				return;
							}//end of quitting try-catch


		} catch(SQLException e){e.printStackTrace();} //end of SQL try-catch


	}

//end of editPlaylist 





/*--------------------------------------------------------------------------------------------------*/




//ADD SONG TO PLAYLIST


	public static void addPlaylistSong(String title){

		String[][] songOptions = new String[MAX_N][2];
		Scanner kbd = new Scanner(System.in);

		try {
            	Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");


		//Ask for song and artist name

		System.out.println("Which song would you like to add to "+title+"?");
		
		System.out.println("Type in the song name: ");
		String songName = kbd.nextLine();
		System.out.println("Type in the artist name: ");
		String artistName = kbd.nextLine();

		String query = "select name,aname from song";

		Statement stat = mycon.createStatement();
		ResultSet rs = stat.executeQuery(query);

		int counter = 0;
		
		//storing process
		while(rs.next()){
			songOptions[counter][0]= rs.getString(1);
			songOptions[counter][1]= rs.getString(2);
			counter++;

			}
		if (DEBUG)
			System.out.println("Successfully stored "+ counter + " songs!");


		//matching

		int i = 0;
		do{

			if(songOptions[i][0].compareToIgnoreCase(songName) == 0 &&
				songOptions[i][1].compareToIgnoreCase(artistName) ==0){

				if(DEBUG)
					System.out.println("Match");
				i = -1;

				} //end of if


			else{i++;}


				} //end of do
			while(i < counter && i != -1);


		//if no matches, suggest alternate options

		if(i >= counter){

			if(DEBUG)
				System.out.println("No matches");

			return;

				}//end of no matches if



		if(DEBUG)
			System.out.println("Continuing...");


		//Check if song is already in playlist

		String songCheck = "";
		String artistCheck = "";
		query = "select song,aname from "+title;
		if(DEBUG)
			System.out.println("set the query to "+query);
		stat = mycon.createStatement();
		rs = stat.executeQuery(query);
		while (rs.next()){
			
			if(DEBUG)
				System.out.println("In while for checking playlist");
			
			songCheck = rs.getString(1);
			artistCheck = rs.getString(2);

			if(DEBUG)
				System.out.println(""+songCheck +" "+artistCheck+
						" current song/artist");

				}

		if(songCheck.compareToIgnoreCase(songName)== 0 &&
		artistCheck.compareToIgnoreCase(artistName) == 0){

			System.out.println("Song is already in"+
			" playlist!");
			System.out.println("Returning to main menu...");
			return;				
							}//end of if


		//get the necessary info from matching song

		query = "select name,length,aname,album,genre,afeatured,lang from song "+
			"where name = '"+songName+"' and aname = '"+artistName+"'";


		String name = "";
		double length = 0;
		String aname = "";
		String album = "";
		String genre = "";
		String afeatured = "";
		String lang = "";

		stat = mycon.createStatement();
		rs = stat.executeQuery(query);


		

			if (rs.next()==false){
				System.out.println(songName + " by " + artistName +
						" doesn't exists!");

						}//end of empty if

		rs = stat.executeQuery(query);

		while(rs.next()){

			name = rs.getString(1);
			length = rs.getDouble(2);
			aname = rs.getString(3);
			album = rs.getString(4);
			genre = rs.getString(5);
			afeatured = rs.getString(6);
			lang = rs.getString(7);


				}//end of while

		
		query = "insert into "+title+" values (?,?,?,?,?,?,?)";
		PreparedStatement insert = mycon.prepareStatement(query);

		insert.setString(1,name);
		insert.setDouble(2,length);
		insert.setString(3,aname);
		insert.setString(4,album);
		insert.setString(5,genre);
		insert.setString(6,afeatured);
		insert.setString(7,lang);

		insert.executeUpdate();


		//increment songCount in PLAYLISTS

		query = "update PLAYLISTS set songCount = songCount + 1 where playlistName "+
			"= '"+title+"'";
		Statement update = mycon.createStatement();
		update.executeUpdate(query);

		System.out.println();
			} catch(SQLException e){e.printStackTrace();} //end of SQL try-catch


	}	

//end of addPlaylistSong



/*--------------------------------------------------------------------------------------------------*/




//REMOVE SONG FROM PLAYLIST



	public static void removePlaylistSong(String title){

		String[][] songOptions = new String[MAX_N][2];
		Scanner kbd = new Scanner(System.in);

		boolean decision = true;


		try {
            	Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");


		//Ask for song and artist name

		System.out.println("Which song would you like to remove from "+title+"?");
		
		System.out.println("Type in the song name: ");
		String songName = kbd.nextLine();
		System.out.println("Type in the artist name: ");
		String artistName = kbd.nextLine();

		String query = "select song,aname from "+title+"";

		Statement stat = mycon.createStatement();
		ResultSet rs = stat.executeQuery(query);

		int counter = 0;
		
		if(rs.next()==false){

			System.out.println("No songs in playlist!\nReturning to main menu...");
			

					}//end if
			
		

		rs = stat.executeQuery(query);
			
		//storing process
		while(rs.next()){
			songOptions[counter][0]= rs.getString(1);
			songOptions[counter][1]= rs.getString(2);
			counter++;

			}//end of while
		if (DEBUG)
			System.out.println("Successfully stored "+ counter + " songs!");


		//matching

		int i = 0;
		do{

			if(songOptions[i][0].compareToIgnoreCase(songName) == 0 &&
				songOptions[i][1].compareToIgnoreCase(artistName) ==0){

				if(DEBUG)
					System.out.println("Match");

				
				i = -1;

				} //end of if


			else{i++;}


				} //end of do
			 while(i < counter && i != -1);


		//if no matches, suggest alternate options

		if(i >= counter){

			
			System.out.println("'"+songName+"' isn't in "+title );
			//System.out.println("Returning to main menu" );
			//return;

				decision = false;

				}//end of no matches if


		
		if(decision){

		
		if(DEBUG)
			System.out.print("Continuing...");


		

				//Delete song
			
		if(DEBUG)
			System.out.println("Deleting "+songName+ " by "+artistName+" from playlist" 						+ " "+title+"..." );

		query = "delete from "+title+" where song = '"+songName+"' and aname = '"+
			artistName+"'";
		PreparedStatement delete = mycon.prepareStatement(query);


		delete.executeUpdate();

		//Decrement songCount in PLAYLISTS


		query = "update PLAYLISTS set songCount = songCount - 1 where playlistName "+
			"= '"+title+"'";
		Statement update = mycon.createStatement();
		update.executeUpdate(query);

		System.out.println(songName + " by "+artistName + " was deleted successfully!");
		}//end of if decision



			} catch(SQLException e){


				if(DEBUG)
					e.printStackTrace();


						} //end of SQL try-catch




		


	}

//end of removePlaylistSong





/*--------------------------------------------------------------------------------------------------*/




//DELETE PLAYLIST




	public static void deletePlaylist(String title){


		Scanner kbd = new Scanner(System.in);

		try {
            	Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

		System.out.println("Are you sure you want to delete "+title);
	
		boolean delete = false;
		System.out.println("Y or N?");
		System.out.println("(Default is N)");
		String temp = kbd.nextLine();
		char choice = temp.charAt(0);
		if(DEBUG)
			System.out.println("choice = "+choice);
		switch	(choice) {
			case 'Y':
			case 'y':
				if (DEBUG)
					{System.out.println("Selected Yes");}
				
				delete = true;
				break;
			case 'N':
			case 'n':
				if (DEBUG)
					{System.out.println("Selected No");}
				break;
			default:
				return;
			
				}//end of switch statement

		if(delete)
			{


			String query = "DROP TABLE "+title;
			Statement drop = mycon.createStatement();
			drop.executeUpdate(query);

			//Remove playlist from PLAYLISTS

			removeFromList(title);

			if(DEBUG){
				System.out.println(title + " was deleted successfully!");
				}//end of debug if
			}//end of if
		else{return;}


	



		} catch(SQLException e){e.printStackTrace();}//end of sql try-catch


	}

//end of deletePlaylist





/*--------------------------------------------------------------------------------------------------*/




















//SHOW RECOMMENDATIONS




	public static void showRecommendations(String name, String artist){

		String recName = "";
		String recArtist = "";
		String[] recs = new String[MAX_N];

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");
		


		String query = "select genre from song WHERE name = '" +
				name + "' and aname = '" + artist + "'";

		String genre = "";
		Statement temp = mycon.createStatement();
		ResultSet rs = temp.executeQuery(query);

		while(rs.next())
			genre = rs.getString(1);

		query = "select S.name, S.aname from song S where S.genre LIKE '%" + genre +
			 "%' AND S.name != '" + name+ "'";
		Statement rec = mycon.createStatement();
		rs = rec.executeQuery(query);

		if(rs.next()== false){}

		else {
		
		rs = temp.executeQuery(query);

		System.out.println("You also might like these songs:");
		System.out.println();
		
		int counter = 1;
		while(rs.next()){

			recName = rs.getString(1);
			recArtist = rs.getString(2);			
			System.out.println(counter + ". "+ recName + " by " + recArtist);
			System.out.println();
			counter++;
			}//end of while 		

		
		}//end of if-else

		} catch(SQLException e){e.printStackTrace();}


	}

//end of showRecommendations







/*--------------------------------------------------------------------------------------------------*/





//SEARCH SINGLES





	public static void searchSingles(){


		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



		

		String query = "select name,aname from song where album = 'NULL'";		

		Statement state = mycon.createStatement();
		ResultSet search = state.executeQuery(query);

		int i = 1;
		while(search.next()){

			String song = search.getString(1);
			String artist = search.getString(2);

			System.out.println(i+". "+song+" by: "+artist);		

			i++;
					}



			} catch(SQLException e) {e.printStackTrace();}




	}
	
//end of searchSingles





/*--------------------------------------------------------------------------------------------------*/





//SEARCH BY ARTIST




	public static void searchByArtist(){


		Scanner kbd = new Scanner(System.in);

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



		String query = "select distinct(aname) from song order by aname";

		String[] artistArray= new String[MAX_N];
		Statement stat = mycon.createStatement();
		ResultSet rs = stat.executeQuery(query);
		

		int i = 0;
		int j = 1;
		int choice = 0;
		int temp = 0;
		while(rs.next()){


			artistArray[i]=rs.getString(1);
			System.out.println(""+j+": " + artistArray[i]);
			i++;
			j++;
				}//end of while

			try {

			System.out.println("Pick an artist above");
			System.out.println("(Any other button will return to "+
						"main menu)");			
			temp = kbd.nextInt();
			choice = --temp;
			if(DEBUG)
				System.out.println("choice = " + choice);
			if(choice < 0){
				
				throw new InputMismatchException();


					}//end of if invalid input

				} catch(InputMismatchException e){

					System.out.println("Returning to main menu...");
					return;
								}//end of mismatch try-catch
						 
			query = "select name,aname from song where aname LIKE '%"+
				artistArray[choice]+"%'";

			String[][] songArray= new String[MAX_N][3];

			rs = stat.executeQuery(query);
		
			i = 0;
			j = 1;
			System.out.println();
			while(rs.next()){
				songArray[i][0]=rs.getString(1);
				songArray[i][1]=rs.getString(2);
				System.out.println(""+j+": " + songArray[i][0] + " by: " + 
							songArray[i][1]);
				i++;
				j++;
					}//end of while

			query = "select name,aname,afeatured from song where afeatured LIKE '%"+
				artistArray[choice]+"%'";
			rs = stat.executeQuery(query);
			
			
			while(rs.next()){
				songArray[i][0]=rs.getString(1);
				songArray[i][1]=rs.getString(2);
				songArray[i][2]=rs.getString(3);
				System.out.println(""+j+": " + songArray[i][0] + " by: " + 
							songArray[i][1] + " feat. "+
							songArray[i][2]);
				i++;
				j++;
					}//end of while
			try {

			System.out.println("Pick a song above to play it");
			System.out.println("(Any other button will return to "+
						"main menu)");			
			temp = kbd.nextInt();
			choice = --temp;


			if(temp < 0 || temp >= i )
				{throw new InputMismatchException();}

				} catch(InputMismatchException e){

					System.out.println("TEMPReturning to main menu...");
					return;
								}//end of mismatch try-catch

			if(choice <0 || choice >= j){

				System.out.println(" CHOICEReturning to main menu...");
				return;

							}//end of if invalid choice

			else{playSong(songArray[choice][0]);}

			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();


						}//end of sql try-catch

	}

//end of searchByArtist







/*--------------------------------------------------------------------------------------------------*/






//SEARCH BY GENRE





	public static void searchByGenre(){

		Scanner kbd = new Scanner(System.in);

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



		String query = "select distinct (genre) from song order by genre";

		String[] genreArray= new String[MAX_N];
		String[][] songArray= new String[MAX_N][2];
		Statement stat = mycon.createStatement();
		ResultSet rs = stat.executeQuery(query);
		

		int i = 0;
		int j = 1;
		while(rs.next()){


			genreArray[i]=rs.getString(1);
			System.out.println(""+j+": " + genreArray[i]);
			i++;
			j++;
				}//end of while for storing

			System.out.println("Pick a genre above");

			int temp = kbd.nextInt();
			
			int choice = --temp;

			

						 
			query = "select name,aname from song where genre = '"+
				genreArray[choice]+"'";

			rs = stat.executeQuery(query);

			i = 0;
			j = 1;
			while(rs.next()){

				songArray[i][0]=rs.getString(1);
				songArray[i][1]=rs.getString(2);
				System.out.println(""+j+": " + songArray[i][0] + " by: " + 
							songArray[i][1]);
				i++;
				j++;
				


						}//end of printing while



			try {

			System.out.println("Pick a song above to play it");
			System.out.println("(Any other button will return to "+
						"main menu)");			
			temp = kbd.nextInt();
			choice = --temp;


			if(temp < 0 || temp >= i )
				{throw new InputMismatchException();}

				} catch(InputMismatchException e){

					System.out.println("Returning to main menu...");
					return;
								}//end of mismatch try-catch

			if(choice <0 || choice >= j){

				System.out.println("Returning to main menu...");
				return;

							}//end of if invalid choice

			else{playSong(songArray[choice][0]);}


			
			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();
	
						}//end of sql try-catch





	}

//end of searchByGenre






/*--------------------------------------------------------------------------------------------------*/





//SEARCH BY LANGUAGE




	public static void searchByLang(){


		Scanner kbd = new Scanner(System.in);

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");

		int choice=0;

		String query = "select distinct (LANG) from song order by lang";

		String[] langArray= new String[MAX_N];
		String[][] songArray= new String[MAX_N][2];
		Statement stat = mycon.createStatement();
		ResultSet rs = stat.executeQuery(query);
		

		int i = 0;
		int j = 1;
		while(rs.next()){

			if(rs.getString(1).compareToIgnoreCase("NULL")==0)
				{}			
			else	{

			langArray[i]=rs.getString(1);

			String temp = langArray[i];

			switch(temp){

				case "en":
					temp = "English";
					break;
				case "span":
					temp = "Spanish";
					break;
				case "en/span":
					temp = "English/Spanish";
					break;
				default:
					temp = "English";



					}//end of switch

			System.out.println(""+j+": " + temp);
			i++;
			j++;
					}//end of null if-else

				}//end of while for storing

			try {

			System.out.println("Pick a language above");

			int temp = kbd.nextInt();
			
			choice = --temp;

			if(choice < 0 || choice >= j )
				{throw new InputMismatchException();}


						 
			query = "select name,aname from song where lang= '"+
				langArray[choice]+"'";

			rs = stat.executeQuery(query);

			i = 0;
			j = 1;
			while(rs.next()){

				songArray[i][0]=rs.getString(1);
				songArray[i][1]=rs.getString(2);
				System.out.println(""+j+": " + songArray[i][0] + " by: " + 
							songArray[i][1]);
				i++;
				j++;
				


						}//end of printing while



			

			System.out.println("Pick a song above to play it");
			System.out.println("(Any other button will return to "+
						"main menu)");			
			temp = kbd.nextInt();
			choice = --temp;

			

			if(choice < 0 || choice >= j )
				{throw new InputMismatchException();}

				} catch(InputMismatchException e){

					System.out.println("TEMP Returning to main menu...");
					return;
								}//end of mismatch try-catch
/*
			if(choice < 0 || choice > j){

				System.out.println("CHOICE Returning to main menu...");
				return;

							}//end of if invalid choice
*/
			playSong(songArray[choice][0]);


			
			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();
	
						}//end of sql try-catch







	}

//end of searchByLANG






/*--------------------------------------------------------------------------------------------------*/





//SELECT A PLAYLIST






	public static void selectPlaylist(){

		String title = "";
		int decider = 0;
		Scanner kbd = new Scanner(System.in);

		try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");



		System.out.println("Which playlist would you like to select?");
		title = kbd.nextLine();
		title = title.toUpperCase();


		//Check if playlist exists
		
		int i = -1;

		while(i == -1){

		

		try {

			int length = title.length();
			for(int j = 0; j < length;j++){
				char letter = title.charAt(j);
				if(Character.isDigit(letter)==true){

					throw new SQLException();
				}//end of if
			}//end of for


		String query = "create table " + title +" (song varchar(40), length DOUBLE, "+
				"aname varchar(40), album varchar(40), genre varchar(40), "+
				"afeatured varchar(40), lang varchar(20)," +
				" PRIMARY KEY (song,album))";
		

		Statement stat = mycon.createStatement();
		stat.executeUpdate(query);

			} catch(SQLException e){


				if(DEBUG)			
					e.printStackTrace();
				i = 1;

				if(DEBUG)				
					System.out.println("Table exists!! "+
						"\n i: "+ i);				
			}//end of try-catch

				
		if(i == -1){	
			String query = "drop table " + title;
		

		Statement stat = mycon.createStatement();
		stat.executeUpdate(query);
			
		try {

			System.out.println("Playlist doesn't exist! Would you like to: \n"+ 
						"1. Create a playlist\n2. Return to menu \n "+
						"(Any other button will return to menu)?");

			int choice = kbd.nextInt();
			kbd.nextLine();
			switch (choice){
		

				case 1:
					System.out.println("Title your playlist: ");
					title = kbd.nextLine();
					addPlaylist(title);
					i = 1;
					break;
				default:
					i = 0;
					}//end of switch
					


		} catch(InputMismatchException e){

			System.out.println("Returning to main menu...");
			return;


						}//end of inputMismatch exception


				}//end of if



			}//end of while

		if(i==0){

			return;

			}//end of if

		else{		
	
		title = title.toUpperCase();

		
			System.out.println("Selected: "+title);
			System.out.println();

		int choice;
		boolean quit = false;
		while(!quit) {

		choice = 0;

		

		try {

		System.out.println("What would you like do?");
		System.out.println("1. Print all songs");
		System.out.println("2. Play a song");
		System.out.println("3. Add a song");
		System.out.println("(Any other button will return to main menu)");

		choice = kbd.nextInt();

			} catch(InputMismatchException e){
				
				System.out.println("Returning to main menu...");
				if(DEBUG)				
					e.printStackTrace();
					quit = true;

							}//end of invalid input try-catch

		String songName="";
		switch (choice){
		

			case 1:
				System.out.println();
				decider = 1;
				break;
			case 2:
				System.out.println("Which song would you like to play?");
				songName = kbd.nextLine();
				decider = 2;
				break;
			case 3:
				addPlaylistSong(title);
				decider = -3;
				break;
			default:
				decider = -1;
				System.out.println("Returning to the main menu...");
				}//end of switch statement

		//System.out.println("decider = "+decider);

		int counter = 1;



		if(decider == 1){

			String query = "select song,aname from "+ title;
			Statement stat = mycon.createStatement();
			ResultSet rs = stat.executeQuery(query);
		
			if (rs.next() == false){

				System.out.println("No songs in "+title);
						
						}//end of no songs if
			else{

			rs = stat.executeQuery(query);

			System.out.println("All songs in "+title);
			System.out.println();
			while(rs.next()){


				System.out.println(counter + ". "+rs.getString(1)+ " by "+
						rs.getString(2));

				counter++;

					}//end of while
				
				}//end of printing else


				}//end of decider if

		else if (decider == 2){

			boolean match = false;
			System.out.println("Type in song name: ");
			songName = kbd.nextLine();
			

			String query = "select song,aname from "+ title;
			Statement stat = mycon.createStatement();
			ResultSet rs = stat.executeQuery(query);

			String[] songArray = new String[MAX_N];
			counter = 0;
			while(rs.next()){

				songArray[counter] = rs.getString(1);
				counter++;

					}//end of storing while
				
			try {

			for(i = 0; i <= counter; i++){


				if(songArray[i].compareToIgnoreCase(songName)==0){
					
					if(DEBUG)
						System.out.println("Match found");
					match = true;
										}//end of if

							}//end of matching for

				} catch(NullPointerException e){

					if(DEBUG)
						e.printStackTrace();

								}//end of null try-catch

				if(match)
					playSong(songName);
				else
					System.out.println("Song isn't in "+title); 


				}//end of else if
			else if(decider == -1)
				quit = true;
							

			}//end of while
			}//end of if-else

			
							
			} catch(SQLException e){e.printStackTrace();}//end of sql try-catch

			


}



//end of selectPlaylist




/*--------------------------------------------------------------------------------------------------*/




//CHECK IF AT LEAST 1 PLAYLIST EXISTS


		public static void playlistTable(){
			
			try {
            		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");

			//create playlist table

		
			String query = "create table PLAYLISTS ( "+
					"playlistName varchar(40), dateCreated datetime, "+
					"songCount INTEGER, PRIMARY KEY(playlistName))";



			Statement stat = mycon.createStatement();
			stat.executeUpdate(query);


			//catch exception if already exists




				} catch(SQLException e){


					if(DEBUG){
						e.printStackTrace();
						System.out.println("Not first playlist!");
							}//end of DEBUG if

							}//end of sql try-catch


		}


//end of playlistTable




/*--------------------------------------------------------------------------------------------------*/




//ADD TO PLAYLISTS TABLE


		
		public static void addToList(String playlist){

			try {
           		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");


			//add playlist title to PLAYLISTS table

			java.util.Date date = new java.util.Date();
			Timestamp created = new Timestamp(date.getTime());

			String query = "insert into PLAYLISTS values ( '"+
					playlist+"','"+created+"',0)";
			Statement stat = mycon.createStatement();
			stat.executeUpdate(query);


			} catch(SQLException e){


					if(DEBUG)
						e.printStackTrace();
							}//end of sql try-catch

	}
	
//end of addToList




/*--------------------------------------------------------------------------------------------------*/




//REMOVE FROM PLAYLISTS TABLE




	public static void removeFromList(String title){


		try {
           		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");

			

			//remove playlist title to PLAYLISTS table


			String query = "delete from PLAYLISTS where playlistName = '"
					+title+"'";
			Statement stat = mycon.createStatement();
			stat.executeUpdate(query);


			} catch(SQLException e){


					if(DEBUG)
						e.printStackTrace();
							}//end of sql try-catch














	}

//end of removeFromList




/*--------------------------------------------------------------------------------------------------*/




//SHOW ALL PLAYLISTS


	

	public static void printPlaylists(){

		try {
           		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");


			//check if first playlist

			playlistTable();
			

			String query = "select playlistName,dateCreated,songCount from"+
					" PLAYLISTS";		
			Statement print = mycon.createStatement();
			ResultSet rs = print.executeQuery(query);

			System.out.println();
			if(rs.next()==false)
				System.out.println("No current playlists");

			else{
				int counter = 1;
				rs = print.executeQuery(query);
				while(rs.next()){

					System.out.println(""+counter+". "+rs.getString(1)+
					" created: "+rs.getTimestamp(2)+" ("+ 
					rs.getInt(3)+" songs) ");
					counter++;
					}//end of print while


				}//end of else
			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();

						}//end of sql try-catch



	}


//end of printPlaylists




/*--------------------------------------------------------------------------------------------------*/




//DELETE A PLAYLIST(DEVS)



	public static void devDeletePlaylist(){

		Scanner kbd = new Scanner(System.in);
		Object[][] playlists = new Object[MAX_N][2];

		try {
           		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");


			String query = "select playlistName,dateCreated from"+
					" PLAYLISTS";		
			Statement print = mycon.createStatement();
			ResultSet rs = print.executeQuery(query);

			System.out.println();

			int counter = 1;
			if(rs.next()==false) {

				System.out.println("No current playlists");
				return;				

						}//end of if
			else{
				
				int i = 0;
				rs = print.executeQuery(query);
				while(rs.next()){

					String temp = rs.getString(1);
					temp = temp.toUpperCase();
					playlists[i][0] = temp;
					playlists[i][1]= rs.getTimestamp(2);
					System.out.println(counter+". "+playlists[i][0]+
					" created: "+ playlists[i][1]);
					i++;
					counter++;

					}//end of print while

				}//end of else

			try {
	
			System.out.println("Which playlist would you like to delete?");
			System.out.println("Type in the number: ");
			System.out.println("(Any other button will return to main menu)");

			int choice = kbd.nextInt();
			
			if(choice < 1 || choice > counter)
				throw new InputMismatchException();

			else{

				choice = --choice;
				String playName = playlists[choice][0].toString();;
				deletePlaylist(playName);

				}//end of if-else

				} catch(InputMismatchException e){

					System.out.println("Returning to the main menu...");
					if(DEBUG)
						e.printStackTrace();
					return;		
								}//end of invalid input try-catch

			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();

						}//end of sql try-catch

			
	}

//end of devDeletePlaylist





/*--------------------------------------------------------------------------------------------------*/




//SEARCH ALL INSTRUMENTALS



	public static void searchInstrumentals(){

		try {
           		Connection mycon = DriverManager.getConnection(
               		"jdbc:mysql://localhost/songProject?useSSL=false",
               		"cs4430", "cs4430");
	


			String query = "select name,aname from song where lang = 'NULL'";
			Statement select = mycon.createStatement();
			ResultSet rs = select.executeQuery(query);

			if(rs.next()==false)
				System.out.println("No instrumentals");
		

			else {

				rs = select.executeQuery(query);
				int counter = 1;
				String songName = "";
				String artistName = "";
				while(rs.next()) {

					songName = rs.getString(1);
					artistName = rs.getString(2);
					System.out.println(counter + ". " + songName + 
							" by " + artistName);

					counter++;

							}//end of while 

				}//end of if-else



			} catch(SQLException e){

				if(DEBUG)
					e.printStackTrace();


				}//end of sql try-catch


	}


//end of searchInstrumentals







}//end of main class









class SongLengthError extends InputMismatchException{



//CONSTRUCTOR

	public SongLengthError(){


		System.out.println("There is a song length error!!!!");

		}//end of songLengthError

}//end of songLengthError Class






class inputError extends SQLException{


	static final boolean DEBUG = false;
//CONSTRUCTOR

	public inputError(){

		if(DEBUG)
			System.out.println("Character is a digit!");

		}//end of songLengthError

}//end of songLengthError Class






class Playlist {


	static final boolean DEBUG = false;

	public Playlist(String title){

	/*
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        try {
            Connection mycon = DriverManager.getConnection(
               "jdbc:mysql://localhost/songProject?useSSL=false",
               "cs4430", "cs4430");


		Scanner kbd = new Scanner(System.in);

		if(DEBUG)
			System.out.println("In Playlist class' CONSTRUCTOR");		
		
		title = title.toUpperCase();
		
		String query = "create table " + title +" ( song varchar(40), length DOUBLE, "+
				"aname varchar(40), album varchar(40), genre varchar(40), "+
				"afeatured varchar(40), lang varchar(20)," +
				" PRIMARY KEY (song,album))";

		Statement playlist = mycon.createStatement();
		playlist.executeUpdate(query); 		


		JOptionPane.showMessageDialog(null, "Your playlist name is: " + title);


		} catch(SQLException e){e.printStackTrace();}//end of SQl try catch
	

	}//end of CONSTRUCTOR


}//end of PLAYLIST class















