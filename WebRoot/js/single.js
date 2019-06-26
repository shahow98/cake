$(document).ready(function(){
	var flag = true;
	
	var url = window.location.href;
	var qstring = url.split("?");
	if(qstring[1] != ""){
		var img = url.split("img=");
		var url = "url("+img[1]+")";
		$("#chart img:first-child").attr("src", img[1]);
		$("#show_detail").css("background-image",url);
		$("#chart img").attr("src", img[1]);
	}
	
	
	$("#table .list").on("click", function(){
			$(this).prevAll().children("div").hide("slow");
			$(this).nextAll().children("div").hide("slow");
			$(this).children("div").toggle("slow");
			
	});
	
	
	$("#chart .update_cake").on("click", function(){
		var img_src = $(this).attr("src");
		var url = "url("+img_src+")";
		$("#chart > img:first-child").attr("src", img_src);
		$("#show_detail").css("background-image",url);
	});
	$("#chart > img:first-child").on("mouseenter", function(){
		$("#show_detail").css("display", "block");
	});
	$("#chart > img:first-child").on("mouseleave", function(){
		$("#show_detail").css("display", "none");
	});
	$("#chart > img:first-child").on("mousemove", function(event){
		var thisY = parseInt($("#nav").css("height"))
		 + parseInt($(this).css("margin-top")) + parseInt($(this).css("border"));
		var thisX = parseInt($("#chart .update_cake").css("left"))
		 + parseInt($(this).css("border"));
		var show_x = -(event.clientX - thisX);
		var show_y = -(event.clientY - thisY);
		$("#show_detail").css("background-position",show_x+"px "+show_y+"px ");
		
	});
	$("[name='qty']").on("change", function(){
		var value = $(this).val();
		if(value.search(/^[^-0]/) == -1){
			$(this).val("1");
		}
	});
});