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
<title>接口列表</title>
<style>
a {
	color: #000;
}

a:hover {
	color: #669900;
}

#wrap {
	width: 80%;
	margin: 30px auto;
	overflow: hidden;
}

.list {
	width: 100%;
	padding: 0 0 20px 0;
	margin: 0 0 20px 0;
	border-bottom: 1px dashed #666633;
}

.list .date {
	float: left;
	width: 76px;
	height: 80px;
	margin: 0 20px 0 0;
	padding: 2px 0 0;
	background: #514F42;
	text-transform: uppercase;
	text-align: center;
	font-size: 10px;
	font-weight: bold;
	color: #FFF;
}

.list b {
	display: block;
	font-size: 40px;
	color: #FFF;
	line-height: 40px;
}

.list .meta {
	margin: 0 0 25px 0;
	float: left;
	float: right;
	color: #979680;
}

.list h2 a {
	font-size: 20px;
}

.list p {
	display: block;
	line-height: 20px;
}
</style>
</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<span>接口列表</span>
		</div>
		<div class="panel-body">
									<div id="wrap">

											<div class="form-group">
												<label for="pass" class="control-label">接口名</label> <input
													type="text" class="form-control" id="interName" placeholder="接口名"/ >
											</div>
											<div class="form-group">
												<label for="pass" class="control-label">创建者</label> <input
													type="text" class="form-control"  id="uName" placeholder="创建者">
											</div>
											<div class="form-group">
												<label for="name">模块</label> 
												<select id="module-id" class="form-control">
													<option value="0">请选择</option>
												</select>
											</div>
											<button class="btn btn-info btn-search" type="button" onclick="logPage(1,5)">查找</button>

										<br>
										<hr>
										<div id="inter-list">
											<div class="list">
												<p class="date">
													八月 <b>03</b>
												</p>
												<h2>
													<a href="#">一款简单的网页弹出层JS代码</a>
												</h2>
	
												<p>一款在网页中弹出层的实例代码，基于JS+css，本实例包含两个实例，一个是标准弹出层，另一个是弹出一个可拖动的层，并可设置层的标题，容器内容等，这是一个基本的层弹出单元，所有复杂的层弹出代码都可在此基础上进一步扩展。</p>
												<p class="meta">
													模块：<a href="/">首页</a>&nbsp;创建者：<a href="/">flyhero</a>&nbsp;&nbsp;<a
														href="#"><i class="fa fa-eye"></i> 详情</a> &nbsp;<a href="#"><i
														class="fa fa-wrench"></i> 调试</a>
												</p>
											</div>
										</div>
									</div>

									<center>
										<ul class="pagination">
										</ul>
									</center>		
		</div>
	</div>



    <script type="text/javascript">
    var projectId=${projectId};
    </script>
  	<script src="<%=request.getContextPath()%>/static/js/page/list-inter.js"></script> 
</body>
</html>