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
	href="<%=request.getContextPath()%>/static/editor/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/editor/css/editormd.css" />
<jsp:include page="base/static.jsp"></jsp:include>
<title>简历编辑</title>
</head>
<body>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab">编辑简历</a></li>
		<li><a href="#ios" data-toggle="tab">已发布简历</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">

			<div id="layout">
				<header>
					<input type="text" class="form-control" id="resumeTitle"
						placeholder="请输入简历标题">
				</header>
				<div class="btns">
					<button id="watch-btn">显示预览</button>
					<button id="unwatch-btn">取消预览</button>
					<button id="preview-btn">预览HTML</button>
					<button id="fullscreen-btn">全屏 (ESC退出)</button>
					<button id="save-btn">保存简历</button>
					<button id="publish-btn">发布简历</button>
					<span id="updateTime" class="badge pull-right">2017.2.3</span>
				</div>
				<div id="editormd"></div>
			</div>
		</div>
		<div class="tab-pane fade" id="ios">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span id="publishTitle">详情</span> &nbsp;&nbsp; <span>
						<button id="goto-line-btn" onclick="window.print();">
							<i class="fa fa-download"></i>PDF
						</button>
					<span id="lastTime" class="badge pull-right"></span>
					</span> 

				</div>
				<div class="panel-body">
								<header>
					<input type="text" class="form-control" id="publishWebsite"
						placeholder="发布地址http:www.flyapi.cn">
				</header>
					<div id="resume-view">
						<textarea style="display: none;" name="test-editormd-markdown-doc"></textarea>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		function waterMark() {
			var mask_div = document.createElement('div');
			mask_div.id = 'mask_div1';
			mask_div.appendChild(document.createTextNode("http:www.flyapi.cn"));
			mask_div.style.position = "absolute";
			mask_div.style.right = '20px';
			mask_div.style.bottom = '10px';
			mask_div.style.overflow = "hidden";
			mask_div.style.zIndex = "9999";
			mask_div.style.opacity = 0.3;
			document.body.appendChild(mask_div);
		}
		window.onload = waterMark;
	</script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/marked.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/prettify.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/raphael.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/underscore.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/sequence-diagram.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editor/lib/flowchart.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/editors/lib/jquery.flowchart.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/editor/editormd.js"></script>
	<script type="text/javascript">
		var userId = ${sessionScope.user.userId};
		var resumeWebsite;
		$(function() {
			var editorMd;
			$.getJSON('../resume/findResumeByUserId/' + userId,
					function(result) {
						var md = '';
						if (result.data != null) {
							$("#resumeTitle").val(result.data.resumeTitle);
							md = result.data.mdContent;
							if (result.data.updateTime != null) {
								$("#updateTime").text(getMyDate(result.data.updateTime));
								$("#lastTime").text(getMyDate(result.data.updateTime));
							} else {
								var date = new Date();
								$("#updateTime").text(getMyDate(date));
							}

						}
						editorMd = editormd("editormd", {
							width : "90%",
							height : 1500,
							path : '<%=request.getContextPath()%>/static/editor/lib/',
							markdown : md,
							codeFold : true,
							//syncScrolling : false,
							saveHTMLToTextarea : true, // 保存 HTML 到 Textarea
							searchReplace : true,
							htmlDecode : "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启    
							emoji : true,
							taskList : true,
							// tocm            : true,         // Using [TOCM]
							tex : true, // 开启科学公式TeX语言支持，默认关闭
							flowChart : true, // 开启流程图支持，默认关闭
							sequenceDiagram : true, // 开启时序/序列图支持，默认关闭,
							imageUpload : true,
							imageFormats : [ "jpg", "jpeg", "gif", "png",
									"bmp", "webp" ],
							imageUploadURL : "./php/upload.php",
							onload : function() {
							}
						});
						
						
						$("#publishTitle").text(result.data.resumeTitle);
						$("#publishWebsite").val("发布地址： http://"+window.location.host+"/resume/publish/"+result.data.resumeId);
						var publishMd = editormd.markdownToHTML("resume-view",
								{
									markdown : md,
									htmlDecode : "style,script,iframe", // you can filter tags
									// decode
									tocm : true, // Using [TOCM]
									emoji : true,
									taskList : true,
									tex : true, // 默认不解析
									flowChart : true, // 默认不解析
									sequenceDiagram : true, // 默认不解析
								});

					});

			$("#save-btn").bind('click', function() {
				var resumeTitle = $("#resumeTitle").val();
				if (resumeTitle != null && resumeTitle != '') {
					$.ajax({
						type : 'POST',
						url : "../resume/saveUserResume.do",
						dataType : "json",
						data : {
							"userId" : userId,
							"resumeTitle" : $("#resumeTitle").val(),
							"mdContent" : editorMd.getMarkdown(),
							"htmlContent" : editorMd.getHTML()
						},
						success : function(data) {
							if (data.data.msg = "ok") {
								layer.alert("保存成功！", {
									offset : 't'
								});
							} else {
								layer.alert("保存失败！", {
									offset : 't'
								});
							}
						}

					});
				} else {
					layer.alert("信息不能为空！", {
						offset : 't'
					});
				}

			});

			$("#watch-btn").bind('click', function() {
				editorMd.watch();
			});

			$("#unwatch-btn").bind('click', function() {
				editorMd.unwatch();
			});

			$("#preview-btn").bind('click', function() {
				editorMd.previewing();
			});

			$("#fullscreen-btn").bind('click', function() {
				editorMd.fullscreen();
			});

		});
	</script>

</body>
</html>