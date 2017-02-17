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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/addTab/css/bootstrap.addtabs.css"
	type="text/css" media="screen" />
<script
	src="<%=request.getContextPath()%>/static/addTab/js/bootstrap.addtabs.js"></script>
<title>flyapi接口管理系统</title>
<!-- Custom styling plus plugins -->
<link
	href="<%=request.getContextPath()%>/static/ace/production/css/custom.css"
	rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<jsp:include page="base/sidebar.jsp"></jsp:include>

				</div>
			</div>

			<jsp:include page="base/top.jsp"></jsp:include>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="row">
					<div class="col-md-12">
						<div class="main">
							<div id="tabs">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" id="tab_tab_"
										aria-url="../forward/index_main.html" class="active"><a
										href="#home" aria-controls="home" role="tab" data-toggle="tab"><i
											class="fa fa-home"></i> 首页</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="home">
										<br>
										<iframe class="iframeClass" frameborder="no" border="0"
											src="../forward/index_main.html" style="height: 1800px;"></iframe>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /page content -->

	<!-- footer content -->
	<jsp:include page="base/footer.jsp"></jsp:include>
	<!-- /footer content -->
	</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/page/main.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/ace/production/js/custom.js"></script>
</body>
</html>