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
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">动态</h3>
					</div>
					<div class="panel-body">
					
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
			var dbId=${dbId};			
			var str='';
			$.ajax({
				type : 'POST',
				url : "../db/findTableInfo.do",
				dataType : "json",
				data : {
					"dbId":dbId
				},
				success : function(data) {
					if (data.msg == 'ok') {
						for(var i in data.data){
							str=str+'<table class="table table-bordered"><caption>'+data.data[i][0].tableName+'</caption>'
								 +' <thead>'
								 +' <tr>'
								 +'   <th>字段名</th>'
								 +'   <th>为空</th>'
								 +'   <th>类型</th>'
								 +'   <th>主键</th>'
								 +'   <th>默认值</th>'
								 +'   <th>注释</th>'
								 +' </tr>'
								 +'</thead>'
								 +'<tbody>';
							$.each(data.data[i],function(index,db){
								str=str+'<tr>'
							     +' <td>'+db.columnName+'</td>'
							     +' <td>'+db.isNullable+'</td>'
							     +'<td>'+db.columnType+'</td>'
							     +'<td>'+db.columnKey+'</td>'
							     +'<td>'+db.columnDefault+'</td>'
							     +'<td>'+db.columnComment+'</td>'
							     +'</tr>'
							});
							$(".panel-body").append(str+'</tbody></table>');
							str='';
						}
					} else {
						layer.alert("获取数据失败！");
					}

				}

			});
			
		});
	</script>

</body>
</html>