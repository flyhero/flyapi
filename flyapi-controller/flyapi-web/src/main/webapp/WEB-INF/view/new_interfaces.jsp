<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.css">
<link
	href="<%=request.getContextPath()%>/static/ace/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css" />
     <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/extensions/select2-filter/bootstrap-table-select2-filter.js"></script>
<script src="<%=request.getContextPath()%>/static/table/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/bootstrap-table.js"></script>
<script
	src="http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script
	src="<%=request.getContextPath()%>/static/table/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/editor/css/editormd.css" />
<script src="<%=request.getContextPath()%>/static/layer/layer.js"></script>


<title>新建接口</title>
</head>
<body>


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">新建接口</h3>
		</div>
		<div class="panel-body">

			<form id="defaultForm" class="form-horizontal form-label-left">
				<div class="form-group">
					<label class="col-lg-3 control-label">项目名称</label>
					<div class="col-lg-5">
						<select id="pro-name" class="form-control">
							<option value="0">请选择</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">模块</label>
					<div class="col-lg-5">
						<select id="module-name" class="form-control">
							<option value="0">请选择</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">1.1接口名称</label>
					<div class="col-lg-5">
						<input type="text" class="form-control" id="interName"
							placeholder="请输入接口名称">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">1.2接口描述</label>
					<div class="col-lg-5">
						<input type="text" class="form-control" id="interDes"
							placeholder="请输入接口描述">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">1.3接口状态</label>
					<div class="col-lg-5">
						<select id="status" class="form-control">
							<option value="0">可用</option>
							<option value="1">不可用</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.1调用地址</label>
					<div class="col-lg-5">
						<input type="text" class="form-control" id="interUrl"
							placeholder="请输入调用地址">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.2请求方式</label>
					<div class="col-lg-5">
						<select id="method" class="form-control">
							<option value="POST">POST</option>
							<option value="GET">GET</option>
							<option value="OPTIONS">OPTIONS</option>
							<option value="HEAD">HEAD</option>
							<option value="PUT">PUT</option>
							<option value="DELETE">DELETE</option>
							<option value="TRACE">TRACE</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.3请求参数</label>
					<div class="col-lg-5">
						<div id="toolbar">
							<button id="button" type="button" class="btn btn-default">添加</button>
							<button id="button1" type="button" class="btn btn-default">生成请求示例</button>
						</div>
						<table id="table" data-toggle="table" data-toolbar="#toolbar"
							data-height="240" data-click-to-select="true">
							<thead>
								<tr>
									<th data-field="state" data-checkbox="true"></th>
									<th data-field="name" data-editable="true">名称</th>
									<th data-field="isTrue" data-editable="true">是否必须</th>
									<th data-field="interType" data-editable="true">类型</th>
									<th data-field="des" data-editable="true">说明(以#分隔符，其后为参数值)</th>
								</tr>
							</thead>
						</table>
					<!-- 	<table class="table table-striped table-bordered table-hover" id="cusTable"></table> -->
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.4请求示例</label>
					<div class="col-lg-5">
						<textarea id="requestexam" class="form-control" rows="6"
							placeholder='{"description":"大学生发布的讲座","projectId":1,"projectName":"讲座来了","projectVersion":"V1.0"}'></textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.5返回参数说明</label>
					<div class="col-lg-5">
						<textarea id="responseparam" class="form-control" rows="6">msg:成功或失败,
des:文字说明,
result:返回数据</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.6成功返回示例</label>
					<div class="col-lg-5">
						<textarea id="trueexam" class="form-control" rows="5">{
	"msg":"ok",
	"des":"成功",
	"result":"",
}</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">2.7失败返回示例</label>
					<div class="col-lg-5">
						<textarea id="falseexam" class="form-control" rows="5">{
	"msg":"error",
	"des":"失败",
	"result":"",
}</textarea>
					</div>
				</div>
				<div class="ln_solid"></div>
				<div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
						<button type="button" class="btn btn-primary" id="createInterface">提交</button>
						<button type="button" class="btn btn-info" id="resetBtn">重置</button>
					</div>
				</div>
		</div>

		</form>


	</div>
	</div>

	<script type="text/javascript">
		var userId = ${sessionScope.user.userId};
	</script>
	<script
		src="<%=request.getContextPath()%>/static/editor/js/editormd.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/page/new-inter.js"></script>

</body>
</html>