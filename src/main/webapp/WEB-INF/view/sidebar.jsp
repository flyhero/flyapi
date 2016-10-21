<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="main.do">
					首页
				</a>
			</h4>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="projectList.do">
					我的项目
				</a>
			</h4>
		</div>
	</div>

</div>
<script>
$(function(){
	var doc=$(document.body).height();
	var win=$(window).height();
	if(doc<win){
		$("#accordion").height(win-220);
	}else{
		$("#accordion").height(doc);
	}
});
</script>