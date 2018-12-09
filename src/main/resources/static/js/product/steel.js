function format(d) {
	// `d` is the original data object for the row
	return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'
			+ '<tr>' + '<td>用户名:</td>' + '<td>'
			+ d.username
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>厂商名称:</td>'
			+ '<td>'
			+ d.firmName
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>产品类型:</td>'
			+ '<td>'
			+ d.product
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>厂商地址:</td>'
			+ '<td>'
			+ d.address
			+ '</td>'
			+ '</tr>' + '</table>';
}

$(document)
		.ready(
				function() {
					var table = $('#steelsList').DataTable({
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

					// Add event listener for opening and closing details
					$('#steelsList tbody').on('click', 'td.details-control',
							function() {
								var tr = $(this).closest('tr');
								var row = table.row(tr);

								if (row.child.isShown()) {
									row.child.hide();
									tr.removeClass('shown');
								} else {
									row.child(format(row.data())).show();
									tr.addClass('shown');
								}
							});

					var rmc = $('#rmc').DataTable({
						"paging" : false,
						"ordering" : false,
						"info" : false,
						"searching" : false
					});
					var count = 1;
					$("#addRmcRow")
							.on(
									'click',
									function() {
										var s = '${categorylist[2]}';
										rmc.row
												.add(
														[
																"<input type='text' class='form-control' id='firm_phone' readonly='readonly' value='"
																		+ s
																		+ "'/>",
																"<input type='text' class='form-control' id='firm_phone' readonly='readonly' value='t'/>",
																"<input type='text' class='form-control' id='firm_phone'  />",
																"<input type='text' class='form-control' id='firm_phone' />",
																"<input type='text' class='form-control' id='firm_phone' />" ])
												.draw();
										count++;
									});
					$("#addRmcRow").click();

					$("#steel_save_btn").click(function() {
						alert("保存钢帘线按钮触发");
						/*
						 * $.ajax({ url : _ctx + "/product/save_steels", type :
						 * "POST", data : {
						 * JSON.stringify($('#save_steels').serializeObject()) },
						 * success : function() { alert("成功了。。。。"); }
						 * 
						 * });
						 */
					});

				});

function addRmcRowss(id) {
	var jsonstr = $.parseJSON(id);
	alert(jsonstr[2][0].unit);
}

/**
 * 自动将form表单封装成json对象
 */
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
function save_steels() {
	$.ajax({
		url : _ctx + "/product/save_steels",
		type : "POST",
		data : {
			"username" : "厂商",
			"records" : {
				"1" : JSON.stringify($('#save_steels1').serializeObject()),
				"2" : JSON.stringify($('#save_steels2').serializeObject())
			}
		}
	});

	/*
	 * $.ajax({ url : _ctx + "/product/save_steels", type : "POST", data : {
	 * usename:"厂商名称";
	 * save_steels:JSON.stringify($('#save_steels').serializeObject()); },
	 * success : function() { alert("成功了。。。。"); } });
	 */
}
