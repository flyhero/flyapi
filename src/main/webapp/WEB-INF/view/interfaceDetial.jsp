<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="static.jsp"></jsp:include>
<title>接口</title>
</head>
<body>
	<%@ include file="header.jsp"%>
		<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<jsp:include page="sidebar.jsp"></jsp:include>
		</div>
		<div class="col-md-10">
			<ol class="breadcrumb">
				<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
				<li><a href="#">我的项目</a></li>
				<li class="#">模块</li>
				<li class="active">接口</li>
			</ol>
			<a href="#" data-toggle="modal" data-target="#myModal"><span class="label label-warning pull-right">调试接口</span></a>
			<div id="desc">
				<h3>1.功能说明</h3>
				<h4>1.1接口名称</h4>
				<blockquote>${interface1.interName}</blockquote>
				<h4>1.2接口描述</h4>
				<blockquote>${interface1.interDes}</blockquote>
				<h4>1.3接口状态</h4>
				<blockquote>${interface1.status == 0 ? "可用" : "不可用"}</blockquote>

				<h3>2.调用说明</h3>
				<h4>2.1调用地址</h4>
				<blockquote>${interface1.interUrl}</blockquote>
				<h4>2.2请求方式</h4>
				<blockquote>${interface1.method}</blockquote>
				<h4>2.3参数</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>名称</th>
							<th>是否必须</th>
							<th>类型</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody id="tbody">
					</tbody>
				</table>
				<h4>2.4请求参数示例</h4>
				<div id="requestexam" ></div>
				<h4>2.5返回参数说明</h4>
				<div id="responseparam"></div>
				<h4>2.6成功返回示例</h4>
				<div id="trueexam"></div>
				<h4>2.6失败返回示例</h4>
				<div id="falseexam"></div>
			</div>
		</div>
	</div>
			<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">接口调试</h4>
					</div>
					<div class="modal-body">
						         <div class="input-group">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default" type="button">请求方式</button>
				                    </span>
				                     	<select id="httpmethod" class="form-control">
													<option value="POST">POST</option>
													<option value="GET">GET</option>
										</select>
				                </div></br>
				                <div class="input-group">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default" type="button">请求地址</button>
				                    </span>
				                      <input id="httpUrl" type="text" class="form-control" value="${interface1.interUrl}">
				                </div></br>
				                <div class="input-group">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default" type="button">参数传输方式</button>
				                    </span>
				                     	<select id="jsonWay" class="form-control">
													<option value="1">JSON字符串(用于APP)</option>
													<option value="0">JSON对象(多用于WEB)</option>
										</select>
				                </div></br>
				                <div id="reqparam" class="form-group">
				                <label for="name">传输参数</label>
				                </div>
							  <div class="form-group">
							    <label for="name">返回数据</label>
							    <textarea id="responseE" class="form-control" rows="3"></textarea>
							  </div>
									
					</div>
					<div class="modal-footer">
						<button type="button" id="sendHttp" class="btn btn-primary">send</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div></br></br>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script lanuage="javascript">
		$(function() {
			var param = ${interface1.param};
			var myobj=eval(param);
			for(var i=0;i<myobj.length;i++){
				$("#tbody").append('<tr><td>'+myobj[i].name+'</td><td>'+myobj[i].isTrue+'</td><td>'+myobj[i].interType+'</td><td>'+myobj[i].des+'</td></tr>');
			}
			var requestexam = ${interface1.requestexam};
			var y1 = JSON.stringify(requestexam, null, 4);
			$("#requestexam").append(
					"<textarea class='form-control exam'>" + y1 + "</textarea>");
			$("#reqparam").append(
					"<textarea id='httpparam' class='form-control' rows='3'>" + y1 + "</textarea>");
			
			var responseparam = ${interface1.responseparam};
			var y2 = JSON.stringify(responseparam, null, 4);
			$("#responseparam").append("<textarea class='form-control exam'>" + y2 + "</textarea>");

			var trueexam = ${interface1.trueexam};
			var y3 = JSON.stringify(trueexam, null, 4);
			$("#trueexam").append("<textarea class='form-control exam'>" + y3 + "</textarea>");

			var falseexam = ${interface1.falseexam};
			var y4 = JSON.stringify(falseexam, null, 4);
			$("#falseexam").append("<textarea class='form-control exam'>" + y4 + "</textarea>");
 			$('.exam').each(
					function() {
						this.setAttribute('style', 'height:'
										+ (this.scrollHeight)
										+ 'px;overflow-y:hidden;');
					}); 
			
			$("#sendHttp").click(function() {
				var httpmethod=$("#httpmethod").val();
				var httpUrl=$("#httpUrl").val();
				var httpparam=$("#httpparam").val();
				var jsonWay=$("#jsonWay").val();
	 			if(httpmethod != '' && httpUrl !=''&& httpparam !=''){
		 			$.ajax({
		 				 type: 'POST',
		 				 url: "../interface/testHttp.do",
		 				 dataType: "json",
		 				 data: {
		 					"method":httpmethod,
		 					"url":httpUrl,
		 					"param":httpparam,
		 					"jsonWay":jsonWay
		 				  },
		 				 success: function(data){
		 					 if(data.msg=='success'){
		 						 $("#responseE").val(data.result);
		 					 }else{
		 						alert("返回失败！"); 
		 					 }
		 					 
		                  }
		 				  
		 				});
	 			}else{
	 				alert("信息不能为空！");
	 			}

			}); 
			
		});
	</script>
</body>
</html>