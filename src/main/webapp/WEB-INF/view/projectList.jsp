<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="static.jsp"></jsp:include>
<title>我的项目</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

		<input id="userId" value="${ sessionScope.user.userId}" type="hidden" />
			<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<jsp:include page="sidebar.jsp"></jsp:include>
			</div>
			<div class="col-md-10">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active">我的项目</li>
					</ul>
				</div>
				<div class="list-group" id="myProject">
					<div href="#" class="list-group-item active">
						<a href="#" data-toggle="modal" data-target="#myModal"><span
							class="label label-warning pull-right">新建项目</span></a>
						<h4 class="list-group-item-heading">我的项目</h4>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">新建项目</h4>
					</div>
					<div class="modal-body">
						<label for="projectName">名称</label> <input type="text"
							class="form-control" id="projectName" placeholder="请输入名称">
						<label for="description">描述</label>
						<textarea id="description" class="form-control" rows="3"
							placeholder='描述'></textarea>
						<label for="projectVersion">版本</label> <input type="text"
							class="form-control" id="projectVersion" placeholder="版本">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="createProject" data-dismiss="modal"
							class="btn btn-primary">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</div>



	<!-- /.modal -->
	<script lanuage="javascript">

		$(function() {
			var id = $("#userId").val();
			$.ajax({
						type : "GET",
						url : "getMyProject.do",
						data : {
							userId : id
						},
						dataType : "json",
						success : function(data) {
							$.each(data,function(projectIndex, project) {
								var timestamp = project["project"].createTime;
												$("#myProject")
														.append(
																'<a href="goToModule.do?projectId='
																		+ project["project"].projectId
																		+ '" class="list-group-item"><span class="badge pull-right">'
																		+ project["project"].projectVersion
																		+ '</span><span class="badge pull-right">'
																		+ getMyDate(project["project"].createTime)
																		+ '</span><h4 class="list-group-item-heading">'
																		+ project["project"].projectName
																		+ '</h4><p class="list-group-item-text">'
																		+ project["project"].description
																		+ '</p></a>');
											});
						}
					});

			$("#createProject").click(
					function() {
						var projectName = $("#projectName").val();
						var projectVersion = $("#projectVersion").val();
						var description = $("#description").val();
						if (projectName != '' && description != ''
								&& description != '') {
							$.ajax({
								type : 'POST',
								url : "../project/addProject.do",
								dataType : "json",
								data : {
									projectName : projectName,
									projectVersion : projectVersion,
									description : description
								},
								success : function(data) {
									alert(data.msg);
									if (data.msg == 'success') {
										alert("创建成功！");
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