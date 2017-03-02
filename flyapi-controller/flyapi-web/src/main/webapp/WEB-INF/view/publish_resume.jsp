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
			<span id="resumeTitle">详情</span> &nbsp;&nbsp;
			<span>
				<button id="goto-line-btn" onclick="window.print();">
						<i class="fa fa-download"></i>下载PDF
				</button>
			</span>
			<span id="lastTime" class="badge pull-right"></span>
			
		</div>
		<div class="panel-body">
				<div id="resume-view">
					<textarea style="display: none;" name="test-editormd-markdown-doc"></textarea>
				</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/static/editor/js/editormd.min.js"></script>
	<script type="text/javascript">
		var resumeId=${resumeId};
		var testEditor;
		$.ajax({
			type : 'POST',
			url : "../publish/info",
			dataType : "json",
			data : {
				"resumeId" : resumeId
			},
			success : function(data) {
				if (data.msg == 'ok') {
					$("#resumeTitle").text(data.data.resumeTitle);
					if(data.data.updateTime != null){
						$("#lastTime").text(getMyDate(data.data.updateTime));
					}else{
						$("#lastTime").text(getMyDate(data.data.createTime));
					}
					testEditor = editormd.markdownToHTML("resume-view", {
						markdown : data.data.mdContent,
						// htmlDecode : true, // 开启 HTML 标签解析，为了安全性，默认不开启
						htmlDecode : "style,script,iframe", // you can filter tags
															// decode
						// toc : true,
						tocm : true, // Using [TOCM]
						// tocContainer : "#custom-toc-container", // 自定义 ToC 容器层
						// gfm : false,
						// tocDropdown : true,
						// markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的Textarea
						emoji : true,
						taskList : true,
						tex : true, // 默认不解析
						flowChart : true, // 默认不解析
						sequenceDiagram : true, // 默认不解析
					});
					
					
				} else {
					alert("查询失败！");
				}

			}

		});

		function waterMark(){ 
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
		}
		window.onload = waterMark;  
	</script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/marked.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/prettify.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/raphael.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/underscore.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/sequence-diagram.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/lib/flowchart.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editors/lib/jquery.flowchart.min.js"></script>
</body>
</html>