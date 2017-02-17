<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<jsp:include page="base/static.jsp"></jsp:include>
<title>注册</title>
</head>
<body style="background-color:#FFFFFF;"><!-- #F7F6F2 -->
		<div class="navbar navbar-default" id="navbar">

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							flyapi接口管理系统 V2.2
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->


				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav navbar-nav navbar-right"> 
			            <li><a href="<%=request.getContextPath()%>/forward/login.html"><span class="glyphicon glyphicon-log-in"></span> 有账号？去登录 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li> 
			        </ul> 
				</div>
			</div>
		</div>
    <div class="container">
        <div class="row">
            <!-- form: -->
            <br><br>  <br><br>
                <div class="col-lg-8 col-lg-offset-2" style="border:1px solid #1abc9c;border-radius:5px;background-color:#1abc9c;">
                    <div class="page-header">
                        <h2>注册</h2>
                    </div>

                    <form id="defaultForm" method="post" class="form-horizontal" action="../user/register.do">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">用户名</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" name="userName" id="userName" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Email</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" name="email" id="email" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-5">
                                <input type="password" class="form-control" name="password" id="password"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">再一次密码</label>
                            <div class="col-lg-5">
                                <input type="password" class="form-control" name="confirmPassword" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">性别</label>
                            <div class="col-lg-5">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="sex" value="1" /> Male
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="sex" value="0" /> Female
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="sex" value="2" /> Other
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary">注册</button>
                                <button type="button" class="btn btn-info" id="resetBtn">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            <!-- :form -->
        </div>
    </div>

<script type="text/javascript">

$(document).ready(function() {
    $('#defaultForm')
        .bootstrapValidator({
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
                        },
                        remote: {
                            type: 'POST',
                            url: '../user/checkUserName.do',
                            message: '用户名已存在！'
                        },
                        different: {
                            field: 'password,confirmPassword',
                            message: '两次输入的密码不相同'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Email 是必须的，不能为空'
                        },
                        emailAddress: {
                            message: '输入的Email是无效的'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码是必须的，不能为空'
                        },
                        different: {
                            field: 'username',
                            message: '密码不能和用户名相同'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: '再次输入密码是必须的，不能为空'
                        },
                        identical: {
                            field: 'password',
                            message: '两次输入的密码不相同'
                        },
                        different: {
                            field: 'username',
                            message: '密码不能和用户名相同'
                        }
                    }
                },
                sex: {
                    validators: {
                        notEmpty: {
                            message: '性别是必须的'
                        }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                if(result.msg=='ok'){
                 	window.location.href='login.html'; 
                }
            }, 'json');
        });

    $('#resetBtn').click(function() {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });
});
</script>
</body>
</html>