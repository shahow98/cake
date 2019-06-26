$(document).ready(function(){
	var flag = true;
	$("#newaccount button").on("click", function(){
		if(flag = false) return ;
		var first_name = $("input[name='first_name']").val();
		var last_name = $("input[name='last_name']").val();
		var email = $("input[name='account_email']").val();
		var password = $("input[name='pswd']").val();
		if(first_name.match(/^\S+$/) != null
		&& last_name.match(/^\S+$/) != null
		&& email.match(/\S?@\S?.\S?/) != null
		&& password.match(/^\S+$/) != null){
				$.ajax({
				url : "./AccountAction?intent=NewAccount",
				type : 'post',
				data : {
					"first_name" : first_name,
					"last_name" : last_name,
					"email" : email,
					"password" : password,
				},
				success : function(data) {
					console.log(data);
					var account = JSON.parse(data);
					if(account.email != "null"){
						$("#success").show("slow");
					}
				},
				error : function(error) {
					console.log('接口不通' + error);
				}
			});
		}else{
			alert("不能为空");
		}
	});
	
	
	$("input[name='repwd']").on("change", function(){
		var pwd = $("input[name='pswd']").val();
		if(pwd != $(this).val()){
			flag = false;
			alert("密码不一致");
		}else{
			flag = true;
		}
	});
});