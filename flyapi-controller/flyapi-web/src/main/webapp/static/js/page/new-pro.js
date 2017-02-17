function add(){
    var proVersion= $("#proVersion").val();
    var proName=$("#proName").val();
    var proDes=$("#proDes").val();
    var targetCount=$("#targetCount").val();
    if(proVersion!=''&&proName!=''&&proDes!=''&&targetCount!=''){
    	$.ajax({
    		type : 'POST',
    		url : "../project/addProject.do",
    		dataType : "json",
    		data : {
    			"proVersion" : proVersion,
    			"proName" : proName,
    			"proDes" : proDes,
    			"targetCount" : targetCount
    		},
    		success : function(data) {
    			if (data.msg == 'ok') {
    				alert("创建成功！");
    			/* 	window.location.href='main.html'; */
    			}else{
    				alert("创建失败！");
    			}

    		}

    	});
    }

}
$(document).ready(function() {

    $('#resetBtn').click(function() {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	proName: {
                message: 'The proName is not valid',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 30,
                        message: '项目名必须大于2个字符并且小于30个字符'
                    }
                }
            },
            proDes: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            },
            proVersion: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            },
            targetCount: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    lessThan: {
                        value: 10000,
                        inclusive: true,
                        message: '接口数必须小于10000'
                    },
                    greaterThan: {
                        value: 0,
                        inclusive: false,
                        message: '接口数必须大于0'
                    }
                }
            }
        }
    });
});