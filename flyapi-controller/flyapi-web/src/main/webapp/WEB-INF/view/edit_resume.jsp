<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/editor/css/style.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/editor/css/editormd.css" />
<jsp:include page="base/static.jsp"></jsp:include>
<title>简历编辑</title>
</head>
<body>

<!-- 	<div class="panel panel-default">
		<div class="panel-heading">
			<span>简历编辑</span>
		</div>
		<div class="panel-body">
			<div class="row"> -->
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">编辑简历</a></li>
				<li><a href="#ios" data-toggle="tab">已发布简历</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					
					        <div id="layout">
            <header>
            <!--    <h5>完整示例</h5>
                 <p>Full example</p>
                <ul style="margin: 10px 0 0 18px;">
                    <li>Enable HTML tags decode</li>
                    <li>Enable TeX, Flowchart, Sequence Diagram, Emoji, FontAwesome, Task lists</li>
                    <li>Enable Image upload</li>
                    <li>Enable [TOCM], Search Replace, Code fold</li>
                </ul>    -->        
            </header> 
            <div class="btns">
<!--                 <button id="get-md-btn">Get Markdown</button>
                <button id="get-html-btn">Get HTML</button> -->
                <button id="watch-btn">显示预览</button>
                <button id="unwatch-btn">取消预览</button>
                <button id="preview-btn">预览HTML</button>
                <button id="fullscreen-btn">全屏 (ESC退出)</button>
                <button id="save-btn">保存简历</button>
                <button id="publish-btn">发布简历</button>
            </div>
            <div id="test-editormd"></div>
        </div>
        <script src="<%=request.getContextPath()%>/static/editor/editormd.js"></script>   
        <script type="text/javascript">
            var testEditor;
            
            $(function() {
                
                $.get('<%=request.getContextPath()%>/static/editor/test.md', function(md){
                    testEditor = editormd("test-editormd", {
                        width: "90%",
                        height: 1000,
                        path : '<%=request.getContextPath()%>/static/editor/lib/',
                      //  theme : "dark",
                      //  previewTheme : "dark",
                      //  editorTheme : "pastel-on-dark",
                        markdown : md,
                        codeFold : true,
                        //syncScrolling : false,
                        saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
                        searchReplace : true,
                        //watch : false,                // 关闭实时预览
                        htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启    
                        //toolbar  : false,             //关闭工具栏
                        //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                        emoji : true,
                        taskList : true,
                       // tocm            : true,         // Using [TOCM]
                        tex : true,                   // 开启科学公式TeX语言支持，默认关闭
                        flowChart : true,             // 开启流程图支持，默认关闭
                        sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
                        //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                        //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                        //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                        //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                        //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
                        imageUpload : true,
                        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                        imageUploadURL : "./php/upload.php",
                        onload : function() {
                            console.log('onload', this);
                            //this.fullscreen();
                            //this.unwatch();
                            //this.watch().fullscreen();

                            //this.setMarkdown("#PHP");
                            //this.width("100%");
                            //this.height(480);
                            //this.resize("100%", 640);
                        }
                    });
                });
                
                
                $("#get-md-btn").bind('click', function(){
                    alert(testEditor.getMarkdown());
                });
                $("#save-btn").bind('click', function(){
                    alert(window.location.href);
                });
                
                $("#get-html-btn").bind('click', function() {
                    alert(testEditor.getHTML());
                });                
                
                $("#watch-btn").bind('click', function() {
                    testEditor.watch();
                });                 
                
                $("#unwatch-btn").bind('click', function() {
                    testEditor.unwatch();
                });              
                
                $("#preview-btn").bind('click', function() {
                    testEditor.previewing();
                });
                
                $("#fullscreen-btn").bind('click', function() {
                    testEditor.fullscreen();
                });
                
            });
        </script>
					
				</div>
				<div class="tab-pane fade" id="ios">
					<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
						TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
				</div>
			</div>									

				
<!-- 			</div>
			
		</div>
	</div> -->


</body>
</html>