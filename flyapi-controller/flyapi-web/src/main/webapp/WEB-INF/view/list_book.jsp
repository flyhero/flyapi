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
<title>图书</title>
</head>
<body>
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#home" data-toggle="tab">
            图书列表
        </a>
    </li>
    <li><a href="#ios" data-toggle="tab">我的图书</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
    <br>
       			<div class="row">
				<div class="col-xs-4">
					<div class="panel panel-info">
					    <div class="panel-heading">
					        <h3 class="panel-title"><span class="badge pull-right">结束</span>Java编程思想</h3>
					    </div>
					    <div class="panel-body">
					      		<div class="row">
									<div class="col-xs-7">
										<i class="fa fa-fire fa-fw"></i>&nbsp;类别：&nbsp;&nbsp;Java</br>
										 <i class="fa fa-rmb fa-fw"></i>&nbsp;价格：&nbsp;&nbsp;50元&nbsp;&nbsp;（邮费<span>5</span>元）</br>
						    			 <i class="fa fa-map-marker fa-fw"></i>&nbsp;地址：&nbsp;&nbsp;上海松江区泗泾站</br>
						    			 <i class="fa fa-diamond fa-fw"></i>&nbsp;联系方式：&nbsp;&nbsp;358681286</br>
						    			 <i class="fa fa-clock-o fa-fw"></i>&nbsp;发布日期：&nbsp;&nbsp;2017-03-01</br>
									</div>
									<div class="col-xs-5">
									
										<%-- <img class="img-responsive center-block" src="<%=request.getContextPath()%>${sessionScope.user.avatarUrl}" alt="..."> --%>
										<img class="img-responsive center-block" src="http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg" alt="...">
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
    <div class="tab-pane fade" id="ios">
        <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
            TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
    </div>
</div>


	<!-- Custom Theme Scripts -->
	<script
		src="<%=request.getContextPath()%>/static/ace/production/js/custom.js"></script>

</body>
</html>