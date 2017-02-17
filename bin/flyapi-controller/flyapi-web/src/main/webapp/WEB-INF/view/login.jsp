<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>flyapi登录</title>
<meta name="description"
	content="" />
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<link rel="shortcut icon" href="img/favicon.ico">
    <!-- Loading Flat UI -->
    <link href="<%=request.getContextPath()%>/static/flatui/css/flat-ui.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/flatui/css/demo.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/static/flatui/js/flat-ui.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/table/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrapvalidator/js/bootstrapValidator.js"></script>
    <link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/table/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrapvalidator/css/bootstrapValidator.css"/>
	<script
	src="<%=request.getContextPath()%>/static/table/bootstrap/js/bootstrap.min.js"></script>
	<script language="JavaScript"> 
             if (window != top) 
                       top.location.href = location.href; 
</script>
</head>
<body>
	<div class="container">
		<div>
			<h5 class="demo-logo">&nbsp;FlyApi&nbsp;接口管理系统</h5>
		</div>
		<!-- /demo-headline -->


		<div class="login">
			<div class="login-screen">
				<div class="login-icon">
					<img
						src="<%=request.getContextPath()%>/static/flatui/img/login/icon.png"
						alt="Welcome to Mail App" />
					<h4>
						Welcome to <small>FlyApi</small>
					</h4>
				</div>
				
					<div class="login-form">
					 <form id="defaultForm" method="post"  action="<%=request.getContextPath()%>/user/login.do">
						<div class="form-group">
<!-- 						<div class="input-group">
						  <span class="input-group-addon">@</span>
						  <input type="text" class="form-control" placeholder="Prepend" />
						</div> --> 
						 
							<input type="text" class="form-control login-field" 
								placeholder="Enter your name" name="userName" /> 
								<label class="login-field-icon fui-user " for="userName"></label>
						</div>
						<div class="form-group">
							<input type="password" class="form-control login-field"
								placeholder="Password" name="password" /> <label
								class="login-field-icon fui-lock" for="password"></label>
						</div>
						
						<button class="btn btn-primary btn-lg btn-block" type="submit">登&nbsp;&nbsp;录</button>
						<a class="login-link" href="../forward/register.html">还没注册？前去注册</a>
						</form>
					</div>
					
			</div>
		</div>

	</div>
	<!-- /container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-2">
				</div>
				<!-- /col-xs-7 -->
				<div class="col-xs-8"></br>
					<ul class="list-inline text-center">
		                <li>flyapi接口管理系统 &nbsp; 作者：王清飞 博客：<a target="_blank" href="http://flyhero.top">flyhero.top</a></li>
		            </ul>
				</div>
				<div class="col-xs-2"></div>
			</div>
		</div>
	</footer>

<script type="text/javascript">
$(document).ready(function() {
    var user='${sessionScope.user.userName}';
	if(user != null && user != ''){
		location.href="forward/main.html";
	}
    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));

    $('#defaultForm').bootstrapValidator({
//        live: 'disabled',
        message: '这个值是无效的',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: '用户名是无效的',
                validators: {
                    notEmpty: {
                        message: '用户名是必须的，不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 30,
                        message: '用户名必须大于5位小于30位'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能由字母、数字、点和下划线'
                    }
                }
            },
            userPw: {
                validators: {
                    notEmpty: {
                        message: '密码是必须的，不能为空'
                    }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: 'Wrong answer',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#defaultForm').bootstrapValidator('validate');
    });

});
</script>

</body>
</html>