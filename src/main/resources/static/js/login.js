function checkForm() {
    $('#regist_form').bootstrapValidator({
        fields: {
            regist_username: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 18,
                        message: '用户名长度必须在3到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            regist_password1: {
                message: '密码验证失败',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 18,
                        message: '密码长度必须在3到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '密码只能包含大写、小写、数字和下划线'
                    },
                    identical: {
                        field: 'regist_password2',
                        message: '密码输入不一致'
                    }
                }

            },
            regist_password2: {
                message: '确认密码验证失败',
                validators: {
                    notEmpty: {
                        message: '确认密码不能为空'
                    }
                },
                identical: {// 相同
                    field: 'regist_password1',
                    message: '两次密码不一致'
                }

            },
            regist_firm_name: {
                message: '厂商名称验证失败',
                validators: {
                    notEmpty: {
                        message: '厂商名称不能为空'
                    }
                }
            }
        }
    });
};
// 注册账户
$("#regist_btn").click(function () {
    $('#regist_form').bootstrapValidator(checkForm());
    var validator = $('#regist_form').data("bootstrapValidator");
    validator.validate(); // 手动触发验证
    if (validator.isValid()) {
        $.ajax({
            type: "POST",
            url: _ctx + "/regist",
            scriptCharset: "utf-8",
            data: {
                username: $("#regist_username").val(),
                password1: $("#regist_password1").val(),
                password2: $("#regist_password2").val(),
                firm_name: $("#regist_firm_name").val(),
                productid: $("#productid").val(),
                phone: $("#regist_phone").val(),
                address: $("#cmbProvince").val() + "" + $("#cmbCity").val() + "" + $("#cmbArea").val() + "" + $("#regist_address1").val(),
                founding_time: $("#regist_founding_time").val()
            },
            dataType: "json",
            success: function (data) {
                if ("success" == data.status) {
                    alert("注册成功,返回登录界面！！！");
                    window.location.href = _ctx;
                } else {
                    $("#error-msg1").html(data.msg);
                }
            }
        })
    }
});

// 重置内容
$("#reset_btn").click(function () {
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
$("#Regist_start_").click(function () {
    $("#login-box").hide();
    $("#regist-box").show();
});
$("#toLogin").click(function () {
    $("#regist-box").hide();
    $("#login-box").show();
});

function showTel() {
    alert("联系人：张吉春\n联系电话：13521606046");
}
