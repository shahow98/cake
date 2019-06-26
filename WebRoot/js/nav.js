$(document).ready(function() {
	$.ajax({
		url : "./AccountAction?intent=User",
		type : 'post',
		data : {
		},
		success : function(data) {
			if(data.length>0){
				var account = JSON.parse(data);
				if(account.email != "null"
				 && account.first_name != "null"
				 && account.last_name != "null"){
					$("#account .first .login .sign_in").hide();
					$("#account .first .login .sign_up").hide();
					$("#user_info").show();
					$("#user_name").text(account.first_name+account.last_name);
					$("#user_email").text(account.email);
					$("#account .first .login").animate({height:"102px"},"200");
				}
			}else{
				console.log("no user");
			}
		},
		error : function(error) {
			console.log("没有建立连接");
		}
	});
	
	
	$.ajax({
		url : "./CartAction?intent=BrowseCart",
		type : 'post',
		data : {
		},
		success : function(data) {
			if(data != "null"){
				var account = JSON.parse(data);
				var len = account.length;
				var price = 0;
				for(var i=0; i<len; i++){
					price += parseInt(account[i].price);
				}
				var p = "$"+price+"("+len+")";
				$("#account .first .cart>p").text(p);
			}else{
				$("#account .first .cart>p").text("none");
				console.log(data);
			}
		},
		error : function(error) {
			$("#account .first .cart>p").text("no user");
			console.log("没有建立连接");
		}
	});
	
	
	$("#menu_btn a").on("click", function() {
		$("#menu").toggle("slow");
	});
	
	$("#account .first li > a").on("click",function(){
		$(this).find(".triangle").toggle("slow");
		$(this).next(".second").toggle("slow");
	});
	
	
	$("#user_info > button").on("click",function(){
		$("[name='id']").val("");
		$("[name='pwd']").val("");
		$("#account .first .login .sign_in").show();
		$("#account .first .login .sign_up").show();
		$("#user_info").hide();
		$("#user_name").text(account.first_name+account.last_name);
		$("#user_email").text(account.email);
		$("#account .first .login").animate({height:"300px"},"200");
		
		
		$.ajax({
			url : "./AccountAction?intent=Out",
			type : 'post',
			data : {
			},
			success : function(data) {
				console.log("下线成功");
			},
			error : function(error) {
				console.log("没有建立连接");
			}
		});
		
		$.ajax({
			url : "./CartAction?intent=BrowseCart",
			type : 'post',
			data : {
			},
			success : function(data) {
				if(data != "null"){
					var account = JSON.parse(data);
					var len = account.length;
					var price = 0;
					for(var i=0; i<len; i++){
						price += parseInt(account[i].price);
					}
					var p = "$"+price+"("+len+")";
					$("#account .first .cart>p").text(p);
				}else{
					$("#account .first .cart>p").text("none");
					console.log(data);
				}
			},
			error : function(error) {
				$("#account .first .cart>p").text("no user");
				console.log("没有建立连接");
			}
		});
	});
	
	$("#account .first .login .sign_in button").on("click", function() {
		var id = $("[name='id']").val();
		var pwd = $("[name='pwd']").val();
		$.ajax({
			url : "./AccountAction?intent=Login",
			type : 'post',
			data : {
				"id" : id,
				"pwd" : pwd
			},
			success : function(data) {
				var account = JSON.parse(data);
				if(account.email != "null"
				 && account.first_name != "null"
				 && account.last_name != "null"){
					$("#account .first .login .sign_in").hide();
					$("#account .first .login .sign_up").hide();
					$("#user_info").show();
					$("#user_name").text(account.first_name+account.last_name);
					$("#user_email").text(account.email);
					$("#account .first .login").animate({height:"102px"},"200");
					$.ajax({
						url : "./CartAction?intent=BrowseCart",
						type : 'post',
						data : {
						},
						success : function(data) {
							if(data != "null"){
								var account = JSON.parse(data);
								var len = account.length;
								var price = 0;
								for(var i=0; i<len; i++){
									price += parseInt(account[i].price);
								}
								var p = "$"+price+"("+len+")";
								$("#account .first .cart>p").text(p);
							}else{
								$("#account .first .cart>p").text("none");
								console.log(data);
							}
						},
						error : function(error) {
							$("#account .first .cart>p").text("no user");
							console.log("没有建立连接");
						}
					});
				}else{
					alert("邮箱或者密码错误");
				}
			},
			error : function(error) {
				console.log("没有建立连接");
			}
		});
	});
});