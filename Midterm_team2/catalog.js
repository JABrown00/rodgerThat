$(function(){




$(".menuImage").on("mouseover", function(e){

	/*var message = $('<p "Testing" /p>');
	$(".menuImage").after(message);
	*/


	//$(".menuImage").fadeOut(1000);


	var alt = $(this).attr('alt');
	var caption = $("<p " + alt + " /p>");

	$(this).append(caption);

});


































});