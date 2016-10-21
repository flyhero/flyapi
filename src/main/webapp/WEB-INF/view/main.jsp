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
<title>主页</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2" id="mymenu">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="#"> 首页 </a>
							</h4>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="projectList.do"> 我的项目 </a>
							</h4>
						</div>
					</div>

				</div>
			</div>
			<div class="col-md-10">
				<ol class="breadcrumb">
					<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
					<li><a href="active">控制台</a></li>
				</ol>
				<div class="col-xs-12">
					<div class="alert alert-block alert-success">
						<button type="button" class="close" data-dismiss="alert">
							<i class="icon-remove"></i>
						</button>
						<i class="icon-ok green"></i> 欢迎使用 <strong class="green">
							flyapi接口管理系统 <small>(v1.0)</small>
						</strong>
					</div>



					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">版本日志</h3>
						</div>
						<div class="panel-body">

							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseThree"> V1.2 </a>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse collapse">
										<div class="panel-body">1.登录、注册功能 2.我的项目->新建项目</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo"> V1.1 </a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div class="panel-body">多数据源，日志监控</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<span class="badge pull-right">2016.10.20</span> <a
												data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"> V1.0 </a>
										</h4>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">1.登录、注册功能 2.我的项目->新建项目</div>
									</div>
								</div>
							</div>


						</div>
					</div>


				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<script>
	$(function() {
		var doc = $(document.body).height();
		var win = $(window).height();
		if (doc < win) {
			$("#mymenu").height(win - 220);
		} else {
			$("#mymenu").height(doc);
		}
	});
</script>
</html>