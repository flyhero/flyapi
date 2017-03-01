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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/editor/css/editormd.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/editor/css/editormd.preview.css" />

<title>简历</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<span>详情</span> &nbsp;&nbsp;
			<span>
				<button id="goto-line-btn" onclick="window.print();">
						<i class="fa fa-download"></i>下载PDF
				</button>
			</span>
			<span class="label label-success" style="float: right" id="lastTime">最后修改时间：</span>
			
		</div>
		<div class="panel-body">
				<div id="resume-view">
					<textarea style="display: none;" name="test-editormd-markdown-doc"></textarea>
				</div>
		</div>
	</div>

	<script type="text/javascript">
		var userId = ${userId};
		
		var mask_div = document.createElement('div');
		mask_div.id = 'mask_div1';
		mask_div.appendChild(document.createTextNode("http:www.flyapi.cn"));
		mask_div.style.position = "absolute";
		mask_div.style.right =  '20px';
		mask_div.style.bottom =  '10px';
		mask_div.style.overflow = "hidden";
		mask_div.style.zIndex = "9999";
		mask_div.style.opacity = 0.3;
		document.body.appendChild(mask_div);
	</script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/marked.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/prettify.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/raphael.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/underscore.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/sequence-diagram.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/flowchart.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editors/lib/jquery.flowchart.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/js/editormd.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/page/publish-resume.js"></script>
</body>
</html>