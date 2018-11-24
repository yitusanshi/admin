// 注册账户
$("#regist_btn").click(
		function() {
			if (true) {
				$.ajax({
					type : "POST",
					url : _ctx + "/regist",
					scriptCharset : "utf-8",
					data : {
						username : $("#regist_username").val(),
						password1 : $("#regist_password1").val(),
						password2 : $("#regist_password2").val(),
						firm_name : $("#regist_firm_name").val(),
						productid : $("#productid").val(),
						address : $("#cmbProvince").val() + ""
								+ $("#cmbCity").val() + ""
								+ $("#cmbArea").val() + ""
								+ $("#regist_address1").val(),
						founding_time : $("#regist_founding_time").val()
					},
					dataType : "json",
					success : function(data) {
						if ("success" == data.status) {
							window.location.href = _ctx + "/index";
						} else {
							$("#error-msg1").html(data.msg);
						}
					}
				})
			}
		});

// 重置内容
$("#reset_btn").click(function() {
	$("#regist_username").val("");
	$("#regist_password1").val("");
	$("#regist_password2").val("");
	$("#regist_firm_name").val("");
	$("#productid").val("1");
	$("#cmbProvince").val("-省-");
	$("#cmbCity").val("-市-");
	$("#cmbArea").val("-区-");
	$("#regist_address1").val("");
	$("#regist_founding_time").val("2018-08-08");

});

// 打开会员注册
$("#Regist_start_").click(function() {
	$("#login-box").hide();
	$("#regist-box").show();
});
$("#toLogin").click(function() {
	$("#regist-box").hide();
	$("#login-box").show();
});
