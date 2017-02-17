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
<title>我创建的项目</title>
</head>
<body>

	<table class="table table-no-bordered" id="cusTable"
		data-pagination="true" data-show-toggle="true">
	</table>
	<script type="text/javascript">
		var id = ${sessionScope.user.userId};
	</script>
	<script src="<%=request.getContextPath()%>/static/js/page/list-join.js"></script>
</body>
</html>