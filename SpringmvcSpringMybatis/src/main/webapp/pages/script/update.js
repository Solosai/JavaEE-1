$("#btUpdate").click(function() {
	var id = $('#id').text();
	var studentName = $('#studentName').val();
	var studentAge = $('#studentAge').val();
	var studentScore = $('#studentScore').val();
	var ul;
	if(id == null || id == undefined || id == ''){
		ul=ctx+ "/updateByIds.do"
	}else {
		ul=ctx + "/updateById.do";
	}
	$.ajax({
		type : "POST",
		async : true,
		url : ul,
		data : {
			"id" : id,
			"studentName" : studentName,
			"studentAge" : studentAge,
			"studentScore" : studentScore,
		},
		error : function() {
			alert("修改失败");
		},
		success : function(msg) {
			alert("修改成功");
			window.location.href=ctx + '/list.do';

		}
	});
});

