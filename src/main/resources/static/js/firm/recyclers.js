$(function() {
	// 表格分页
	$('#recyclersList').DataTable({
		"scrollX" : true,
		'paging' : true,
		'lengthChange' : true,
		'searching' : true,
		'ordering' : true,
		'info' : true,
		'autoWidth' : false,
		"pagingType" : "full_numbers",
		"pageLength" : 10,
		"oLanguage" : { // 语言设置
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "抱歉， 没有找到",
			"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			"sInfoEmpty" : "没有数据",
			"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
			"sZeroRecords" : "没有检索到数据",
			"sSearch" : "搜索:",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "前一页",
				"sNext" : "后一页",
				"sLast" : "尾页"
			}
		}
	});

	// 提示框
	$("[data-toggle='tooltip']").tooltip();
})




// 删除厂商信息
function delMaunfacturer(firmId) {
	if (confirm("你确定要删除吗？如果删除，此用户将不再能够登录！")) {
		$.ajax({
		    type : "POST",
		    url : _ctx + "/sys/deluser_by_firmid",
		    cache : false,
		    dataType : "json",
		    data : {
			    firmid : firmId
		    },
		    success : function(data) {
			    if (data.status == 'success') {
				    alert("删除用户成功！！！");
				    window.location.href = window.location.href;
			    } else {
				    alert(data.msg);
			    }
		    }
		});
	}
}


// 删除厂商信息
function delRecyclers(firmId) {
	alert(firmId);
	if (confirm("你确定要删除吗？如果删除，此用户将不再能够登录！")) {
		$.ajax({
			type : "POST",
			url : _ctx + "/firm/delMaunfacturer",
			cache : false,
			dataType : "json",
			data : {
				firmid : firmId
			},
			success : function(data) {
				if (data.status == 'success') {
					window.location.href = window.location.href;
				} else {
					alert(data.msg);
				}
			}
		});
	}
}

// 查看用户详情
function findRecyclersByFirmId(firmId) {
	$.ajax({
		type : "POST",
		url : _ctx + "/userinfo",
		cache : false,
		dataType : "json",
		data : {
			firmid : firmId
		},
		success : function(data) {
			if (data.status == 'success') {
				maunfacturer = data.data;
				$("#firm_username").val(maunfacturer.username);
				$("#firm_product").val(maunfacturer.product);
				$("#firmname").val(maunfacturer.firmName);
				$("#firm_address").val(maunfacturer.address);
				$("#firm_phone").val(maunfacturer.phone);
				$("#firm_departmen").val(maunfacturer.departmen);
				$("#firm_email").val(maunfacturer.email);
				$("#firm_foundingTime").val(maunfacturer.foundingTimestr);
				$("#firm_registerTime").val(maunfacturer.registerTimestr);
				$("#firm_desc").val(maunfacturer.desc);
			} else {
				alert(data.msg);
			}
		}

	})
}