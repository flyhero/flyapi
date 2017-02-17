
var theme = {
          color: [
              '#26B99A', '#34495E', '#BDC3C7', '#3498DB',
              '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7'
          ],

          title: {
              itemGap: 8,
              textStyle: {
                  fontWeight: 'normal',
                  color: '#408829'
              }
          },

          dataRange: {
              color: ['#1f610a', '#97b58d']
          },

          toolbox: {
              color: ['#408829', '#408829', '#408829', '#408829']
          },

          tooltip: {
              backgroundColor: 'rgba(0,0,0,0.5)',
              axisPointer: {
                  type: 'line',
                  lineStyle: {
                      color: '#408829',
                      type: 'dashed'
                  },
                  crossStyle: {
                      color: '#408829'
                  },
                  shadowStyle: {
                      color: 'rgba(200,200,200,0.3)'
                  }
              }
          },

          dataZoom: {
              dataBackgroundColor: '#eee',
              fillerColor: 'rgba(64,136,41,0.2)',
              handleColor: '#408829'
          },
          grid: {
              borderWidth: 0
          },

          categoryAxis: {
              axisLine: {
                  lineStyle: {
                      color: '#408829'
                  }
              },
              splitLine: {
                  lineStyle: {
                      color: ['#eee']
                  }
              }
          },

          valueAxis: {
              axisLine: {
                  lineStyle: {
                      color: '#408829'
                  }
              },
              splitArea: {
                  show: true,
                  areaStyle: {
                      color: ['rgba(250,250,250,0.1)', 'rgba(200,200,200,0.1)']
                  }
              },
              splitLine: {
                  lineStyle: {
                      color: ['#eee']
                  }
              }
          },
          timeline: {
              lineStyle: {
                  color: '#408829'
              },
              controlStyle: {
                  normal: {color: '#408829'},
                  emphasis: {color: '#408829'}
              }
          },

          k: {
              itemStyle: {
                  normal: {
                      color: '#68a54a',
                      color0: '#a9cba2',
                      lineStyle: {
                          width: 1,
                          color: '#408829',
                          color0: '#86b379'
                      }
                  }
              }
          },
          map: {
              itemStyle: {
                  normal: {
                      areaStyle: {
                          color: '#ddd'
                      },
                      label: {
                          textStyle: {
                              color: '#c12e34'
                          }
                      }
                  },
                  emphasis: {
                      areaStyle: {
                          color: '#99d2dd'
                      },
                      label: {
                          textStyle: {
                              color: '#c12e34'
                          }
                      }
                  }
              }
          },
          force: {
              itemStyle: {
                  normal: {
                      linkStyle: {
                          strokeColor: '#408829'
                      }
                  }
              }
          },
          chord: {
              padding: 4,
              itemStyle: {
                  normal: {
                      lineStyle: {
                          width: 1,
                          color: 'rgba(128, 128, 128, 0.5)'
                      },
                      chordStyle: {
                          lineStyle: {
                              width: 1,
                              color: 'rgba(128, 128, 128, 0.5)'
                          }
                      }
                  },
                  emphasis: {
                      lineStyle: {
                          width: 1,
                          color: 'rgba(128, 128, 128, 0.5)'
                      },
                      chordStyle: {
                          lineStyle: {
                              width: 1,
                              color: 'rgba(128, 128, 128, 0.5)'
                          }
                      }
                  }
              }
          },
          gauge: {
              startAngle: 225,
              endAngle: -45,
              axisLine: {
                  show: true,
                  lineStyle: {
                      color: [[0.2, '#86b379'], [0.8, '#68a54a'], [1, '#408829']],
                      width: 8
                  }
              },
              axisTick: {
                  splitNumber: 10,
                  length: 12,
                  lineStyle: {
                      color: 'auto'
                  }
              },
              axisLabel: {
                  textStyle: {
                      color: 'auto'
                  }
              },
              splitLine: {
                  length: 18,
                  lineStyle: {
                      color: 'auto'
                  }
              },
              pointer: {
                  length: '90%',
                  color: 'auto'
              },
              title: {
                  textStyle: {
                      color: '#333'
                  }
              },
              detail: {
                  textStyle: {
                      color: 'auto'
                  }
              }
          },
          textStyle: {
              fontFamily: 'Arial, Verdana, sans-serif'
          }
      };
   


		var echartBarLine = echarts.init(document.getElementById('mainb'), theme);
		function edit(upId,isEdit,name,projectId) { 
			if(userEdit==1){
			    $("#userName").val(name);
			    $("#isEdit  option[value='"+isEdit+"'] ").attr("selected",true)
			    $("#upID").val(upId);
			    $("#projectID").val(projectId);
			    $('#editTeam').modal('show');  
			}
		}  
		function editModule(id,name,des) {  
			if(userEdit==1){
			    $("#editId").val(id);
			    $("#editName").val(name);
			    $("#editDes").val(des);
			    $('#editModule').modal('show');  
			}
		}  
      $(document).ready(function () {     

			$.ajax({
				type : 'POST',
				url : "../project/findProjectDetail.do",
				dataType : "json",
				data : {
					"upId":upId
				},
				success : function(data) {
					$("#target-inter").append(data.data.targetCount);
					$("#done-inter").append(data.data.doneCount);
					$("#created-day").append(getDayToNow(data.data.createTime));
					$("#creator").append(data.data.userName);
					$("#company").append(data.data.company);
					$(".green").append(data.data.proName);
					$("#prodes").append(data.data.proDes);
				}

			});
			$.ajax({
				type : 'POST',
				url : "../project/findTeamMembers.do",
				dataType : "json",
				data : {
					"projectId":projectId,
					"userId":userId
				},
				success : function(data) {
					$.each(data.data,function(index,user){
						var name="'"+user.userName+"'";
						if(user.userId==myId){
							$("#team-member").append('<li><a><i class="fa fa-user"></i>&nbsp;'+user.userName+'</a></li>');
						}else{
							$("#team-member").append('<li><a href="#" onclick="edit('+user.upId+','+user.isEdit+','+name+','+user.projectId+')"><i class="fa fa-user"></i>&nbsp;'+user.userName+'</a></li>');
						}
						
					});
					
				}

			});
			$.ajax({
				type : 'POST',
				url : "../module/findModule.do",
				dataType : "json",
				data : {
					"projectId":projectId
				},
				success : function(data) {
					$.each(data.data,function(index,module){
						var name="'"+module.moduleName+"'";
						var des="'"+module.moduleDes+"'";
						$("#project-module").append('<li><a href="#" onclick="editModule('+module.moduleId+','+name+','+des+')"><i class="fa fa-cube"></i>&nbsp;'+module.moduleName+'</a></li>');
					});
					
				}

			});
 			$.ajax({
				type : 'POST',
				url : "../log/findLogDetial.do",
				dataType : "json",
				data : {
					"projectId":projectId
				},
				success : function(data) {
					$.each(data.data,function(index,log){
						$(".messages").append('<li>'
	                            +'<div class="message_wrapper">'
	                             +' <h4 class="heading">'+log.userName+'</h4>'
	                             +' <blockquote class="message">'+log.remark+'</blockquote>'
	                             +' <br />'
	                              +'<p class="url">'
	                              +'  <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>'
	                              +'  <a><i class="fa fa-calendar"></i> '+getMyDate(log.createTime)+' </a>'
	                              +'</p>'
	                            +'</div>'
	                         +' </li>');
					});
					
				}

			}); 
			
 			
			$("#updatePermission").click(function() {
				var userName = $("#userName").val();
				var projectId = $("#projectID").val();
				var isEdit = $("#isEdit").val();
			    var upId=$("#upID").val();
				if (userName != '' && projectId != '' && upId != '') {
					$.ajax({
						type : 'POST',
						url : "../project/updateMemberPermission.do",
						dataType : "json",
						data : {
							"name" : userName,
							"projectId" : projectId,
							"isEdit" : isEdit,
							"upId" : upId
						},
						success : function(data) {
							if (data.msg == 'ok') {
								layer.alert("更新成功！^_^");
							} else {
								layer.alert("更新失败！-_-");
							}
						}

					});
				} else {
					layer.alert("信息不能为空！");
				}
			});
			$("#deleteTeam").click(function() {
				var userName = $("#userName").val();
				var projectId = $("#projectID").val();
			    var upId=$("#upID").val();
				if (userName != '' && projectId != '' && upId != '') {
					$.ajax({
						type : 'POST',
						url : "../project/deleteTeamMembers.do",
						dataType : "json",
						data : {
							"name" : userName,
							"projectId" : projectId,
							"upId" : upId
						},
						success : function(data) {
							if (data.msg == 'ok') {
								layer.alert("删除成功！^_^");
							} else {
								layer.alert("删除失败！-_-");
							}
						}

					});
				} else {
					layer.alert("信息不能为空！");
				}
			});
			$("#checkUserName").click(function() {
				var userName = $("#addName").val();
				if (userName != '') {
					$.ajax({
						type : 'POST',
						url : "../user/checkUserName.do",
						dataType : "json",
						data : {
							"userName" : userName
						},
						success : function(data) {
							if (data.valid == false) {
								layer.open({
									title:"提示",
									content:"用户存在！^_^",
									offset:"t"
								});
							} else {
								layer.open({
									title:"提示",
									content:"用户不存在！-_-",
									offset:"t"
								});
							}
						}

					});
				} else {
					layer.alert("用户名不能为空！");
				}

			});			
			$("#addTeamUser").click(function() {
				var addName = $("#addName").val();
				var addisEdit = $("#addisEdit").val();
				if (addName != '' && addisEdit != '') {
					$.ajax({
						type : 'POST',
						url : "../user/checkUserName.do",
						dataType : "json",
						data : {
							"userName" : addName
						},
						success : function(data) {
							if (data.valid == false) {
								$.ajax({
									type : 'POST',
									url : "../project/addMember.do",
									dataType : "json",
									data : {
										"userName" : addName,
										"projectId" : projectId,
										"isEdit" : addisEdit
									},
									success : function(data) {
										if (data.msg == 'ok') {
											layer.open({
												title:"提示",
												content:"添加成功！^_^",
												offset:"t"
											});
										} else {
											layer.open({
												title:"提示",
												content:"添加失败！^_^",
												offset:"t"
											});
										}
									}

								});
							} else {
								layer.open({
									title:"提示",
									content:"用户不存在！-_-",
									offset:"t"
								});
							}
						}

					});

				} else {
					layer.open({
						title:"提示",
						content:"信息不能为空",
						offset:"t"
					});
				}
			});
			$("#updateModule").click(function() {
				var editId = $("#editId").val();
				var editName = $("#editName").val();
				var editDes = $("#editDes").val();
				if (editId != '' && editName != '' && editDes != '') {
					$.ajax({
						type : 'POST',
						url : "../module/updateModule.do",
						dataType : "json",
						data : {
							"moduleId" : editId,
							"moduleName" : editName,
							"moduleDes" : editDes
						},
						success : function(data) {
							if (data.msg == 'ok') {
								layer.alert("更新成功！^_^");
							} else {
								layer.alert("更新失败！-_-");
							}
						}

					});
				} else {
					layer.alert("信息不能为空！");
				}
			});
			$("#deleteMod").click(function() {
				var id = $("#editId").val();
				if (id != '' ) {
					$.ajax({
						type : 'POST',
						url : "../module/deleteModule.do",
						dataType : "json",
						data : {
							"moduleId" : id
						},
						success : function(data) {
							if (data.msg == 'ok') {
								layer.alert("删除成功！^_^");
							} else {
								layer.alert("删除失败！-_-");
							}
						}

					});
				} else {
					layer.alert("信息不能为空！");
				}
			});			
			$("#domodule").click(function() {
				var moduleName = $("#moduleName").val();
				var moduleDes = $("#moduleDes").val();
				if (moduleName != '' && moduleDes != ''
					&& projectId != '') {
	                $.ajax({  
	                    type : "POST",  //提交方式  
	                    url : "../module/addModule.do",//路径  
	                    dataType:"json",
	                    data : {  
							moduleName : moduleName,
							moduleDes : moduleDes,
							projectId : projectId
	                    },//数据，这里使用的是Json格式进行传输  
	                    success : function(data) {//返回数据根据结果进行相应的处理  
							if (data.msg == 'ok') {
								layer.alert("添加成功^_^");
							} else {
								layer.alert("添加失败！-_-");
							}
	                    }  
	                }); 
				} else {
					layer.alert("信息不能为空");
				/* 	layer.alert('信息不能为空', {
						  icon: 0,
						  skin: 'layer-ext-moon' 
						}); */
				}
			});
			
			$.ajax({
				type : 'POST',
				url : "../log/findLog.do",
				dataType : "json",
				data : {
					"projectId" : projectId
				},
				success : function(data) {
					if (data.msg == 'ok') {
						
						 echartBarLine.setOption({
					          title: {
					            x: 'center',
					            y: 'top',
					            padding: [0, 0, 20, 0],
					            text: '项目接口完成情况',
					            textStyle: {
					              fontSize: 15,
					              fontWeight: 'normal'
					            }
					          },
					          tooltip: {
					            trigger: 'axis'
					          },
					          toolbox: {
					            show: true,
					            feature: {
					              dataView: {
					                show: true,
					                readOnly: false,
					                title: "Text View",
					                lang: [
					                  "Text View",
					                  "Close",
					                  "Refresh",
					                ],
					              },
					              restore: {
					                show: true,
					                title: '重加载'
					              },
					              saveAsImage: {
					                show: true,
					                title: '保存'
					              }
					            }
					          },
					          calculable: true,
					          legend: {
					            data: ['接口'],
					            y: 'bottom'
					          },
					          xAxis: [{
					            type: 'category',
					            data: data.data.xtime
					          }],
					          yAxis: [{
					            type: 'value',
					            name: '接口数',
					            axisLabel: {
					              formatter: '{value} 个'
					            },
					            splitNumber: 1
					          }],
					          series: [{
					            name: '接口',
					            type: 'bar',
					            data: data.data.count
					          }]
					        });
						
					}else{
						alert("创建失败！");
					}

				}

			});
    	  
      });  

