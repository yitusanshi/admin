		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
			
			
			// 注册账户
			$("#regist_btn").click(
					function(){
						if(true){
							type : "POST",
							url : _ctx + "/regist",
							data : {
								username : $("#regist_username").val(),
								password : $("#regist_password1").val(),
								firm_name: $("#regist_firm_name").val(),
								firm_type: $("#regist_firm_type").val(),
								firm_address1: $("#cmbProvince").val(),
								firm_address2: $("#cmbCity").val()
								time : new Date().getTime()
							},
							dataType : "json",
							cache : false,
							success : function(data) {
								if ("success" == data.status) {
									window.location.href = _ctx + "/index";
								} else {
									$("#error-msg").html(data.msg);
								}
						}
					
			});

			$("#login_btn").click(
					function() {
						console.log("$(input[name='username']).val()", $(
								"input[name='username']").val());
						console.log("$(input[name='username']).val()", $(
								"input[name='password']").val());
						if (checkLogin()) {
							$.ajax({
								type : "POST",
								url : _ctx + "/login",
								data : {
									username : $("input[name='username']")
											.val(),
									password : $("input[name='password']")
											.val(),
									time : new Date().getTime()
								},
								dataType : "json",
								cache : false,
								success : function(data) {
									if ("success" == data.status) {
										window.location.href = _ctx + "/index";
									} else {
										$("#error-msg").html(data.msg);
									}
								}
							})
						}
						return false;
					});

			function checkLogin() {
				if ($("input[name='username']").val() == "") {
					alert("username cannot be empty")
					$("input[name='username']").focus();
					return false;
				}
				if ($("input[name='password']").val() == "") {
					alert("password cannot be empty")
					$("input[name='password']").focus();
					return false;
				}
				return true;
			}
			// 打开会员注册
			$("#Regist_start_").click(function() {
				$("#login-box").hide();
				$("#regist-box").show();
			});
			$("#toLogin").click(function() {
				$("#regist-box").hide();
				$("#login-box").show();
			});
		});

function checkLogin() {
	if ($("input[name='username']").val() == "") {
		alert("username cannot be empty")
		$("input[name='username']").focus();
		return false;
	}
	if ($("input[name='password']").val() == "") {
		alert("password cannot be empty")
		$("input[name='password']").focus();
		return false;
	}
	return true;
};








