<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String socketPath = request.getServerName() + ":"
			+ request.getServerPort() + path;
%>
<!-- top navigation -->
<div class="top_nav">

	<div class="nav_menu">
		<nav class="" role="navigation">
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a> <label>收缩扩展</label>
			</div>
			<div class="nav toggle">

				<a href="javascript:void(0);"  data-addtab="newProject" url="../forward/newProject.html" id="menu_toggle"><i
					class="fa fa-plus"></i><label>新建项目</label> </a> 
			</div>
			<div class="nav toggle">

				<a href="javascript:void(0);"  data-addtab="newInter" url="../forward/new_interfaces.html" id="menu_toggle"><i
					class="fa fa-plus"></i><label>新建接口</label> </a> 
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class=""><a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img
						src="<%=request.getContextPath()%>${sessionScope.user.avatarUrl}"
						alt="">${sessionScope.user.userName} <span
						class=" fa fa-angle-down"></span>
				</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li><a href="../user/logout.do"><i
								class="fa fa-sign-out pull-right"></i> 退出</a></li>
					</ul></li>

				<li role="presentation" class="dropdown"><a href="javascript:;"
					class="dropdown-toggle info-number" data-toggle="dropdown"
					aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
						class="badge bg-green">*</span>
				</a>
					<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
						role="menu">
					<li>
                      <div class="text-center">
                        <a>
                          <strong>无更多消息</strong>
                        </a>
                      </div>
                    </li>
					</ul></li>

			</ul>
		</nav>
	</div>

</div>
<!-- /top navigation -->
<script>
<%-- 	var path = '<%=socketPath%>';
	var uid = ${sessionScope.user.userId};
	var websocket;
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://" + path + "/ws?uid=" + uid);
	} else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("ws://" + path + "/ws" + uid);
	} else {
		websocket = new SockJS("http://" + path + "/ws/sockjs" + uid);
	}
	websocket.onopen = function(event) {
		console.log("WebSocket:已连接");
		console.log(event);
	};
	websocket.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var time=getMyDate(data.date);
		console.log("WebSocket:收到一条消息", data);
		$("#menu1").append('<li><a> <span class="image"> <img src="<%=request.getContextPath()%>${sessionScope.user.avatarUrl}"/></span><span><span>'+data.fromName+'</span><span class="time">'+time+'</span></span><span class="message">'+data.text+'</span></a></li>');
	};
	websocket.onerror = function(event) {
		console.log("WebSocket:发生错误 ");
		console.log(event);
	};
	websocket.onclose = function(event) {
		console.log("WebSocket:已关闭");
		console.log(event);
	} --%>
</script>