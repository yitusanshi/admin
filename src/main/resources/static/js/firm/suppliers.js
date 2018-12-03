$(function() {
	// 表格分页
	$('#suppliersList').DataTable({
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