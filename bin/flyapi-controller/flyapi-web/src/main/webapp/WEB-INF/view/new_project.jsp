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
<title>新建项目</title>
</head>
<body>


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">新建项目</h3>
		</div>
		<div class="panel-body">


			<form id="defaultForm" class="form-horizontal">
				<fieldset>
					<div class="form-group">
						<label class="col-lg-3 control-label">项目名称</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="proName"
								id="proName" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">项目描述</label>
						<div class="col-lg-5">
							<textarea name="proDes" id="proDes" class="form-control" rows="3"
								placeholder='描述'></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">项目版本</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="proVersion"
								id="proVersion" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">预计接口</label>
						<div class="col-lg-5">
							<input type="number" class="form-control" name="targetCount"
								id="targetCount" />
						</div>
					</div>
				</fieldset>
				<div class="ln_solid"></div>
				<div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
						<button type="button" class="btn btn-primary" onclick="add();">提交</button>
						<button type="button" class="btn btn-info" id="resetBtn">重置</button>
					</div>
				</div>
			</form>


		</div>
	</div>

	<script src="<%=request.getContextPath()%>/static/js/page/new-pro.js"></script>

</body>
</html>