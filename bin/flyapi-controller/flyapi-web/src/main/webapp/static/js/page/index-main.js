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
	}	