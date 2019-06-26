$(document).ready(function(){
	$("#exhibition .container .cake > .ca > img").on("click",function(){
		var img = $(this).attr("src");
		window.location.href="single.html?img="+img;
	});
	
	$("#cakes .cake img").on("click",function(){
		var img = $(this).attr("src");
		window.location.href="single.html?img="+img;
	});
	
	$("#mycart .product img:first-child").on("click",function(){
		var img = $(this).attr("src");
		window.location.href="single.html?img="+img;
	});
	
});