	logPage(1,5);
	function logPage(pageNumber,pageSize){
		$.ajax({
			type : 'POST',
			url : "../log/findAllLog.do",
			dataType : "json",
			data : {
				"userId":userId,
				"pageNumber":pageNumber,
				"pageSize":pageSize
			},
			success : function(data) {
				$(".pagination").empty();
				$(".pagination").append('<li class="disabled"><a href="#">&laquo;</a></li>');
				$.each(data.data.navigatepageNums,function(index,pn){
					if(data.data.pageNum==pn){
						$(".pagination").append('<li class="active"><a onclick="logPage('+pn+',5)">'+pn+'</a></li>');
					}else{
						$(".pagination").append('<li><a onclick="logPage('+pn+',5)">'+pn+'</a></li>');
					}
					
				});
				$(".pagination").append('<li class="disabled"><a href="disabled">&raquo;</a></li>');
				
				$(".msg_list").empty();
				$.each(data.data.list,function(index,log){
					$(".msg_list").append('<li>'
                            +'<div class="message_wrapper">'
                             +' <h4 class="heading">'+log.userName+'</h4>'
                             +' <p>&nbsp;&nbsp;&nbsp;&nbsp;'+log.remark+'</p>'
                              +'<p class="url">'
                              +'  <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>'
                              +'  <a><i class="fa fa-calendar"></i> '+getMyDate(log.createTime)+' </a>'
                              +'</p>'
                            +'</div>'
                         +' </li>');
				});
				
			}

		}); 
		
	}	
	/*获取版本日志*/
	$.ajax({
		type : 'POST',
		url : "../version/findVersionLog.do",
		dataType : "json",
		data:"",
		success : function(result) {
			$.each(result.data,function(index,version){
				$("#versionLog").append('<div class="panel panel-default">'		
										+'	<div class="panel-heading">'
										+'		<h4 class="panel-title">'
										+'			<span class="badge pull-right">'+formatDate(version.createTime)+'</span>'
										+'				 <a data-toggle="collapse" data-parent="#accordion"'
										+'				href="#collapse'+index+'"> '+version.versionNum+' </a>&nbsp;&nbsp;&nbsp;&nbsp;'+version.versionDes+''
										+'		</h4>'
										+'	</div>'
										+'	<div id="collapse'+index+'" class="panel-collapse collapse  in">'
										+'		<div class="panel-body">'
										+'			<ol id="list'+index+'">'
										+'			</ol>'
										+'		</div>'
										+'	</div>'
										+'</div>');
				$.each(version.versionLogList,function(logIndex,log){
					$("#list"+index).append('<li>'+log.versionLogContent+'</li>');
				});
			});
		}
	});