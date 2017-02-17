<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.css">
 <link href="<%=request.getContextPath()%>/static/ace/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet">
	
<script src="<%=request.getContextPath()%>/static/table/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.js"></script>
	<script src="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
	<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js"></script>
<title>接口</title>
</head>
<div class="container">
		<h3>1.功能说明</h3>
		<h4>1.1接口名称</h4>
		<input type="text" class="form-control" id="interName"
			placeholder="请输入接口名称">
		<h4>1.2接口描述</h4>
		<input type="text" class="form-control" id="interDes"
			placeholder="请输入接口描述">
		<h4>1.3接口状态</h4>
		<select id="status" class="form-control">
			<option value="0">可用</option>
			<option value="1">不可用</option>
		</select>
		<h3>2.调用说明</h3>
		<h4>2.1调用地址</h4>
		<input type="text" class="form-control" id="interUrl"
			placeholder="请输入调用地址">
		<h4>2.2请求方式</h4>
		<select id="method" class="form-control">
			<option value="POST">POST</option>
			<option value="GET">GET</option>
			<option value="OPTIONS">OPTIONS</option>
			<option value="HEAD">HEAD</option>
			<option value="PUT">PUT</option>
			<option value="DELETE">DELETE</option>
			<option value="TRACE">TRACE</option>
		</select>
		<h4>2.3请求头说明</h4>
		<div id="toolbar">
			<button id="button" type="button" class="btn btn-default">insertRow</button>
			<button id="button1" type="button" class="btn btn-default">getAllSelections</button>
		</div>
		<table id="table" data-toggle="table" data-toolbar="#toolbar"
			data-height="240" data-click-to-select="true">
			<thead>
				<tr>
					<th data-field="state" data-checkbox="true"></th>
					<th data-field="name" data-editable="true">名称</th>
					<th data-field="isTrue" data-editable="true">是否必须</th>
					<th data-field="interType" data-editable="true">类型</th>
					<th data-field="des" data-editable="true">说明</th>
				</tr>
			</thead>
		</table>
		<h4>2.4请求参数示例</h4>
		<textarea id="requestexam" class="form-control" rows="6"
			placeholder='{
	"description":"大学生发布的讲座",
	"projectId":1,
	"projectName":"讲座来了",
	"projectVersion":"V1.0"
}'></textarea>
		<h4>2.5返回参数说明</h4>
		<textarea id="responseparam" class="form-control" rows="6"
			placeholder='{
	"description":"大学生发布的讲座",
	"projectId":1,
	"projectName":"讲座来了",
	"projectVersion":"V1.0"
}'></textarea>
		<h4>2.6成功返回示例</h4>
		<textarea id="trueexam" class="form-control" rows="5"
			placeholder='{
	"msg":"success",
	"status":200,
	"data":"",
}'></textarea>
		<h4>2.6失败返回示例</h4>
		<textarea id="falseexam" class="form-control" rows="5"
			placeholder='{
	"msg":"error",
	"status":404,
	"data":"",
}'></textarea>
		</br>
		</br> <input type="button" class="form-control btn-info"
			id="createInterface" value="提交">
</div>

<script>
	var $table = $('#table'), $button = $('#button'), $button1 = $('#button1');

	$(function() {
		$button.click(function() {
			$table.bootstrapTable('insertRow', {
				index : 1,
				row : {
					name : '描述',
					isTrue : 'true',
					interType : 'int',
					des : '描述'
				}
			});
		});
		$button1.click(function() {
		 			alert('getSelections: '
							+ JSON.stringify($table
									.bootstrapTable('getAllSelections'))); 
				});
		
  		$("#createInterface").click(function() {
 			var interName=$("#interName").val();
 			var interDes=$("#interDes").val();
 			var status=$("#status").val();
 			var interUrl=$("#interUrl").val();
 			var method=$("#method").val();
 			var param=JSON.stringify($table
					.bootstrapTable('getAllSelections'));responseparam
 			var requestexam=$("#requestexam").val();
			var responseparam=$("#responseparam").val();
			var trueexam=$("#trueexam").val();
			var falseexam=$("#falseexam").val();
 			if(projectName != '' && description !=''&& description !=''){
	 			$.ajax({
	 				 type: 'POST',
	 				 url: "../interface/addInterface.do",
	 				 dataType: "json",
	 				 data: {
	 					interName:interName,
	 					interDes:interDes,
	 					status:status,
	 					interUrl:interUrl,
	 					method:method,
	 					param:param,
	 					requestexam:requestexam,
	 					responseparam:responseparam,
	 					trueexam:trueexam,
	 					falseexam:falseexam
	 				  },
	 				 success: function(data){
	 					 if(data.msg=='success'){
	 						 alert("创建成功！");
	 						 window.location.href="http://www.dayanmei.com/"; 
	 					 }else{
	 						alert("创建失败！"); 
	 					 }
	 					 
	                  }
	 				  
	 				});
 			}else{
 				alert("信息不能为空！");
 			}

		}); 
	});
</script>
</body>
</html>