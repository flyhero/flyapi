	
	var $table = $('#table'), $button = $('#button'), $button1 = $('#button1');
	
	var cont;
	
	var pro;
	var moduleId;
	var interName;
	var interDes;
	var status;
	var interUrl;
	var method;
	var param;
	var requestexam;
	var responseparam;
	var trueexam;
	var falseexam;
	
	function getValues(){
		pro=$("#pro-name").val();
		moduleId=$("#module-name").val();
		interName = $("#interName").val();
		interDes = $("#interDes").val();
		status = $("#status").val();
		interUrl = $("#interUrl").val();
		method = $("#method").val();
		param = JSON.stringify($table
				.bootstrapTable('getAllSelections'));
		requestexam = $("#requestexam").val();
		responseparam = $("#responseparam").val();
		trueexam = $("#trueexam").val();
		falseexam = $("#falseexam").val();
	}
	$(function() {
		$button.click(function() {
			$table.bootstrapTable('insertRow', {
				index : 1,
				row : {
					name : '描述',
					isTrue : 'true',
					interType : 'int',
					des : '描述'
				}
			});
		});
		$button1.click(function() {
			layer.alert('getSelections: '
					+ JSON.stringify($table
							.bootstrapTable('getAllSelections')));
		});

		$("#createInterface").click(function() {
							getValues();
							var st='#'+interName+'\n[TOCM]\n\n[TOC]\n'+'###功能说明\n'+'####**接口名称**\n'+interName+'\n####**接口描述**\n'+interDes+'\n####**接口状态**\n';
							if(status==0){
								st=st+'可用';
							}else{
								st=st+'不可用';
							}
							st=st+'\n###调用说明\n####**调用地址**\n'+interUrl+'\n####**请求方式 **\n'+method+'\n####**请求参数**\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n';
							var pa=$.parseJSON(param);
				            var tab='';
							 $.each(pa, function (n, p) {
								 	tab=tab+'  |'+p.name+'|'+p.isTrue+'|'+p.interType+'|'+p.des+'|\n';
					           });
							 st=st+tab;
							 st=st+'\n####**请求示例**\n```'+JSON.stringify(JSON.parse(requestexam), null, 4)+'```\n####**返回参数说明**\n'+responseparam+'\n####**成功示例**\n```'+JSON.stringify(JSON.parse(trueexam), null, 4)+'```\n####**失败示例**\n```'+JSON.stringify(JSON.parse(falseexam), null, 4)+'```';
							 cont=st;
							 
					           if (interName != '' && interUrl != ''
									&& param != '') {
									$.ajax({
											type : 'POST',
											url : "../interface/addInterface.do",
											dataType : "json",
											data : {
												"projectId" : pro,
												"moduleId":moduleId,
												"interName" : interName,
												"interDes" : interDes,
												"status" : status,
												"interUrl" : interUrl,
												"method" : method,
												"param" : param,
												"requestExam" : requestexam,
												"responseParam" : responseparam,
												"trueExam" : trueexam,
												"falseExam" : falseexam,
												"content" : cont
											},
											success : function(data) {
												if (data.msg == 'ok') {
													layer.alert("创建成功！");
												} else {
													layer.alert("创建失败！");
												}

											}

										});
							} else {
								layer.alert("信息不能为空！");
							} 
		});
		
		
		$.ajax({
			type : 'POST',
			url : "../project/findUserEdit.do",
			dataType : "json",
			data : {
				"userId":userId
			},
			success : function(data) {
				if (data.msg == 'ok') {
					$.each(data.data,function(index,pro){
						$("#pro-name").append('<option value="'+pro.project.projectId+'">'+pro.project.proName+'</option>');
					});
					
				} else {
					layer.alert("获取项目失败！");
				}

			}

		});
		$("#pro-name").change( function() {
			var proId=$("#pro-name").val();
			$
			.ajax({
				type : 'POST',
				url : "../module/findModule.do",
				dataType : "json",
				data : {
					"projectId":proId
				},
				success : function(data) {
					if (data.msg == 'ok') {
						$("#module-name").empty();
						$.each(data.data,function(index,mo){
							$("#module-name").append('<option value="'+mo.moduleId+'">'+mo.moduleName+'</option>');
						});
						
					} else {
						layer.alert("获取模块失败！");
					}

				}

			});
			});
		
	});