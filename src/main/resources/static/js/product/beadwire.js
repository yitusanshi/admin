$(document).ready(
        function() {
	        var table = $('#beadwiresList').DataTable({
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
	        $('#beadwiresList tbody').on('click', 'td.details-control', function() {
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

	        // 原料消耗table 中触发事件
	        var rmc = $('#rmc').DataTable({
	            "paging" : false,
	            "ordering" : false,
	            "info" : false,
	            "searching" : false,
	            "columnDefs" : [ {
	                // 定义操作列
	                "targets" : 6,
	                "data" : null,
	                "render" : function(data, type, row) {
		                var html = '<a href="javascript:void(0);"  class="delete btn btn-default btn-xs"><i class="fa fa-times"></i> 删除</a>';
		                return html;
	                }
	            } ],

	        });
	        // 原料消耗中点击select按钮，新增一行
	        $("#addRmcRow").on(
	                'click',
	                function() {
		                var cat_unit = $("#rmcSelect").val();
		                var categoryId = cat_unit.split("_")[0];
		                var unit = cat_unit.split("_")[1];
		                var categoryName = $("#rmcSelect").find("option:selected").text();
		                rmc.row.add(
		                        [ "<input type='hidden'  value='" + cat_unit + "'/>", "<input type='text' name='name_" + categoryId + "' class='form-control' id='name_" + categoryId + "' readonly='readonly' value='" + categoryName + "'/>",
		                                "<input type='text' name='unit_" + categoryId + "' class='form-control' id='unit_" + categoryId + "' readonly='readonly' value='" + unit + "'/>",
		                                "<input type='text' name='value_" + categoryId + "' class='form-control' value='0' id='value_" + categoryId + "'  />", "<input type='text' name='datasource_" + categoryId + "' class='form-control' id='datasource_" + categoryId + "' />",
		                                "<input type='text' name='desc_" + categoryId + "' class='form-control' id='desc_" + categoryId + "' />" ]).draw();
		                // 在select中删除已经点击的选项
		                $("#rmcSelect option[value=" + cat_unit + "]").remove();
	                });
	        /* $("#addRmcRow").click(); */

	        // 初始化原料消耗的刪除按钮
	        $('#rmc tbody').on('click', 'a.delete', function(e) {
		        e.preventDefault();
		        if (confirm("确定要删除该属性？")) {
			        var table = $('#rmc').DataTable();
			        var cat_unit = $(this).parents('tr').children('td').eq(0).children('input').val();
			        var categoryName = $(this).parents('tr').children('td').eq(1).children('input').val();
			        table.row($(this).parents('tr')).remove().draw();
			        $("#rmcSelect").append("<option value=" + cat_unit + ">" + categoryName + "</option>")
		        }

	        });

	        // 能源消耗table 中触发事件
	        var energy = $('#energy').DataTable({
	            "paging" : false,
	            "ordering" : false,
	            "info" : false,
	            "searching" : false,
	            "columnDefs" : [ {
	                // 定义操作列
	                "targets" : 6,
	                "data" : null,
	                "render" : function(data, type, row) {
		                var html = '<a href="javascript:void(0);"  class="delete btn btn-default btn-xs"><i class="fa fa-times"></i> 删除</a>';
		                return html;
	                }
	            } ],

	        });

	        // 能源消耗点击select新增一行
	        $("#addEnergyRow").on(
	                'click',
	                function() {
		                var cat_unit = $("#energySelect").val();
		                var categoryId = cat_unit.split("_")[0];
		                var unit = cat_unit.split("_")[1];
		                var categoryName = $("#energySelect").find("option:selected").text();
		                energy.row.add(
		                        [ "<input type='hidden'  value='" + cat_unit + "'/>", "<input type='text' name='name_" + categoryId + "' class='form-control' id='name_" + categoryId + "' readonly='readonly' value='" + categoryName + "'/>",
		                                "<input type='text' name='unit_" + categoryId + "' class='form-control' id='unit_" + categoryId + "' readonly='readonly' value='" + unit + "'/>",
		                                "<input type='text' name='value_" + categoryId + "' class='form-control' value='0' id='value_" + categoryId + "'  />", "<input type='text' name='datasource_" + categoryId + "' class='form-control' id='datasource_" + categoryId + "' />",
		                                "<input type='text' name='desc_" + categoryId + "' class='form-control' id='desc_" + categoryId + "' />" ]).draw();
		                // 在select中删除已经点击的选项
		                $("#energySelect option[value=" + cat_unit + "]").remove();
	                });
	        // 初始化原料消耗的刪除按钮
	        $('#energy tbody').on('click', 'a.delete', function(e) {
		        e.preventDefault();
		        if (confirm("确定要删除该属性？")) {
			        var table = $('#energy').DataTable();
			        var cat_unit = $(this).parents('tr').children('td').eq(0).children('input').val();
			        var categoryName = $(this).parents('tr').children('td').eq(1).children('input').val();
			        table.row($(this).parents('tr')).remove().draw();
			        $("#energySelect").append("<option value=" + cat_unit + ">" + categoryName + "</option>")
		        }

	        });

        });

/**
 * 自动将form表单封装成json对象序列化form表单
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

// 保存钢帘线的信息
function save_beadwires() {
	alert(JSON.stringify($('#save_pro').serializeObject()));
	alert(JSON.stringify($('#save_rmc').serializeObject()));
	alert(JSON.stringify($('#save_res').serializeObject()));
	$.ajax({
	    url : _ctx + "/product/save",
	    type : "POST",
	    data : {
	        "username" : "用户2",
	        "records" : {
	            "1" : JSON.stringify($('#save_pro').serializeObject()),
	            "2" : JSON.stringify($('#save_rmc').serializeObject()),
	            "4" : JSON.stringify($('#save_res').serializeObject()),
	            "5" : JSON.stringify($('#save_energy').serializeObject()),
	            "9" : JSON.stringify($('#save_natural_gas').serializeObject()),
	            "10" : JSON.stringify($('#save_elec_pro').serializeObject()),
	            "11" : JSON.stringify($('#save_pick_water').serializeObject()),
	            "12" : JSON.stringify($('#save_elec_water').serializeObject()),
	            "8" : JSON.stringify($('#save_solid_waste').serializeObject())
	           /* "13" : JSON.stringify($('#save_trans_pro').serializeObject())*/
	        }
	    },
	    success : function(data) {
		    if (data.status == 'success') {
			    alert("数据保存成功！");
		    } else {
			    alert(data.msg);
		    }
	    }
	});
}
