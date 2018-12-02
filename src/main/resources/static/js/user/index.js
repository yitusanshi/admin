function update_user_id(firm_username, firmId) {
	$("#update_firm_id").val(firmId);
	$("#firm_username").val(firm_username);
}

$(function() {
	$("#firm_update_password").click(function() {
		$.ajax({
			type : "POST",
			url : _ctx + "/editPassword",
			cache : false,
			dataType : "json",
			data : {
				firmid : $("#update_firm_id").val(),
				oldpassword : $("#old_firm_password").val(),
				newpassword1 : $("#new_firm_password1").val(),
				newpassword2 : $("#new_firm_password2").val(),
			},
			success : function(data) {
				if (data.status == 'success') {
					alert("密码修改成功！！！");
					$("#UserPassModal").modal("hide");
				} else {
					alert(data.msg);
				}
			}

		});
	});
})
