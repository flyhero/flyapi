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
<title>主页</title>
<!-- Custom styling plus plugins -->
<link
	href="<%=request.getContextPath()%>/static/ace/production/css/custom1.css"
	rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<!-- page content -->
			<div class="right_col" role="main">

				<div class="">

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>项目详情</h2>
									<ul class="nav navbar-left panel_toolbox">
										<li><a href="../forward/new_database.html" class="collapse-link"><i
												class="fa fa-plus"></i>新建数据</a></li>
									</ul>
											
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a></li>
												<li><a href="#">Settings 2</a></li>
											</ul></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>

								<div class="x_content">
<!-- 								
						<div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>数据库名</i></h4>
                            <div class="left col-xs-12">
                              <h2>驱动包名</h2>
                              <ul class="list-unstyled">
                              	<li><i class="fa fa-user"></i>&nbsp; admin </li>
                                <li><i class="fa fa-lock"></i>&nbsp; ****** </li>
                              	<li><i class="fa fa-link"></i> jdbc:mysql://localhost:3306</li>
                                <li><i class="fa fa-calendar-o"></i>&nbsp; 2016-11-08</li>
                              </ul>
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
 -->									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

		</div>
	</div>
	<!-- Custom Theme Scripts -->
	<script
		src="<%=request.getContextPath()%>/static/ace/production/js/custom.js"></script>


	<script>
		$(function() {
			var userId=${sessionScope.user.userId};				
			$.ajax({
				type : 'POST',
				url : "../db/findDataBase.do",
				dataType : "json",
				data : {
					"userId":userId
				},
				success : function(data) {
					if (data.msg == 'ok') {
						$.each(data.data,function(index,db){
							$(".x_content").append('<div class="col-md-4 col-sm-4 col-xs-12 profile_details">'
			                       +'<div class="well profile_view">'
			                       +'  <div class="col-sm-12">'
			                       +'   <h4 class="brief"><i>'+db.dbName+'</i></h4>'
			                       +'   <div class="left col-xs-12">'
			                       +'     <h2>'+db.dbDriver+'</h2>'
			                       +'     <ul class="list-unstyled">'
			                       +'     	<li><i class="fa fa-user"></i>&nbsp; '+db.dbRoot+' </li>'
			                       +'       <li><i class="fa fa-lock"></i>&nbsp; ****** </li>'
			                       +'     	<li><i class="fa fa-link"></i>&nbsp; '+db.dbUrl+'</li>'
			                       +'       <li><i class="fa fa-calendar-o"></i>&nbsp; '+getMyDate(db.createTime)+'</li>'
			                       +'     </ul>'
			                       +'   </div>'
			                       +' </div>'
			                       +' <div class="col-xs-12 bottom text-center">'
			                       +'   <div class="col-xs-12 col-sm-6 emphasis">'
			                       +'     <button type="button" class="btn btn-primary btn-xs">'
			                       +'       <i class="fa fa-user"> </i> 查看详情'
			                       +'     </button>'
			                       +'   </div>'
			                       +' </div>'
			                       +'</div>'
			                       +'</div>');
						});
						
					} else {
						layer.alert("获取数据失败！");
					}

				}

			});
			
		});
	</script>

</body>
</html>