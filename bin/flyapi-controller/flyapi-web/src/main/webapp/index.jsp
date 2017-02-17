<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>flyapi登录</title>
<meta name="description"
	content="" />
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<link rel="shortcut icon" href="img/favicon.ico">
 <base href="<%=basePath%>">
    <script type="text/javascript">
        top.location.href="${basePath}" + "forward/login.html";
    </script>
</head>
<body>
<!-- <h2>登录地址为：flyapi-web/forward/login.html</h2> -->
<%-- 	<jsp:forward page="WEB-INF/view/login.jsp"></jsp:forward> --%>
</body>
</html>
