<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="base/static.jsp"></jsp:include>
<title>项目详情</title>
<link
	href="<%=request.getContextPath()%>/static/ace/production/css/custom.css"
	rel="stylesheet">
</head>
<body>
	<div class="container body">

		<!-- page content -->
		<div class="" role="main">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">项目详情</h3>
				</div>
				<div class="panel-body">


					<div class="col-md-9 col-sm-9 col-xs-12">

						<ul class="stats-overview">
							<li><span class="name"> 预计接口数</span> <span
								class="value text-success" id="target-inter"> </span></li>
							<li><span class="name"> 已完成接口 </span> <span
								class="value text-success" id="done-inter"> </span></li>
							<li class="hidden-phone"><span class="name"> 已创建（天） </span>
								<span class="value text-success" id="created-day"> </span></li>
						</ul>
						<br />
						<div id="mainb" style="height: 350px;"></div>
						<div>
							<h4>最近动态</h4>
							<!-- end of user messages -->
							<ul class="messages">

							</ul>
							<center>
								<ul class="pagination">

								</ul>
							</center>
							<!-- end of user messages -->

						</div>
					</div>

					<!-- start project-detail sidebar -->
					<div class="col-md-3 col-sm-3 col-xs-12">

						<section class="panel">

							<div class="x_title">
								<h2>项目描述</h2>
								<div class="clearfix"></div>
							</div>
							<div class="panel-body">
								<h3 class="green">
									<i class="fa fa-paint-brush"></i>&nbsp;
								</h3>

								<p id="prodes"></p>
								<br />

								<div class="project_detail">

									<p class="title">公司</p>
									<p id="company"></p>
									<p class="title">项目创建者</p>
									<p id="creator"></p>
								</div>

								<br />
								<h5>项目成员</h5>
								<ul class="list-unstyled project_files" id="team-member">
								</ul>
								<br />

								<div class=" mtop20">
									<c:choose>
										<c:when test="${isEdit== '1' || isEdit== 1 }">
											<a href="#" class="btn btn-sm btn-primary"
												data-toggle="modal" data-target="#addTeam">添加成员</a>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>

								</div>
								<br />
								<hr>
								<h5>项目模块</h5>
								<ul class="list-unstyled project_files" id="project-module">
								</ul>
								<br />

								<div class=" mtop20">
									<c:choose>
										<c:when test="${isEdit== '1' || isEdit== 1 }">
											<a href="#" class="btn btn-sm btn-primary"
												data-toggle="modal" data-target="#addModule">添加模块</a>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>

								</div>
							</div>

						</section>

					</div>

				</div>
			</div>

		</div>

		<div class="modal fade" id="editTeam" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改/删除权限</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" id="upID" /> <input type="hidden"
							id="projectID" /> <label for="userName">成员</label> <input
							type="text" class="form-control" id="userName"
							readonly="readonly"> <label for="isEdit">权限</label> <select
							id="isEdit" class="form-control">
							<option value="0">只读</option>
							<option value="1">可写</option>
						</select>
					</div>
					<div class="modal-footer">
						<button type="button" id="deleteTeam" class="btn btn-danger"
							data-dismiss="modal">删除</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="updatePermission" data-dismiss="modal"
							class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="addTeam" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">添加成员</h4>
					</div>
					<div class="modal-body">
						<label for="addName">成员用户名</label> <input type="text"
							class="form-control" id="addName" placeholder="请输入名称"> <label
							for="addisEdit">权限</label> <select id="addisEdit"
							class="form-control">
							<option value="0">只读</option>
							<option value="1">可写</option>
						</select>
					</div>
					<div class="modal-footer">
						<button type="button" id="checkUserName" class="btn btn-warning">检查用户</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="addTeamUser" data-dismiss="modal"
							class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="addModule" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel3" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel3">新建模块</h4>
					</div>
					<div class="modal-body">
						<label for="moduleName">名称</label> <input type="text"
							class="form-control" id="moduleName"> <label
							for="moduleDes">描述</label>
						<textarea id="moduleDes" class="form-control" rows="3"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="domodule" data-dismiss="modal"
							class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="editModule" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel3" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel3">修改/删除模块</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" id="editId" /> <label for="editName">名称</label>
						<input type="text" class="form-control" id="editName"> <label
							for="editDes">描述</label>
						<textarea id="editDes" class="form-control" rows="3"></textarea>
					</div>
					<div class="modal-footer">
						<button data-dismiss="modal" id="deleteMod"
							class="btn btn-sm btn-danger">删除</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button data-dismiss="modal" type="button" id="updateModule"
							class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /page content -->

	</div>

	<!-- ECharts -->
	<script src="<%=request.getContextPath()%>/static/ace/vendors/echarts/dist/echarts.min.js"></script>
	<script>
		var userEdit = ${isEdit};
		var myId = ${sessionScope.user.userId};
		var projectId = ${projectId};
		var upId = ${upId};
		var userId = ${sessionScope.user.userId};
	</script>
	<script
		src="<%=request.getContextPath()%>/static/js/page/detail-pro.js"></script>
</body>
</html>