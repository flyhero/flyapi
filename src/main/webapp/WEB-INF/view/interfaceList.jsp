<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="static.jsp"></jsp:include>
<title>接口列表</title>
</head>
<body>
	<input id="moduleId" value="${module.moduleId}" type="hidden"/>
	<%@ include file="header.jsp" %>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<jsp:include page="sidebar.jsp"></jsp:include>
		</div>
		<div class="col-md-10">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li><a href="#">${projectName}</a></li>
						<li class="active">${module.moduleName}</li>
					</ul>
				</div>
			<div class="list-group" id="myinterface">
			    <div href="#" class="list-group-item active">
			    	${isEdit == 0 ? '<a href="#" data-toggle="modal" data-target="#myModal3"><span class="badge pull-right">新建接口</span></a><a href="#" data-toggle="modal" data-target="#myModal2"><span class="badge pull-right">修改模块</span></a>' : ''}
			        <h4 class="list-group-item-heading">
			          	 ${module.moduleName}
			        </h4>
			    </div>
			
			</div>
			
			</div>
		</div>
	<div class="modal fade" id="myModal2" tabindex="0" role="dialog"
		aria-labelledby="myModalLabel2" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel2">修改模块</h4>
				</div>
				<div class="modal-body">
					<label for="moduleName">名称</label> <input type="text"
						class="form-control" id="moduleName"
						value="${module.moduleName}"> <label for="moduleDes">描述</label>
					<textarea id="moduleDes" class="form-control" rows="3">${module.moduleDes}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="changeProject" data-dismiss="modal"
						class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
		</div>
	<div class="modal fade" id="myModal3" tabindex="0" role="dialog"
		aria-labelledby="myModalLabel3" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel3">新建接口</h4>
				</div>
				<div class="modal-body">
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
			<button id="button" type="button" class="btn btn-default">插入一行</button>
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
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="createInterface" data-dismiss="modal"
						class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
		</div>	
		<jsp:include page="footer.jsp"></jsp:include>	
		</div>
		<script lanuage="javascript">
	var $table = $('#table'), $button = $('#button'), $button1 = $('#button1'),$createInterface =$('#createInterface'); 

	$(function() {
		var id=$("#moduleId").val();
        $.ajax({
            type: "GET",
            url: "getInterfaceByModuleId.do",
            data: {moduleId:id},
            dataType: "json",
            success: function(data){
                        $.each(data, function(interfacesIndex, interfaces){
                            $("#myinterface").append('<a href="goToInterfaceDetail.do?interfaceId='+interfaces["interfaceId"]+'" class="list-group-item"><span class="badge pull-right">'+getMyDate(interfaces["updateTime"])+'</span><h4 class="list-group-item-heading">'+interfaces["interName"]+'</h4><p class="list-group-item-text">'+interfaces["interDes"]+'</p></a>');
                        });
                     }
        });
		
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
		
		$createInterface.click(function() {
 			var interName=$("#interName").val();
 			var interDes=$("#interDes").val();
 			var status=$("#status").val();
 			var interUrl=$("#interUrl").val();
 			var method=$("#method").val();
 			var param=JSON.stringify($table
					.bootstrapTable('getAllSelections'));
 			var requestexam=$("#requestexam").val();
			var responseparam=$("#responseparam").val();
			var trueexam=$("#trueexam").val();
			var falseexam=$("#falseexam").val();
			var moduleId=${module.moduleId};
 			if(interName != '' && interDes !=''&& interUrl !='' && requestexam !=''){
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
	 					falseexam:falseexam,
	 					moduleId:moduleId
	 				  },
	 				 success: function(data){
	 					 if(data.msg=='success'){
	 						 alert("创建成功！");
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