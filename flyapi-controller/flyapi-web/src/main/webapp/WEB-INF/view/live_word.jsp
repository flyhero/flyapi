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
<title>flyapi登录</title>
<meta name="description"
	content="" />
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<link rel="shortcut icon" href="img/favicon.ico">
<jsp:include page="base/static.jsp"></jsp:include>
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
				      </div>
			</div>
		</div>
	</div>


<script type="text/javascript">
 window.onbeforeunload=function (){
	if(event.clientX>document.body.clientWidth && event.clientY < 0 || event.altKey){
	    /*  alert("你关闭了浏览器"); */
	}else{
	    /*  alert("你正在刷新页面"); */
	}
	return "ok";
	} 
/* $(document).ready(function() {
	$('textarea').on('propertychange input', function(event) {
		alert($(this).val());
	});
}); */


</script>
<%-- <script>
	var path = '<%=socketPath%>';
	var uid = ${sessionScope.user.userId};
	var websocket;
	var to=uid==1?2:1;
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
		var v=$("#msg").val();
		if(v==""){
			return;
		}else{
			var data={};
			data["from"]=from;
			data["fromName"]=fromName;
			data["to"]=to;
			data["text"]=v;
			websocket.send(JSON.stringify(data));
		}
	} 
</script>--%>

<script type="text/javascript">

        var getting = {

        url:'server.php',

        dataType:'json',

        success:function(res) {

        console.log(res);

}

};

//关键在这里，Ajax定时访问服务端，不断获取数据 ，这里是1秒请求一次。

//window.setInterval(function(){$.ajax(getting)},1000);

</script>
</body>
</html>