$("#login_btn").click(function() {
	alert("按钮触发了。。。。。");
	$.ajax({
		url : _ctx + "/product/insert_sbrs",
		type : "POST",
		data : {
			"insert_sbrs" : JSON.stringify($('#insert_sbrs').serializeObject())
		},
		/*contentType : "application/json",*/
		success : function() {
			alert("成功了。。。。");
		}

	});
});

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
