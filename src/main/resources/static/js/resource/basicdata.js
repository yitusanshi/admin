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
	tr+="<div><span style='text-align: center;'>ok</span>";
	tr += "<table><tr><th style='text-align: center;'>"+firms.product.substring(0,firms.product.lastIndexOf('_'))+"数据收集表</th></tr>";

	tr += "</table></div>";

	/*
	 * if (ispass == 0) { tr += "<span>暂无权限</span>"; } else { var jsonArr =
	 * JSON.parse(Id); var len = jsonArr.length;
	 * 
	 * for (var i = 0; i < jsonArr.length; i++) { if (jsonArr[i].classifyName ==
	 * "固体废弃物" || jsonArr[i].classifyName == "产品产出" || jsonArr[i].classifyName ==
	 * "运输过程_海运" || jsonArr[i].classifyName == "运输过程_空运" ||
	 * jsonArr[i].classifyName == "运输过程_陆运") { } else { tr += "<tr>" tr += "<td style='text-align: center; vertical-align: middle;'>" +
	 * jsonArr[i].classifyName + "</td>"; tr += "<td>" +
	 * jsonArr[i].categoryName + "</td>"; tr += "<td>" + jsonArr[i].unit + "</td>";
	 * if (jsonArr[i].reference == 0) { tr += "<td style='color: blue;'>无基准值</td>"; }
	 * else { tr += "<td>" + jsonArr[i].reference + "</td>"; }
	 * 
	 * tr += "<td>" + jsonArr[i].result + "</td>"; if (jsonArr[i].dataType ==
	 * -1) { tr += "<td style='color: green;'>无法判断</td>"; } else { if
	 * (jsonArr[i].isPass == 1) { tr += "<td>达标</td>"; } else { tr += "<td style='color: red;'>不达标</td>"; } }
	 * tr += "</tr>"; } } }
	 */
	$('#BasicData').html(tr);
	$('#BasicDataList').mergeCell({
		cols : [ 0 ]
	});

}
