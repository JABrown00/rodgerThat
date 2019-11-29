-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: songProject
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `PLAYLISTS`
--

DROP TABLE IF EXISTS `PLAYLISTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYLISTS` (
  `playlistName` varchar(40) NOT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `songCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`playlistName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLISTS`
--

LOCK TABLES `PLAYLISTS` WRITE;
/*!40000 ALTER TABLE `PLAYLISTS` DISABLE KEYS */;
INSERT INTO `PLAYLISTS` VALUES ('Testing','2019-11-25 11:02:31',2);
/*!40000 ALTER TABLE `PLAYLISTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TESTING`
--

DROP TABLE IF EXISTS `TESTING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TESTING` (
  `song` varchar(40) NOT NULL,
  `length` double DEFAULT NULL,
  `aname` varchar(40) DEFAULT NULL,
  `album` varchar(40) NOT NULL,
  `genre` varchar(40) DEFAULT NULL,
  `afeatured` varchar(40) DEFAULT NULL,
  `lang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`song`,`album`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TESTING`
--

LOCK TABLES `TESTING` WRITE;
/*!40000 ALTER TABLE `TESTING` DISABLE KEYS */;
INSERT INTO `TESTING` VALUES ('Jet Fuel',5.45,'Mac Miller','Swimming','hip-hop / rap','NULL','en'),('Nothing On You',3.21,'Ed Sheeran','No.6 Collaborations Project','pop','Paulo Londra & Dave','en / span');
/*!40000 ALTER TABLE `TESTING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `name` varchar(40) NOT NULL,
  `length` varchar(8) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `aname` varchar(40) NOT NULL,
  `songCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`,`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES ('!','00:38:29','2019-08-09','Trippie Redd',14),('A Love Letter To You 4','00:59:08','2019-11-22','Trippie Redd',21),('Astroworld','00:58:42','2018-08-03','Travis Scott',17),('Baby on Baby','00:31:41','2019-03-01','DaBaby',13),('Come Over When You\'re Sober, Pt. 2','00:44:48','2018-11-09','Lil Peep',13),('Issa Album','00:56:35','2017-07-06','21 Savage',14),('Luca Brasi 3','00:58:19','2018-09-28','Kevin Gates',18),('Rodeo','01:15:00','2015-09-04','Travis Scott',16),('SKINS','00:19:47','2018-12-07','XXXTENTACION',10),('Slime Language','00:50:00','2018-08-17','Young Thug',15),('So Much Fun','01:02:00','2019-08-16','Young Thug',19);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song` (
  `name` varchar(40) NOT NULL,
  `length` double DEFAULT NULL,
  `size` double DEFAULT NULL,
  `aname` varchar(40) DEFAULT NULL,
  `album` varchar(40) NOT NULL,
  `genre` varchar(40) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `afeatured` varchar(40) DEFAULT NULL,
  `lang` varchar(20) DEFAULT 'en',
  PRIMARY KEY (`name`,`album`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES ('100 Miles and Running',5.53,6.09,'Logic','YSIV','hip-hop / rap','2018-09-28','Wale & John Lindahl','en'),('4 Min Convo (Favorite Song)',4.17,4.49,'A Boogie Wit da Hoodie','Hoodie SZN','hip-hop / rap','2018-12-21','NULL','en'),('5:55',3.59,3.97,'Sylvan LaCue','Apologies in Advance','hip-hop / rap','2018-01-12','NULL','en'),('Ay Vamos',3.46,3.82,'J Balvin','La Familia B Sides','Reggaeton','2014-09-16','NULL','span'),('Back To The Start',3.24,3.51,'SoMo','SoMo','R&B','2014-01-01','NULL','en'),('BAD!',1.34,1.57,'XXXTENTACION','NULL','hip-hop / rap','2018-11-09','NULL','en'),('Baguettes in the Face',2.54,2.78,'Mustard','Perfect Ten','hip-hop / rap','2019-06-28','NAV,Playboi Carti,A Boogie Wit da Hoodie','en'),('Beasty',2.32,2.54,'A Boogie Wit da Hoodie','Hoodie SZN','hip-hop / rap','2018-12-21','NULL','en'),('Benz Boys',3.38,3.59,'Wiz Khalifa & Curren$y','2009','hip-hop / rap','2019-02-08','Ty Dolla $ign','en'),('Better',3.49,3.68,'Khalid','Free Spirit','R&B','2019-04-05','NULL','en'),('Blackout',6.41,6.78,'Jaden','ERYS','hip-hop / rap','2019-07-05','NULL','en'),('Blade: The Art of Ox',4.35,5.21,'Cannibal Ox','Blade of the Ronin (Deluxe Edition)','rap','2015-03-03','Artifacts , U-God','en'),('Blame',2.07,2.19,'Bryson Tiller','NULL','R&B','2019-07-26','NULL','en'),('Blue',5.34,5.79,'Fractal & Au5','Monstercat 016 - Expedition','electronic','2014-02-26','Multiple Artists','NULL'),('Borrowed Love',3.51,3.84,'Metro Boomin','NOT ALL HEROES WEAR CAPES','hip-hop / rap','2018-11-02','Swae Lee & WizKid','en'),('Bosses and Workers',3.27,3.55,'A Boogie Wit da Hoodie','Hoodie SZN','hip-hop / rap','2018-12-21','Don Q & Trap Manny','en'),('Broken Smile (My All)',4.41,5.07,'Lil Peep','Come Over When You\'re Sober, Pt. 2','hip-hop','2018-11-09','NULL','en'),('Castle',4.15,4.97,'Eminem','Revival','rap','2017-12-15','NULL','en'),('Chains Choking Me',3.01,3.24,'Young Thug','Slime Language','hip-hop / rap','2018-08-17','Gunna','en'),('Chalk Outline',3.01,3.19,'Three Days Grace','Transit Of Venus','rock','2012-10-02','NULL','en'),('Cherry',5.38,5.59,'Ratatat','Ratatat','alternative','2004-08-19','NULL','NULL'),('coordinate',3.46,3.82,'Travis Scott','Birds In The Trap Sign McKnight','hip-hop / rap','2016-09-16','NULL','en'),('Couting Stars',4.17,4.38,'OneRepublic','Native','pop','2014-01-01','NULL','en'),('Crossfire',4.31,4.62,'Stephen','Sincerely','alternative','2016-05-10','NULL','en'),('Dark Sky (Skyscrapers)',2.58,2.74,'Big Sean','Dark Sky Paradise','hip-hop / rap','2015-02-24','NULL','en'),('DEAD TO ME',3.01,3.21,'blackbear','ANONYMOUS','R&B','2019-04-26','NULL','en'),('Demons',2.55,2.76,'Imagine Dragons','Night Visions','rock','2012-09-04','NULL','en'),('Dirty Mouth',2.47,2.71,'Lil Yachty','Teenage Emotions','rap','2017-05-26','NULL','en'),('Donde Jugaran Los Ninos',4.13,4.31,'Mana','Donde Jugaran Los Ninos','rock','1992-09-14','NULL','span'),('Dont Cry',4.09,4.23,'Lil Wayne','Tha Carter V','hip-hop / rap','2018-09-28','XXXTENTACION','en'),('Ecstasy',2.58,2.79,'Young Thug','So Much Fun','hip-hop / rap','2019-08-16','Machine Gun Kelly','en'),('El Manana',3.55,3.78,'Gorillaz','Demon Days','alternative','2005-05-23','NULL','en'),('Erase Me',5.44,5.67,'Sylvan LaCue','Searching Sylvan','hip-hop / rap','2014-09-02','NULL','en'),('Everyday',3.21,2.64,'Dave East','Survival','rap','2019-11-08','Gunna','en'),('Everything BoZ',3.25,3.57,'Trippie Redd','!','hip-hop / rap','2019-08-09','Coi Leray','en'),('Family and Loyalty',4.34,4.57,'Gang Starr','NULL','hip-hop / rap','2019-09-20','J. Cole','en'),('Farewell',7.54,7.77,'Hellberg & TwoThirds','Monstercat 012 - Aftermath','electronic','2013-03-11','Multiple Artists','NULL'),('Finesse',3.02,3.23,'Drake','Scorpion','hip-hop / rap','2018-06-29','NULL','en'),('Fire and Rain',3.24,3.59,'Devvon Terrell','Weird Sexy Cool','R&B','2015-08-18','NULL','en'),('First Off',3.48,3.72,'Future','Future Hndrxx Presents: The WIZRD','hip-hop / rap','2019-01-18','Travis Scott','en'),('Focus',2.35,2.69,'Bazzi','Soul Searching','Pop','2018-08-09','21 Savage','en'),('For Whom The Bell Tolls',2.07,2.23,'J. Cole','4 Your Eyez Only','hip-hop / rap','2016-12-09','NULL','en'),('Forever',5.57,5.83,'Drake','More Than A Game','hip-hop / rap','2009-01-01','Kanye,Lil Wayne,Eminem','en'),('Fr Fr',3.15,3.37,'Wiz Khalifa','Rolling Papers 2','hip-hop / rap','2018-07-13','Lil Skies','en'),('Get Out Alive',4.22,4.51,'Three Days Grace','One-X','rock','2006-06-25','NULL','en'),('Ghost',4.14,4.42,'Andrew Garcia','NULL','R&B','2014-11-21','NULL','en'),('Give In To Me',3.19,3.41,'Three Days Grace','Transit Of Venus','rock','2012-10-02','NULL','en'),('Habits of My Heart',3.31,3.81,'Jaymes Young','Habits of My Heart EP','alternative','2014-09-28','NULL','en'),('Headlines',3.55,3.79,'Drake','Take Care','hip-hop / rap','2011-11-15','NULL','en'),('Highs and Lows',2.54,2.76,'Lil Skies','Shelby','hip-hop / rap','2019-03-01','NULL','en'),('Hollywoods Bleeding',2.36,2.76,'Post Malone','Hollywood\'s Bleeding','Hip-hop / rap','2019-09-06','NULL','en'),('Humble Beginnings',3.04,3.41,'Bazzi','Soul Searching','Pop','2019-08-09','NULL','en'),('I dont let go',2.01,2.19,'XXXTENTACION','SKINS','hip-hop / rap','2018-12-07','NULL','en'),('I Know',5.2,5.45,'Big Sean','Dark Sky Paradise','rap','2015-02-24','Jhene Aiko','en'),('I Try',2.41,2.69,'Trippie Redd','!','hip-hop / rap','2019-08-09','NULL','en'),('I Was Sad Last Night I\'m OK Now',3.11,3.36,'tobi lou','Live on Ice','hip-hop / rap','2019-08-02','NULL','en'),('Im Scared',3.21,3.47,'Young Thug','So Much Fun','hip-hop / rap','2019-08-16','21 Savage & Doe Boy','en'),('Immortal',3.24,3.57,'Trippie Redd','!','hip-hop / rap','2019-08-09','The Game','en'),('Intro',3.33,3.66,'Khalid','Free Spirit','R&B','2019-04-05','NULL','en'),('It Will Rain',4.17,4.32,'Bruno Mars','NULL','pop','2011-09-27','NULL','en'),('Jet Fuel',5.45,6.82,'Mac Miller','Swimming','hip-hop / rap','2018-08-03','NULL','en'),('K OST: Suoh Mikoto',2.48,2.96,'GoRA','NULL','classical','2012-10-05','NULL','NULL'),('Keep Your Head Up',3.23,3.46,'Trippie Redd','!','hip-hop / rap','2019-08-09','NULL','en'),('Kill4u',3.01,3.26,'Lil Skies','Life of a Dark Rose','hip-hop / rap','2017-12-12','NULL','en'),('Kings Never Die',4.56,4.75,'Eminem','Southpaw','hip-hop / rap','2015-07-24','Gwen Stefani','en'),('KOD',3.11,3.29,'J. Cole','KOD','hip-hop / rap','2018-04-20','NULL','en'),('La Lights',4.23,4.47,'NetNobody','NULL','hip-hop / rap','2017-10-22','Doqtor Q','en'),('La Sombra',3.41,3.85,'Monsieur Perine','Encanto Tropical','pop','2018-05-18','Leonel Garcia','span'),('Lettuce Sandwich',3.15,3.78,'Lil Skies','Life of a Dark Rose','rap','2017-12-12','NULL','en'),('Live In Stereo',3.31,3.71,'J Balvin','La Familia B Sides','pop','2014-09-16','Motiff','span'),('Lolsmh - Interlude',4.15,4.39,'Boogie','Everythings For Sale','hip-hop / rap','2019-01-25','NULL','en'),('Looking for a Star',2.17,2.34,'XXXTENTACION','Revenge','hip-hop / rap','2017-05-16','NULL','en'),('LOST',4.38,4.68,'Quavo','QUAVO HUNCHO','hip-hop / rap','2018-10-11','Kid Cudi','en'),('Love Hurts',3.01,3.39,'Playboi Carti','Die Lit','hip-hop / rap','2018-05-11','Travis Scott','en'),('Love Me More',2.23,2.68,'Trippie Redd','A Love Letter To You 4','hip-hop','2019-11-22','NULL','en'),('Love The Way You Lie',4.23,4.49,'Eminem','Recovery','hip-hop / rap','2010-06-18','Rihanna','en'),('Loyalty Before Royalty',2.22,2.44,'Trippie Redd','A Love Letter To You 3','hip-hop / rap','2018-11-09','NULL','en'),('LOYALTY.FEAT.RIHANNA.',3.47,3.78,'Kendrick Lamar','DAMN.','hip-hop / rap','2017-04-14','Rihanna','en'),('Luca Brasi Freestyle',4.05,4.49,'Kevin Gates','Luca Brasi 3','rap','2018-09-28','NULL','en'),('Lucid Dreams',3.59,4.27,'Juice WRLD','Goodbye & Good Riddance','hip-hop / rap','2018-05-23','NULL','en'),('Maraca',3.25,3.49,'Smino','blkswn','hip-hop / rap','2017-03-14','NULL','en'),('Me And My Broken Heart',3.13,3.28,'Rixton','Let The Road','pop','2014-01-01','NULL','en'),('Mile High',3.13,3.27,'James Blake','NULL','hip-hop / rap','2019-01-17','Travis Scott & Metro Boomin','en'),('My Bad',2.43,2.72,'Khalid','Free Spirit','R&B','2019-04-05','NULL','en'),('Ned Flanders',2.41,2.69,'MadeinTYO','Sincerely Tokyo','hip-hop / rap','2018-10-26','ASAP Ferg','en'),('Neighbor',2.42,2.74,'Juicy J','NULL','hip-hop / rap','2018-09-26','Travis Scott','en'),('Never Recover',3.14,3.31,'Lil Baby & Gunna','Drip Harder','hip-hop / rap','2018-10-05','Drake','en'),('Night Shift',3.43,4.09,'Dave East','Survival','rap','2019-11-08','Lil Baby','en'),('Nightmares',3.21,3.79,'Yung Pinch','NULL','hip-hop / rap','2019-01-18','Lil Skies','en'),('Ninety',7.48,7.64,'Jaden','SYRE','hip-hop / rap','2017-11-17','NULL','en'),('No Complaints',4.25,4.57,'Metro Boomin','NOT ALL HEROES WEAR CAPES','hip-hop / rap','2018-11-02','Offset & Drake','en'),('No More',3.12,3.34,'Lil Yachty','Teenage Emotions','hip-hop / rap','2017-05-26','NULL','en'),('Nothin New',3.39,3.86,'21 Savage','Issa Album','hip-hop / rap','2017-07-07','NULL','en'),('Nothing On You',3.21,3.45,'Ed Sheeran','No.6 Collaborations Project','pop','2019-07-12','Paulo Londra & Dave','en/span'),('Odee',2.41,2.88,'A Boogie Wit da Hoodie','Hoodie SZN','hip-hop / rap','2018-04-20','NULL','en'),('Outcast',5.25,5.54,'NF','Perception','hip-hop / rap','2017-10-06','NULL','en'),('Over',3.53,3.79,'Drake','Thank Me Later','hip-hop / rap','2010-01-01','NULL','en'),('Pain',6.15,6.38,'Jaden','ERYS','hip-hop / rap','2019-07-05','NULL','en'),('Panini - DaBaby Remix',2.31,2.61,'Lil Nas X','Panini','hip-hop / rap','2019-09-13','DaBaby','en'),('pick up the phone',4.12,4.35,'Travis Scott','Birds In The Trap Sing McKnight','hip-hop / rap','2016-09-16','Young Thug','en'),('Play This On A Mountain At Sunset',5.41,6.09,'Jaden','The Sunset Tapes: A Cool Tape Story','hip-hop / rap','2018-11-17','NULL','en'),('Pothole',3.57,3.95,'Tyler, The Creator','Flower Boy','hip-hop / rap','2017-07-21','Jaden','en'),('Psycho Pt. 2',2.41,2.64,'Russ','NULL','hip-hop / rap','2016-11-08','NULL','en'),('Question Time',7.07,7.37,'Dave','Game Over','hip-hop / rap','2017-11-03','NULL','en'),('R.I.P. SCREW',3.05,3.21,'Travis Scott','Astroworld','hip-hop / rap','2018-08-03','Swae Lee','en'),('Rainy Days',3.54,3.79,'Boogie','Everythings For Sale','hip-hop / rap','2019-01-25','Eminem','en'),('RAP DEVIL',4.47,5.04,'Machine Gun Kelly','NULL','rap','2018-09-08','NULL','en'),('RIOT',3.13,3.41,'Trippie Redd','!','hip-hop / rap','2019-08-09','NULL','en'),('rockstar',3.38,3.67,'Post Malone','beerbongs & bentleys','hip-hop / rap','2018-04-27','21 Savage','en'),('Roll In Peace',3.33,3.66,'Kodak Black','Project Baby 2','hip-hop / rap','2017-08-18','XXXTENTACION','en'),('Saturday Nights',3.29,3.61,'Khalid','Suncity','R&B','2018-10-19','NULL','en'),('Savage Time',5.35,5.51,'Big Sean','Double or Nothing','hip-hop / rap','2017-12-08','Metro Boomin','en'),('Scoliosis',3.41,3.71,'Young Thug','Slime Language','hip-hop / rap','2018-08-17','Gunna & Duke','en'),('See Me Fall',3.36,3.72,'Ro Ransom','NULL','hip-hop / rap','2015-09-07','Kensei Abbot','en'),('Self Destruction',2.41,2.77,'Boogie','Everythings For Sale','hip-hop / rap','2019-01-25','NULL','en'),('Seven Million',3.02,3.22,'Lil Uzi Vert','The Perfect LUV Tape','hip-hop / rap','2016-08-10','Future','en'),('Sin',3.22,3.67,'Young Thug','On The Rvn','rap','2018-09-24','Jaden','en'),('So What',2.29,2.69,'Black Youngsta','NULL','rap','2019-11-08','NULL','en'),('SOHO',3.28,3.75,'Jaden','The Sunset Tapes: A Cool Tape Story','alternative','2018-11-17','NULL','en'),('Something New',3.21,3.47,'Wiz Khalifa','Rolling Papers 2','hip-hop / rap','2018-07-13','Ty Dolla $ign','en'),('Space Cadet',3.23,3.67,'Metro Boomin','NOT ALL HEROES WEAR CAPES','hip-hop / rap','2018-11-06','Gunna','en'),('Special',3.38,3.89,'21 Savage','Issa Album','Hip-Hop / rap','2017-07-06','NULL','en'),('Stay Down',4.11,4.26,'Big Sean','Dark Sky Paradise','hip-hop / rap','2015-02-24','NULL','en'),('STOP TRYING TO BE GOD',5.38,5.69,'Travis Scott','Astroworld','hip-hop / rap','2018-08-03','NULL','en'),('STS',3.39,3.79,'Young Thug','Slime Language','hip-hop / rap','2018-08-17','Strick','en'),('Sugar Wraith',3.48,3.79,'Post Malone','beerbongs & bentleys','hip-hop / rap','2018-04-27','NULL','en'),('Swap Meet',2.26,2.47,'Boogie','Everythings For Sale','hip-hop / rap','2019-01-25','NULL','en'),('Swervin',3.09,3.21,'A Boogie Wit da Hoodie','Hoodie SZN','hip-hop / rap','2018-12-21','6ix9ine','en'),('Take What You Want',3.41,3.85,'Post Malone','Hollywood\'s Bleeding','hip-hop / rap','2019-09-06','Ozzy Osbourne & Travis Scott','en'),('Talk',3.17,3.49,'Khalid','Free Spirit','R&B','2019-04-05','Disclosure','en'),('The Jam',3.58,3.91,'Logic','Bobby Tarantino','hip-hop / rap','2016-07-01','NULL','en'),('The Monster',4.11,4.33,'Eminem','The Marshall Mathers LP2','hip-hop / rap','2013-11-05','Rihanna','en'),('The Ways',3.58,3.84,'Khalid','Black Panther The Album','hip-hop / rap','2018-02-09','Swae Lee','en'),('Through the Dark',3.39,3.74,'Rogue','Monstercat 015 - Outlook','electronic','2013-11-20','NULL','en'),('THRU THE NIGHT',2.08,2.46,'Jack Harlow','Confetti','rap','2019-09-20','Bryson Tiller','en'),('To Be Great',3.01,3.32,'Devvon Terrell','Weird Nights','R&B','2017-10-06','NULL','en'),('To My Grave',2.41,3.68,'NAV','Bad Habits','hip-hop / rap','2019-03-22','NULL','en'),('Together',2.44,2.87,'Trippie Redd','LIFES A TRIP','hip-hop / rap','2018-08-10','NULL','en'),('Trophies',3.08,3.19,'Young Money','NULL','hip-hop / rap','2014-01-01','Drake','en'),('U Aint Slime Enough',4.14,4.31,'Young Thug','Slime Language','hip-hop / rap','2018-08-17','Karlae & Duke','en'),('Undefeated',2.54,2.79,'A Boogie Wit da Hoodie','The Bigger Artist','hip-hop / rap','2017-09-29','21 Savage','en'),('Under Pressure',9.21,9.51,'Logic','Under Pressure','hip-hop / rap','2014-10-21','NULL','en'),('Vuelve',4.39,4.79,'Daddy Yankee','NULL','rap','2017-09-29','Bad Bunny','span'),('Wake Up',3.08,3.29,'Nebu Kiniza','NULL','hip-hop / rap','2017-11-17','Lil Yachty','en'),('Waking Up',3.19,3.41,'NetNobody','Mixtape','hip-hop / rap','2018-09-03','NULL','en'),('Who Shot Johnny?',2.45,2.97,'Tyla Yaweh','Heart Full of Rage','hip-hop / rap','2019-02-22','NULL','en'),('Whole Lot',5.13,5.41,'21 Savage','Issa Album','hip-hop / rap','2017-07-07','NULL','en'),('Wild Wild West',3.56,3.79,'Offset','FATHER OF 4','hip-hop / rap','2019-02-22','Gunna','en'),('Window Pain - Outro',4.46,4.89,'J. Cole','KOD','hip-hop / rap','2018-04-20','NULL','en'),('Woah',3.03,3.8,'Lil Baby','NULL','rap','2019-11-08','NULL','en'),('wokeuplikethis*',3.56,4.05,'Playboi Carti','Playboi Carti','rap','2017-04-07','Lil Uzi Vert','en'),('wonderful',3.36,3.78,'Travis Scott','Birds In The Trap Sing McKnight','hip-hop / rap','2016-09-02','The Weeknd','en'),('Work Out',3.55,4.013,'J. Cole','Cole World: The Sideline Story','hip-hop / R&B','2011-06-27','NULL','en'),('Wrist',3.26,3.54,'Logic','Bobby Tarantino','rap','2016-07-01','Pusha T','en'),('Yuck',2.54,2.89,'Logic','Bobby Tarantino II','rap','2018-03-09','NULL','en');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-25 22:21:02
