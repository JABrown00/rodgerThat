<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <title>World Wide Cafe</title>
   <link rel="stylesheet" href="index.css" />   
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />   

</head>

<body id="body">
<header>
   <h1>World Wide Cafe</h1>
    <ul id = "container">
      <a href="index.html"><li>Home</li></a>
      <a href="Contact Us.html"><li>Contact Us</li></a>
      <a href="catering.html"><li>Catering</li></a>
      <a href="location.html"><li>Locations</li></a>
      <a href="franchise.html"><li>Franchise</li></a>
      <a href="about.html"><li>About</li></a>
    </ul>
</header>

<div >
<picture>
  <img id = "mainImage1" src="images/mainImage1.jpg">

</picture>





</div>

<div class="row"> 
      <div class="col-md-3" id="column">
          <div class="panel panel-default" id="panel"> 
        <div class="panel-heading" id="panel">          
        <h3 class="panel-title" id="panelTitle">Choose by Continent:</h3> 
        </div>         
        <div class="panel-body"> 
           <ul class="list-group">   
             <li class="list-group-item" id="panel">Australia</li>             
             <li class="list-group-item" id="panel">Europe</li> 
             <li class="list-group-item" id="panel">North America</li>              
             <li class="list-group-item" id="panel">South America</li> 
             <li class="list-group-item" id="panel">Africa</li>   
                      </ul>                     
        </div>

    </div>
      </div>       
      <div class="col-md-9" id="column"> 
           <div class="container" id="main_container">
    <div class="row">
      <div class="col-md-3">
             <h2>Order Online<img id="orderOnlineImage" src="images/orderOnlineImage.png" alt="order online"></h2>
         Don't want to wait in a long line because we're so popular? Order Online 
          <a href="#"><em>here</em></a> from a restaurant near you!</div>

         <div class="col-md-3">
         <h2>Rewards<img id="rewardsImage" src="images/Rewards.png" alt=" rewards"></h2>
         Join our  <a href="#">Rewards Program</a> to gain Rewards Member exclusive perks! <br>
         <input type="text" name="email" value="Enter Email...">
         <button style="border: solid 2pt green">Submit</button></div>


         <div class="col-md-3">
         <h2>Locations</h2>
         <img id="locationImage" src="images/LocationPin.png" alt="" />
        <p>Check out our locations to find a place near you!</p>
        <a href="location.html"><button type="submit" id="locationButton">
          Locations

        </button></a>
       </div>
       </div>
     </div>
   </div>

<div id="row">
<div id="col-md-2">
   <aside>
      <div class="box">
         <h3>Cart</h3>
         <p>You have no items in your cart</p>
      </div>
      <div class="box">
         <h3>Wish List</h3>
         <p>You have three items in your wish list</p>
      </div>   
   </aside>
   </div>

   
<br>

   <div id="col-md-10">
  <div id="secondImage">
<picture id="mainImage2">
  <img src="images/mainImage2.jpg">

</picture>
</div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-7">
    <h1 id="pictureCaption">
      Taste cuisine from around the world in the comfort of your own
      home!
    </h1>
  </div>
  <div class="col-md-2"></div>
</div>
  
   

</div>
<footer id="footer">
   <h3>Share:</h3>
    <button type="submit" formaction="#" name="download_button" value="" action = "#"><img src="images/icon_download.png" alt = "download"></button>
    <button type="submit" formaction="#" name="mail_button" value=""><img src="images/icon_mail.png" alt = "mail"></button>
    <button type="submit" formaction="#" name="map_button" value=""><img src="images/icon_map.png" alt = "map"></button>
    <button type="submit" formaction="#" name="like_button" value=""><img src="images/icon_up.png" alt = "like"></button>
    <button type="submit" formaction="#" name="dislike_button" value=""><img src="images/icon_down.png" alt = "dislike"></button>
</footer>
</body>
</html>