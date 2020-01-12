$(function () {
    $('.form_time').datetimepicker({
        format: 'yyyy',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 4,
        forceParse: false,
        language: 'zh-CN'
    });
})
$(document).ready(
    function () {
        var table = $('#productList').DataTable({
            "scrollX": true,
            'paging': true,
            'lengthChange': true,
            'searching': true,
            'ordering': true,
            'info': true,
            'autoWidth': false,
            "pagingType": "full_numbers",
            "pageLength": 10,
            "oLanguage": { // 语言设置
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "搜索:",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                }
            }

        });
        // 原料消耗table 中触发事件
        var rmc = $('#rmc').DataTable({
            "paging": false,
            "ordering": false,
            "info": false,
            "searching": false,
            "columnDefs": [{
                // 定义操作列
                "targets": 6,
                "data": null,
                "render": function (data, type, row) {
                    var html = '<a href="javascript:void(0);"  class="delete btn btn-default btn-xs"><i class="fa fa-times"></i> 删除</a>';
                    return html;
                }
            }],

        });
        // 原料消耗中点击select按钮，新增一行
        $("#addRmcRow").on(
            'click',
            function () {
                var cat_unit = $("#rmcSelect").val();
                var categoryId = cat_unit.split("_")[0];
                var unit = cat_unit.split("_")[1];
                var categoryName = $("#rmcSelect").find("option:selected").text();
                rmc.row.add(
                    ["<input type='hidden'  value='" + cat_unit + "'/>",
                        "<input type='text' name='name_" + categoryId + "' class='form-control' style='width:180px;' id='name_" + categoryId + "' readonly='readonly' value='" + categoryName + "'/>",
                        "<input type='text' name='unit_" + categoryId + "' class='form-control' style='width:90px;' id='unit_" + categoryId + "' readonly='readonly' value='" + unit + "'/>",
                        "<input type='text' name='value_" + categoryId + "' class='form-control' style='width:150px;' value='0' onkeyup=\"this.value=this.value.replace(/[^\\d.]/g,'')\" id='value_" + categoryId + "'  />",
                        "<input type='text' name='datasource_" + categoryId + "' class='form-control'  style='width:150px;' id='datasource_" + categoryId + "' />",
                        "<input type='text' name='desc_" + categoryId + "' class='form-control' id='desc_" + categoryId + "' />",
                        "<input type='text' name='type_" + categoryId + "' class='form-control' style='width:150px;' value='0' style='display:none;' id='type_" + categoryId + "'  />"]).draw();
                // 在select中删除已经点击的选项
                $("#rmcSelect option[value=" + cat_unit + "]").remove();
            });
        /* $("#addRmcRow").click(); */

        // 初始化原料消耗的刪除按钮
        $('#rmc tbody').on('click', 'a.delete', function (e) {
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
            "paging": false,
            "ordering": false,
            "info": false,
            "searching": false,
            "columnDefs": [{
                // 定义操作列
                "targets": 6,
                "data": null,
                "render": function (data, type, row) {
                    var html = '<a href="javascript:void(0);"  class="delete btn btn-default btn-xs"><i class="fa fa-times"></i> 删除</a>';
                    return html;
                }
            }],

        });

        // 能源消耗点击select新增一行
        $("#addEnergyRow").on(
            'click',
            function () {
                var cat_unit = $("#energySelect").val();
                var categoryId = cat_unit.split("_")[0];
                var unit = cat_unit.split("_")[1];
                var categoryName = $("#energySelect").find("option:selected").text();
                energy.row.add(
                    ["<input type='hidden'  value='" + cat_unit + "'/>",
                        "<input type='text' name='name_" + categoryId + "' class='form-control' style='width:180px;' id='name_" + categoryId + "' readonly='readonly' value='" + categoryName + "'/>",
                        "<input type='text' name='unit_" + categoryId + "' class='form-control' style='width:90px;' id='unit_" + categoryId + "' readonly='readonly' value='" + unit + "'/>",
                        "<input type='text' name='value_" + categoryId + "' class='form-control' style='width:150px;' value='0' onkeyup=\"this.value=this.value.replace(/[^\\d.]/g,'')\" id='value_" + categoryId + "'  />",
                        "<input type='text' name='datasource_" + categoryId + "' class='form-control' style='width:150px;' id='datasource_" + categoryId + "' />",
                        "<input type='text' name='desc_" + categoryId + "' class='form-control' id='desc_" + categoryId + "' />",
                        "<input type='text' name='type_" + categoryId + "' class='form-control' style='width:150px;' value='0' style='display:none;' id='type_" + categoryId + "'  />"]).draw();
                // 在select中删除已经点击的选项
                $("#energySelect option[value=" + cat_unit + "]").remove();
            });
        // 初始化原料消耗的刪除按钮
        $('#energy tbody').on('click', 'a.delete', function (e) {
            e.preventDefault();
            if (confirm("确定要删除该属性？")) {
                var table = $('#energy').DataTable();
                var cat_unit = $(this).parents('tr').children('td').eq(0).children('input').val();
                var categoryName = $(this).parents('tr').children('td').eq(1).children('input').val();
                table.row($(this).parents('tr')).remove().draw();
                $("#energySelect").append("<option value=" + cat_unit + ">" + categoryName + "</option>")
            }

        });

        /*
         * $(#ProductsModal).on("show.sb.modal",function(e){ alert("ok");
         * alert($(e.target).data()); alert($(e.relatedTarget).data()); });
         */

    });

