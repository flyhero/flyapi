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
<title>招聘页</title>
</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<span>招聘列表</span>
		</div>
		<div class="panel-body">
			<div class="row">
			
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <a href="#" class="panel-title">上海**网络科技有限公司 </a><div style="float:right"><button class="btn btn-default btn-sm">投递</button></div>
					    </div>
					    <div class="panel-body">
					    	<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#home" data-toggle="tab">基本信息</a></li>
								<li><a href="#jobDesc" data-toggle="tab">岗位职责</a></li>
								<li><a href="#jobAsk" data-toggle="tab">任职要求</a></li>
								<li><a href="#aboutCompany" data-toggle="tab">公司介绍</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="home"></br>
									 <i class="fa fa-fire fa-fw"></i>&nbsp;职位：&nbsp;&nbsp;Java开发工程师</br>
									 <i class="fa fa-rmb fa-fw"></i>&nbsp;薪资：&nbsp;&nbsp;8000-10000</br>
					    			 <i class="fa fa-map-marker fa-fw"></i>&nbsp;地址：&nbsp;&nbsp;上海松江区泗泾站</br>
					    			 <i class="fa fa-user fa-fw"></i>&nbsp;招聘人数：&nbsp;&nbsp;5</br>
					    			 <i class="fa fa-diamond fa-fw"></i>&nbsp;工作年限：&nbsp;&nbsp;1-3年</br>
					    			 <i class="fa fa-clock-o fa-fw"></i>&nbsp;发布日期：&nbsp;&nbsp;2017-03-01</br>
						    	</div>
								<div class="tab-pane fade" id="jobDesc"></br>
									<i class="glyphicon glyphicon-map-marker"></i>岗位职责:
						    		<ol>
						    			<li>根据公司产品要求进行核心业务开发，并能够根据自己的经验协助架构师优化系统架构；</li>
						    			<li>根据产品要求负责网站系统及APP服务器端系统的架构开发和核心代码的编写；</li>
						    			<li>制定系统相关的技术接口和技术规范；负责由业务模型到技术模型的转换； </li>
						    		</ol></br>
								</div>
								<div class="tab-pane fade" id="jobAsk"></br>
									<i class="glyphicon glyphicon-map-marker"></i>任职要求:
						    		<ol>
						    			<li>熟悉Java语言，熟悉J2EE体系结构；有WEBSPHERE平台使用经验者优先；</li>
						    			<li>有redis、memcache、Apache MQ,Swing,Gwt开发经验者优先考虑;</li>
						    			<li>具备较强的沟通交流能力和逻辑思维能力，肯吃苦耐劳，有责任心，有团队精神，乐于帮助同事; </li>
						    		</ol></br>
								</div>
								<div class="tab-pane fade" id="aboutCompany"></br>
								 	<i class="fa fa-bookmark fa-fw"></i>&nbsp;领域：&nbsp;&nbsp;移动互联网,企业服务</br>
								 	<i class="fa fa-line-chart fa-fw"></i>&nbsp;阶段：&nbsp;&nbsp;上市公司</br>
								 	<i class="fa fa-users fa-fw"></i>&nbsp;规模：&nbsp;&nbsp;50-150人</br>
						    		<p>海闻科技股份有限公司创立于2008年12月，是国内首家具备深厚的税务专业咨询服务能力的企业端税务管理信息系统整体解决方案供应商。
公司自成立以来，一直以“IT+T（信息化+税务服务）”的创新服务模式为引领戮力前行，专注于企业端的税务管理信息化系统建设，为客户提供大企业集团税务管理体系设计与搭建专业咨询、企业端税务管理系统定制化应用开发与系统集成、现有业务系统涉税改造IT咨询、税务管理系统部署实施、专业培训等一站式整体解决方案。</p>
								</div>
							</div>	

					    </div>
					</div>
				</div>
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <h3 class="panel-title">房间一</h3>
					    </div>
					    <div class="panel-body">
					        	在线n人
					    </div>
					</div>
				</div>
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <h3 class="panel-title">房间一</h3>
					    </div>
					    <div class="panel-body">
					        	在线n人
					    </div>
					</div>
				</div>
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <h3 class="panel-title">房间一</h3>
					    </div>
					    <div class="panel-body">
					        	在线n人
					    </div>
					</div>
				</div>
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <h3 class="panel-title">房间一</h3>
					    </div>
					    <div class="panel-body">
					        	在线n人
					        <a href="#" class="btn btn-default" role="button"> 按钮</a>
					    </div>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>


	<!-- Custom Theme Scripts -->
	<script
		src="<%=request.getContextPath()%>/static/ace/production/js/custom.js"></script>

</body>
</html>