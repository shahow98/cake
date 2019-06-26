$(document).ready(function(){
	$("#cakes > .cake > img").hover(function(){
		$(this).nextAll(".view").show("100");
	},function(){
		$(this).nextAll(".view").hide("100");
	});
	
	$("#categories ul > li > a").on("click", function(){
		$(this).next().toggle("200");
	});
	
	$("#cakes .cake button").on("click", function() {
		var img_src = "/cake/"+ $(this).parent().prevAll("img").attr("src");
		var price = $(this).parent().prev().prev().text();
		$.ajax({
			url : "./CartAction?intent=AddCart",
			type : 'post',
			data : {
				"img_src" : img_src,
				"price" : price.substring(1)
			},
			success : function(data) {
				console.log(data);
				if(data == "success"){
					alert('添加成功');
				}
			},
			error : function(error) {
				console.log("没有建立连接");
			}
		});
	});
		
	$("[name='qty']").on("change", function(){
		var value = $(this).val();
		if(value.search(/^[^-0]/) == -1){
			$(this).val("1");
		}
	});
	
	
	
	var length = parseInt($("#price .pricebar .bar").css("width"));
	var bar_x = parseInt($("#price .pricebar").css("margin-left"))
	 + parseInt($("#price .pricebar").css("border"));
	var move = function(){
			var div = parseInt($(this).css("width"));
			var beg_x = event.clientX - div/2 - bar_x;
			if(beg_x >= 0 && beg_x <= length-div){
				var max = 2000;
				var pre_x = parseInt($("#price .pricebar > div:nth-child(3)").css("left"));
				$(".pre").text(parseInt(pre_x/length*max));
				var last_x = parseInt($("#price .pricebar > div:nth-child(5)").css("left"));
				console.log(max);
				$(".next").text(parseInt(last_x/length*max));
				if(pre_x < last_x)
					$(this).css("left", beg_x+"px");
				else if(pre_x == last_x){
					$("#price .pricebar > div:nth-child(3)").css("left",beg_x-div/2+"px");
					$("#price .pricebar > div:nth-child(5)").css("left",beg_x+div/2+"px")
				}
				$("#price .pricebar > div:nth-child(4)").css("left", pre_x+div/2+"px")
					.css("width", last_x-pre_x+"px");
			}
		};
	$("#price .pricebar > div:nth-child(3)").on("mousedown", function(){
		$(this).on("mousemove", move);
	});
	$("#price .pricebar > div:nth-child(3)").on("mouseup", function(){
		$(this).off("mousemove", move);
	});
	$("#price .pricebar > div:nth-child(5)").on("mousedown", function(){
		$(this).on("mousemove", move);
	});
	$("#price .pricebar > div:nth-child(5)").on("mouseup", function(){
		$(this).off("mousemove", move);
	});
});