/**
 * 自动将form表单封装成json对象序列化form表单
 */
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

// 保存胎圈钢丝的信息
function save_beadwires() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存炭黑信息
function save_carbons() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存合成橡胶（顺丁橡胶）的信息
function save_ciss() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddSteelsModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存轮胎的信息
function save_tyres() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject())
                /* "0" : JSON.stringify($('#save_trans_pro').serializeObject()) */
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存天然橡胶信息
function save_nrs() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存尼龙的信息
function save_nylons() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存再生胶的信息
function save_rrs() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject())
                /* "0" : JSON.stringify($('#save_trans_pro').serializeObject()) */
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存合成橡胶（丁苯橡胶）
function save_sbrs() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

// 保存钢帘线的信息
function save_steels() {
    $.ajax({
        url: _ctx + "/product/save",
        type: "POST",
        data: {
            "username": $("#firmUsername").val(),
            "datayear": $("#dateyear").val(),
            "records": {
                "1": JSON.stringify($('#save_pro').serializeObject()),
                "2": JSON.stringify($('#save_rmc').serializeObject()),
                "4": JSON.stringify($('#save_res').serializeObject()),
                "5": JSON.stringify($('#save_energy').serializeObject()),
                "6": JSON.stringify($('#save_natural_gas').serializeObject()),
                "7": JSON.stringify($('#save_pick_water').serializeObject()),
                "8": JSON.stringify($('#save_solid_waste').serializeObject()),
                "0": JSON.stringify($('#save_trans_pro').serializeObject())
            }
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#AddModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }
    });
}

function showModal(Id, ispass) {
    var tr = "";
    if (ispass == 0) {
        tr += "<span>暂无权限</span>";
    } else {
        var jsonArr = JSON.parse(Id);
        var len = jsonArr.length;

        for (var i = 0; i < jsonArr.length; i++) {
            if (jsonArr[i].classifyName == "固体废弃物" || jsonArr[i].classifyName == "产品产出" || jsonArr[i].classifyName == "运输过程_海运" || jsonArr[i].classifyName == "运输过程_空运" || jsonArr[i].classifyName == "运输过程_陆运") {
            } else {
                tr += "<tr>"
                tr += "<td style='text-align: center; vertical-align: middle;'>" + jsonArr[i].classifyName + "</td>";
                tr += "<td>" + jsonArr[i].categoryName + "</td>";
                tr += "<td>" + jsonArr[i].unit + "</td>";
                if (jsonArr[i].reference == 0) {
                    tr += "<td style='color: blue;'>无基准值</td>";
                } else {
                    tr += "<td>" + jsonArr[i].reference + "</td>";
                }

                if (jsonArr[i].dataType == -1) {
                    tr += "<td>/</td>";
                    tr += "<td style='color: green;'>无法判断</td>";
                } else {
                    tr += "<td>" + jsonArr[i].result + "</td>";
                    if (jsonArr[i].isPass == 1 || jsonArr[i].reference == 0) {
                        tr += "<td>达标</td>";
                    } else {
                        tr += "<td style='color: red;'>不达标</td>";
                    }
                }
                tr += "</tr>";
            }

        }
    }
    $('#tabtt').html(tr);
    $('#indexsList').mergeCell({
        cols: [0]
    });

}


function updateModal(tagTime, dataYear, firmId) {
    $.ajax({
        url: _ctx + "/getRecordData",
        type: "POST",
        data: {
            "tagTime": tagTime,
            "firmId": firmId,
            "dataYear": dataYear
        },
        success: function (data) {
            if (data.status == 'success') {
                var data = data.data;
                var tr = "";
                for (var i = 0; i < data.length; i++) {
                    tr += "<tr>"
                    tr += '<td style="display: none"><input name="id" value="' + data[i].id + '"></td>';
                    tr += '<td>' + data[i].classifyName + '</td>';
                    tr += '<td>' + data[i].categoryName + '</td>';
                    tr += '<td>' + data[i].dataYear + '</td>';
                    /*tr += '<td>' + data[i].dataSource + '</td>';*/
                    tr += '<td><select class="form-control" name="dataType"><option value="0" selected="selected">实测值</option><option value="1">估算值</option><option value="-1">未监测</option></select></td>';
                    tr += '<td><input type="text" class="form-control" name="productVolume" style="border: 0px;" value="' + data[i].productVolume
                        + '" onkeyup="this.value=this.value.replace(/[^\\d.]/g,\'\')"/></td>';
                    tr += '<td>' + data[i].unit + '</td>';
                    tr += "</tr>"
                }
                $('#updateTable').html(tr);
            } else {
                alert("数据异常！请联系管理员");
            }
        }
    });
}

function updateData() {
    $.ajax({
        url: _ctx + "/product/update",
        type: "POST",
        data: {
            "dataValue": JSON.stringify($('#updateData').serializeObject()),
        },
        success: function (data) {
            if (data.status == 'success') {
                alert("数据保存成功！");
                $("#UpdatesModal").modal('hide');
                window.location.href = window.location.href;
            } else {
                alert(data.msg);
            }
        }

    });
}
