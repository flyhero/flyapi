<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

		<div class="navbar navbar-default" id="navbar" role="navigation" style="border:1px solid green;">

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							flyapi接口管理系统 V2.0
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->


				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav navbar-nav navbar-right"> 
			            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${ sessionScope.user.userName}</a></li> 
			            <li><a href="<%=request.getContextPath()%>/user/logout.do"><span class="glyphicon glyphicon-log-out"></span> 退出 &nbsp;&nbsp;&nbsp;&nbsp;</a></li> 
			        </ul> 
				</div>
			</div>
		</div>