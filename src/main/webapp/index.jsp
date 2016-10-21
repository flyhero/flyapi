<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="WEB-INF/view/static.jsp"></jsp:include>
<title>登录</title>
</head>
<body style="background-image: url(<%=request.getContextPath()%>/static/images/admin-login-bg.jpg)">

		<div class="navbar navbar-default" id="navbar">

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							flyapi接口管理系统 V1.0
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->


				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav navbar-nav navbar-right"> 
			            <li><a href="<%=request.getContextPath()%>/user/gotoRegister.do"><span class="glyphicon glyphicon-log-in"></span> 还没注册？来注册 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li> 
			        </ul> 
				</div>
			</div>
		</div>
  <div class="container">
        <div class="row">
            <!-- form: -->
            <section>
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="page-header">
                        <h2>登录</h2>
                    </div>

                    <form id="defaultForm" method="get" class="form-horizontal" action="user/login.do">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">用户名</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" name="userName" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-5">
                                <input type="password" class="form-control" name="userPw" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary">登录</button>
                                <button type="button" class="btn btn-info" id="resetBtn">重置</button>
                            </div>
                        </div>
                    </form>
                                </br><hr>
            <p>You never konw what you can do till you try.</p>
            <p>除非你亲自尝试一下，否则你永远不知道你能做什么。</p>
                </div>
            </section>
            <!-- :form -->

        </div>
    </div>
    
    
<script type="text/javascript">
$(document).ready(function() {
    // Generate a simple captcha
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
                        min: 6,
                        max: 30,
                        message: '用户名必须大于6位小于30位'
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

    $('#resetBtn').click(function() {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });
});
</script>
    
</body>
</html>