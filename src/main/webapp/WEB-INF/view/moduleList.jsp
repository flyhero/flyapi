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
<title>模块</title>
</head>
<body>
	<input id="projectId" value="${project.projectId}" type="hidden" />
	<%@ include file="header.jsp"%>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<jsp:include page="sidebar.jsp"></jsp:include>
		</div>
		<div class="col-md-10">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li><a href="#">${project.projectName}</a></li>
						<li class="active">模块</li>
					</ul>
				</div>
			<div class="list-group" id="mymodule">
				<div class="list-group-item active">
					${up.isEdit == 0 ? '<a href="#" data-toggle="modal" data-target="#myModal3"><span class="badge pull-right">新建模块</span></a><a href="#" data-toggle="modal" data-target="#myModal2"><span class="badge pull-right">修改</span></a><a href="#" data-toggle="modal" data-target="#myModal"><span class="badge pull-right">添加参与人</span></a>' : ''}
					<h4 class="list-group-item-heading">${project.projectName}</h4>
				</div>
			</div>
			
		</div>
	</div>
	<!-- 按钮触发模态框 -->
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加参与人</h4>
				</div>
				<div class="modal-body">
					<label for="userName">参与人用户名</label> 
					<input type="text"
						class="form-control" id="userName" placeholder="请输入名称">
					<label for="isEdit">权限</label> 
					<select id="isEdit" class="form-control">
						<option value="1">只读</option>
						<option value="0">可写</option>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" id="checkUserName" class="btn btn-warning">检查用户</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="addActor" data-dismiss="modal"
						class="btn btn-primary">提交</button>
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
					<h4 class="modal-title" id="myModalLabel2">修改项目</h4>
				</div>
				<div class="modal-body">
					<label for="projectName">名称</label> <input type="text"
						class="form-control" id="projectName"
						value="${project.projectName}"> <label for="description">描述</label>
					<textarea id="description" class="form-control" rows="3">${project.description}</textarea>
					<label for="projectVersion">版本</label> <input type="text"
						class="form-control" id="projectVersion"
						value="${project.projectVersion}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="changeProject" data-dismiss="modal"
						class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
		</div>
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel3" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel3">新建模块</h4>
				</div>
				<div class="modal-body">
					<label for="moduleName">名称</label> 
					<input type="text" class="form-control" id="moduleName"> 
					<label for="moduleDes">描述</label>
					<textarea id="moduleDes" class="form-control" rows="3"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="addModule" data-dismiss="modal"
						class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<script lanuage="javascript">
			$(function() {
				var id = $("#projectId").val();
				$
						.ajax({
							type : "GET",
							url : "getModuleByprojectId.do",
							data : {
								projectId : id
							},
							dataType : "json",
							success : function(data) {
								$
										.each(
												data,
												function(moduleIndex, module) {
													$("#mymodule")
															.append(
																	'<a href="goToInterface.do?moduleId='
																			+ module["moduleId"]
																			+'&isEdit='
																			+'${up.isEdit}'
																			+'&projectName='
																			+'${project.projectName}'
																			+ '" class="list-group-item"><span class="badge pull-right">'
																			+ getMyDate(module["updateTime"])
																			+ '</span><h4 class="list-group-item-heading">'
																			+ module["moduleName"]
																			+ '</h4><p class="list-group-item-text">'
																			+ module["moduleDes"]
																			+ '</p></a>');
												});
							}
						});
				$("#addModule").click(function() {
					var moduleName = $("#moduleName").val();
					var moduleDes = $("#moduleDes").val();
					var projectId = ${project.projectId};
					if (moduleName != '' && moduleDes != ''
						&& projectId != '') {
		                $.ajax({  
		                    type : "POST",  //提交方式  
		                    url : "../module/addModule.do",//路径  
		                    data : {  
								moduleName : moduleName,
								moduleDes : moduleDes,
								projectId : projectId
		                    },//数据，这里使用的是Json格式进行传输  
		                    success : function(data) {//返回数据根据结果进行相应的处理  
								if (data.msg == 'success') {
									alert("添加成功^_^");
								} else {
									alert("添加失败！-_-");
								}
		                    }  
		                }); 
					} else {
						alert("用户名不能为空！");
					}

				});
				
				$("#checkUserName").click(function() {
					var userName = $("#userName").val();
					if (userName != '') {
						$.ajax({
							type : 'POST',
							url : "validUserName.do",
							dataType : "json",
							data : {
								userName : userName
							},
							success : function(data) {
								if (data.valid == false) {
									alert("用户存在^_^");
								} else {
									alert("用户不存在！-_-");
								}
							}

						});
					} else {
						alert("用户名不能为空！");
					}

				});
				$("#addActor").click(function() {
					var userName = $("#userName").val();
					var projectId = $("#projectId").val();
					var isEdit = $("#isEdit").val();
					if (userName != '' && projectId != '') {
						$.ajax({
							type : 'POST',
							url : "../project/addActor.do",
							dataType : "json",
							data : {
								userName : userName,
								projectId : projectId,
								isEdit : isEdit
							},
							success : function(data) {
								if (data.msg == 'success') {
									alert("添加成功^_^");
								} else {
									alert("添加失败！-_-");
								}
							}

						});
					} else {
						alert("用户名不能为空！");
					}

				});
				$("#changeProject").click(
						function() {
							var projectName = $("#projectName").val();
							var projectVersion = $("#projectVersion").val();
							var description = $("#description").val();
							var projectId =${project.projectId};
							if (projectName != '' && projectVersion != ''
									&& description != '') {
								$.ajax({
									type : 'POST',
									url : "../project/updateProject.do",
									dataType : "json",
									data : {
										projectName : projectName,
										projectVersion : projectVersion,
										description : description,
										projectId : projectId
									},
									success : function(data) {
										if (data.msg == 'success') {
											alert("创建成功！");
											location.reload();
										}

									}

								});
							} else {
								alert("信息不能为空！");
							}

						});
				

			});
		</script>
</body>
</html>