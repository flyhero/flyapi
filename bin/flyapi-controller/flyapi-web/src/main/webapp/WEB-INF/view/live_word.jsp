<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String socketPath = request.getServerName() + ":"
			+ request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>直播间</title>
<meta name="description"
	content="" />
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<link rel="shortcut icon" href="img/favicon.ico">
<jsp:include page="base/static.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/barrage/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/barrage/css/barrager.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/barrage/pick-a-color/css/pick-a-color-1.2.3.min.css">
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/barrage/syntaxhighlighter/styles/shCoreDefault.css"/>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<span>直播标题</span>
		</div>
		<div class="panel-body">
			<div class="row">
				      <div class="col-xs-8">
				         <textarea rows="40" style="width: 100%">直播内容</textarea>
				      </div>
				      <div class="col-xs-4">
				      	 <textarea rows="20" style="width: 100%">聊天内容</textarea>
				      	 <textarea rows="15" style="width: 100%">发送内容</textarea>
				      	 <button class="btn btn-info">发送</button>
				      </div>
			</div>
		</div>
		<input name="change"  value="弹幕" type="button" onclick="sendMsg()">
	</div>

    <!-- JS dependencies -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/js/tinycolor-0.9.15.min.js"></script>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/js/jquery.barrager.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/syntaxhighlighter/scripts/shCore.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/syntaxhighlighter/scripts/shBrushJScript.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/syntaxhighlighter/scripts/shBrushPhp.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/barrage/pick-a-color/js/pick-a-color-1.2.3.min.js"></script> 
<script type="text/javascript">
 window.onbeforeunload=function (){
	if(event.clientX>document.body.clientWidth && event.clientY < 0 || event.altKey){
	    /*  alert("你关闭了浏览器"); */
	}else{
	    /*  alert("你正在刷新页面"); */
	}
	return "ok";
	} 
 
	var path = '<%=socketPath%>';
	var uid = ${sessionScope.user.userId};
	var websocket;
	var to=roomId;
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
		$("textarea").val(data.text);
	};
	websocket.onerror = function(event) {
		console.log("WebSocket:发生错误 ");
		console.log(event);
	};
	websocket.onclose = function(event) {
		console.log("WebSocket:已关闭");
		console.log(event);
	}
	function sendMsg(){
		var msg=$("#msg").val();

		if(msg==""){
			return;
		}else{
		    var item={
		            img:'http://yaseng.org/jquery.barrager.js/static/img/heisenberg.png', //图片 
		            info: msg, //文字 
		            //href:'http://www.yaseng.org', //链接 
		            close:true, //显示关闭按钮 
		            speed:6, //延迟,单位秒,默认6 
		            bottom:70, //距离底部高度,单位px,默认随机 
		            color:'#fff', //颜色,默认白色 
		            old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
		          }
		    $('body').barrager(item);
			
			var data={};
			data["from"]=uid;
			data["fromName"]=fromName;
			data["to"]=to;
			data["text"]=msg;
			websocket.send(JSON.stringify(data));
		}
	} 
</script>
 
</body>
</html>