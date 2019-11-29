// DOM Ready
$(function() {
 var el, newPoint, newPlace, offset;
 
 // Select all range inputs, watch for change
 $("input[type='range']").change(function() {
 
   // Cache this for efficiency
   el = $(this);
   
   // Measure width of range input
   width = el.width();
   
   // Figure out placement percentage between left and right of input
   newPoint = (el.val() - el.attr("min")) / (el.attr("max") - el.attr("min"));
   
   // Janky value to get pointer to line up better
   offset = -1.3;
   
   // Prevent bubble from going beyond left or right (unsupported browsers)
   if (newPoint < 0) { newPlace = 0; }
   else if (newPoint > 1) { newPlace = width; }
   else { newPlace = width * newPoint + offset; offset -= newPoint; }
   
   // Move bubble
   el
     .next("output")
     .css({
       left: newPlace,
       marginLeft: offset + "%"
     })
     .text(el.val());
 })
 // Fake a change to position bubble at page load
 .trigger('change');

function setBackground(e){
  if(e.type == "focus") {
    e.target.style.backgroundColor = "#FFE393";
  }
  else if (e.type == "blur") {
    e.target.style.backgroundColor = "white";
  }
}

function setBackgroundReverse(e){
  if(e.type == "focus") {
    e.target.style.backgroundColor = "white";
  }
  else if (e.type == "blur") {
    e.target.style.backgroundColor = "#FFE393";
  }
}

var selector = "input[type=text],input[type=email],input[type=tel]";
var fields = document.querySelectorAll(selector);
for (var i = 0; i < fields.length; i++) {
  fields[i].addEventListener("focus", setBackground);
  fields[i].addEventListener("blur", setBackground);
}

var selector = "textarea";
var fields = document.querySelectorAll(selector);
for (var i = 0; i < fields.length; i++) {
  fields[i].addEventListener("focus", setBackgroundReverse);
  fields[i].addEventListener("blur", setBackgroundReverse);
}



});