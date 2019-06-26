$(document).ready(function(){
	$.ajax({
		url : "./CartAction?intent=BrowseCart",
		type : 'post',
		data : {
		},
		success : function(data) {
			if(data != "null"){
				var account = JSON.parse(data);
				console.log(data);
				$(".product").hide();
				for(var i=0; i<account.length; i++){
					var addhtml = '<div class="product">'+
					'<img src="'+account[i].img_src+'">'+
					'<img class="remove" src="img/close_1.png">'+
					'<p>name</p>'+
					'<p>取物时间：<span>xxxx:xx:xx</span></p>'+
					'<p>分钟订单价值:<span>$123</span></p>'+
					'<p>服务费:<span>$1.00</span></p>'+
					'<p>预计在<span>xxxx:xx:xx</span>到达</p>'+
					'</div>';
					$(".product:last-child").before(addhtml);
				}
				$("#mycart .product .remove").on("click", function(){
					$(this).parent().hide("slow");
					var img_src = $(this).prev().attr("src");
					console.log("img_src"+img_src);
					$.ajax({
						url : "./CartAction?intent=DeleteCart",
						type : 'post',
						data : {
							"img_src" : img_src
						},
						success : function(data) {
							console.log("success");
						},
						error : function(error) {
							console.log("没有建立连接");
						}
					});
				});
			}else{
				console.log(data);
			}
		},
		error : function(error) {
			console.log("没有建立连接");
		}
	});
	
	$("#mycart .product .remove").on("click", function(){
		$(this).parent().hide("slow");
		
		var img_src = $(this).prev().attr("src");
		console.log("img_src"+img_src);
		$.ajax({
			url : "./CartAction?intent=DeleteCart",
			type : 'post',
			data : {
				"img_src" : img_src
			},
			success : function(data) {
				console.log("success");
			},
			error : function(error) {
				console.log("没有建立连接");
			}
		});
	});
});