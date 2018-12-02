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
				firmid : $("#update_firm_id"),
				oldpassword : ("#old_firm_password"),
				newpassword1 : ("#new_firm_password1"),
				newpassword2 : ("#new_firm_password2"),
			},
			success : function(data) {
				if (data.status == 'success') {
					$("#UserPassModal").modal("hide");
				} else {
					alert(data.msg);
				}
			}

		});
	});
})
