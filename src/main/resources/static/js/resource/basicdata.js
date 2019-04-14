$(function() {
	// 表格分页
	$('#dataList').DataTable({
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

function showBasicDataModal(record, firm) {
	var records = JSON.parse(record);
	var firms = JSON.parse(firm);

	var tr = "";
	tr += "<table id='BasicDataList' class='table table-bordered table-striped'><caption>" + firms.product.substring(0, firms.product.lastIndexOf('_')) + "数据收集表</caption>";
	tr+="<thead><tr><td width='20%'>企业名称：</td><td colspan='5'>"+firms.firmName+"</td></tr>";
	tr+="<thead><tr><td width='20%'>企业地址：</td><td colspan='5'>"+firms.address+"</td></tr>";
	tr+="<thead><tr><td width='20%'>数据申报年份：</td><td colspan='5'>"+records[0].dataYear+"</td></tr>";
	tr += "<tr><td width='20%'>分类</td><td width='20%'>种类</td><td width='10%'>单位</td><td width='10%'>数值</td><td width='10%'>数据来源</td><td width='10%'>备注</td></tr></thead>";
	tr += "<tbody>";
	for (var i = 0; i < records.length; i++) {

		tr += "<tr><td style='text-align: center; vertical-align: middle;'>"+records[i].classifyName+"</td>";
		tr += "<td>"+ records[i].categoryName + "</td>";
		tr += "<td>"+records[i].unit + "</td>";
		tr += "<td>"+ records[i].productVolume + "</td>";
		tr += "<td>  </td>";
		tr += "<td>  </td>";
		tr += "</tr>";
	};
	tr += "</tbody></table>";

	$('#BasicData').html(tr);
	$('#BasicDataList').mergeCell({
		cols : [ 0 ]
	});
}
