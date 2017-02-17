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
<jsp:include page="base/static.jsp"></jsp:include>
<title>接口</title>
</head>
<body>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">接口调试</h3>
					</div>
					<div class="panel-body">
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
				                      <input id="httpUrl" type="text" class="form-control">
				                </div></br>
				                <div class="input-group">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default" type="button">参数传输方式</button>
				                    </span>
				                     	<select id="jsonWay" class="form-control">
													<option value="1">JSON字符串(application/json)</option>
													<option value="0">表单提交 (application/x-www-form-urlencoded;charset=utf-8)</option>
										</select>
				                </div></br>
				                <div id="reqparam" class="form-group">
				                <label for="name">传输参数</label>
				                <textarea id='httpparam' class='form-control' rows='6'></textarea>
				                </div>
							  <div id="backData" class="form-group">
							    <label for="name">返回数据</label>
							    <textarea id="responseE" class="form-control exam"></textarea> 
							  </div>
							  <button type="button" id="sendHttp" class="btn btn-primary">send</button>
					</div>
					
				</div>
	</div>
	<script lanuage="javascript">
		$(function() {
			var interId = ${interfaceId};
    		$.ajax({
    			type : 'POST',
    			url : "../interface/findOneInter.do",
    			dataType : "json",
    			data : {
    				"interfaceId":interId
    			},
    			success : function(data) {
    					$("#httpUrl").val(data.data.interUrl);
    					$("#httpparam").val(data.data.requestExam);
    				
    			}

    		}); 
			
/* 			var param = ${interface1.param};
			var myobj=eval(param);
			for(var i=0;i<myobj.length;i++){
				$("#tbody").append('<tr><td>'+myobj[i].name+'</td><td>'+myobj[i].isTrue+'</td><td>'+myobj[i].interType+'</td><td>'+myobj[i].des+'</td></tr>');
			}
			var requestexam = ${interface1.requestexam};
			var y1 = JSON.stringify(requestexam, null, 4);
			$("#reqparam").append(
					"<textarea id='httpparam' class='form-control' rows='3'>" + y1 + "</textarea>");
			
			var responseparam = ${interface1.responseparam};
			var y2 = JSON.stringify(responseparam, null, 4);
			$("#responseparam").append("<textarea class='form-control exam'>" + y2 + "</textarea>"); 
			*/

 			
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
		 					 if(data.msg=='ok'){
		 						var fdStart = data.result.indexOf("{");
		 						var resExam;
		 						 if(fdStart==0){
		 							 resExam=JSON.stringify(JSON.parse(data.result), null, 4);
		 						 }else{
		 							resExam=data.result;
		 						 }
		 						 $("#responseE").val(resExam); 
		 				 		 $('.exam').each(
		 									function() {
		 										this.setAttribute('style', 'height:'
		 														+ (this.scrollHeight)
		 														+ 'px;overflow-y:hidden;');
		 									}); 
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