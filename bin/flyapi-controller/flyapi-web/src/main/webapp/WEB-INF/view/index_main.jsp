<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="base/static.jsp"></jsp:include>
<title>首页</title>
</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">动态</h3>
		</div>
		<div class="panel-body">
			<ul class="list-unstyled msg_list">
			</ul>
			<center>
				<ul class="pagination">

				</ul>
			</center>
		</div>
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
							<span class="badge pull-right">2016.12.16</span> <a
								data-toggle="collapse" data-parent="#accordion"
								href="#collapseFour"> V2.2 </a>
						</h4>
					</div>
					<div id="collapseFour" class="panel-collapse collapse  in">
						<div class="panel-body">
							<ol>
								<li>修改bootstrap-tab支持iframe里按钮开启新tab</li>
								<li>使用Maven多模块进行项目管理</li>
								<li>网站信息动态加载</li>
								<li>分离jsp和js文件</li>
								<li>生成word文档时格式化JSON</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="badge pull-right">2016.12.12</span> <a
								data-toggle="collapse" data-parent="#accordion"
								href="#collapseThree"> V2.1 </a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse  in">
						<div class="panel-body">
							<ol>
								<li>后台使用bootstrap-tab</li>
								<li>使用quartz动态管理任务</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="badge pull-right">2016.11.5</span> <a
								data-toggle="collapse" data-parent="#accordion"
								href="#collapseTwo"> V2.0 </a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse  in">
						<div class="panel-body">
							<ol>
								<li>使用后台模板</li>
								<li>增加操作日志</li>
								<li>增加数据库表字典</li>
								<li>项目成员管理(增加、删除、权限修改)</li>
								<li>接口详情页使用markdown</li>
								<li>增加即时消息</li>
							</ol>
						</div>
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
					<div id="collapseOne" class="panel-collapse collapse">
						<div class="panel-body">
							<ol>
								<li>登录、注册功能</li>
								<li>新建、修改项目</li>
								<li>新建、修改模块</li>
								<li>新建、修改接口</li>
								<li>JSON格式化</li>
								<li>可编辑表格插件</li>
								<li>添加项目成员</li>
							</ol>
						</div>
					</div>
				</div>
			</div>


			<script type="text/javascript">
				var userId = ${sessionScope.user.userId};
			</script>
			<script
				src="<%=request.getContextPath()%>/static/js/page/index-main.js"></script>
</body>
</html>