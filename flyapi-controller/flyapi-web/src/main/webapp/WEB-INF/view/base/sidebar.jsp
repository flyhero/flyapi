<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="navbar nav_title" style="border: 0;">
	<a href="#" class="site_title"><i class="fa fa-paper-plane"></i> <span>flyapi接口管理</span></a>
</div>

<div class="clearfix"></div>
<!-- menu profile quick info -->
<div class="profile">
	<div class="profile_pic">
		<img src="<%=request.getContextPath()%>${sessionScope.user.avatarUrl}"
			alt="..." class="img-circle profile_img">
	</div>
	<div class="profile_info">
		<span>Welcome,</span>
		<h2>${sessionScope.user.userName}</h2>
	</div>
</div>
<!-- /menu profile quick info -->

<br />
<hr>
<!-- sidebar menu -->
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3>………………………………</h3>
		<ul class="nav side-menu">
			<li><a href="#"><i class="fa fa-home"></i> 首页</a></li>
			<li><a><i class="fa fa-indent"></i> 我的项目 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu" id="user-project">
					<li><a href="javascript:void(0);" data-addtab="createProject"
						url="../forward/go.html?name=list_createdproject">我创建的</a></li>
					<li><a href="javascript:void(0);" data-addtab="join"
						url="../forward/go.html?name=list_joinproject">我参与的</a></li>

				</ul></li>
			<li><a><i class="fa fa-database"></i> 数据字典 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="javascript:void(0);" data-addtab="database"
						url="../forward/go.html?name=list_database">数据库</a></li>
				</ul></li>
			<li><a href="javascript:void(0);" data-addtab="listLive"
						url="../forward/go.html?name=list_live"><i class="fa fa-code"></i> 文字直播</a>
				</li>
				<li><a href="javascript:void(0);" data-addtab="jsonon"
						url="../forward/go.html?name=jsonon"><i class="glyphicon glyphicon-fire"></i> JSON格式化</a>
				</li>
				
		</ul>
	</div>

</div>
<!-- /sidebar menu -->
<!-- /menu footer buttons -->
<div class="sidebar-footer hidden-small">
	<a data-toggle="tooltip" data-placement="top" title="Settings"> <span
		class="glyphicon glyphicon-cog" aria-hidden="true"></span>
	</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
		<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
	</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
		class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
	</a> <a href="../user/logout.do" data-toggle="tooltip" data-placement="top"
		title="Logout"> <span class="glyphicon glyphicon-off"
		aria-hidden="true"></span>
	</a>
</div>
<!-- /menu footer buttons -->