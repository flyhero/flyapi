<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>我创建的项目</title>
<jsp:include page="base/static.jsp"></jsp:include>
</head>
<body>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">我创建的项目</h3>
					</div>
					<div class="panel-body">
						<table class="table table-no-bordered" id="cusTable"
							data-pagination="true" data-show-toggle="true">
						</table>
					</div>
				</div>


	<div class="modal fade" id="myModal2" tabindex="0" role="dialog"
		aria-labelledby="myModalLabel2" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel2">修改项目</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" id="projectid" /> <label for="projectName">名称</label>
					<input type="text" class="form-control" id="projectName"> <label
						for="description">描述</label>
					<textarea id="description" class="form-control" rows="3"></textarea>
					<label for="targetCount">预计接口</label> <input type="number"
						class="form-control" id="targetCount">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="changeProject" data-dismiss="modal"
						class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var id = ${sessionScope.user.userId};
	</script>
	<script src="<%=request.getContextPath()%>/static/js/page/list-created.js"></script>
</body>
</html>