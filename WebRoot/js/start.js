$(document).ready(function(){
	$(".start").mouseleave(function(){
		$(".start .off").attr("src", "/cake/img/star/rating.png");
		$(".start .on").attr("src", "/cake/img/star/xingxing1.png");
	});
	$("img[class^='start']").mouseenter(function(){
		$(this).prevAll().attr("src","/cake/img/star/xingxing1.png");
		$(this).attr("src","/cake/img/star/xingxing1.png");
	});
	$("img[class^='start']").mouseleave(function(){
		$(this).attr("src", "/cake/img/star/rating.png");
		$(this).nextAll().attr("src","/cake/img/star/rating.png");
	});
	$("img[class^='start']").click(function(){	
		$(this).prevAll().removeClass("off").addClass("on");
		$(this).removeClass("off").addClass("on");
		$(this).nextAll().removeClass("on").addClass("off");
		$(".start .off").attr("src", "/cake/img/star/rating.png");
		$(".start .on").attr("src", "/cake/img/star/xingxing1.png");
	});
});