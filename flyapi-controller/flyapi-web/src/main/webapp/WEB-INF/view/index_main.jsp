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
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">
				&times;
				</button>
				你好！你的赞助我将用于域名和服务器的购买。感谢你的支持！
			</div>
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
		<div class="panel-body" id="versionLog">
		</div>
	</div>


			<script type="text/javascript">
				var userId = ${sessionScope.user.userId};
				
				//墨绿深蓝风
/* 				layer.alert('你好！你的赞助我将用于域名和服务器的购买。', {
				  skin: 'layui-layer-molv', //样式类名
				  closeBtn: 0,
				  title:"感谢你的支持",
				  offset: '100px'
				}); */
			</script>
			<script
				src="<%=request.getContextPath()%>/static/js/page/index-main.js"></script>
</body>
</html>