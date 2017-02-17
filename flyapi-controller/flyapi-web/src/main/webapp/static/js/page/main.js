	$('#tabs').addtabs({contextmenu:true});
	
	$.ajax({
		type : 'POST',
		url : "../webinfo/findWebInfo.do",
		dataType : "json",
		data : {
			"language":"zh"
		},
		success : function(data) {
			if(data.msg=='ok'){
				$.each(data.data,function(index,info){
					switch(info.partName){
						case '系统名称':
							$("#systemName").append(info.partContent);
							break;
						case '著作权':
							$("#copyRight").append(info.partContent);
							break;
						case '作者':
							$("#author").append(info.partContent);
							break;
						case '系统版本':
							$("#systemVersion").append(info.partContent);
							break;
					}
						
					
				});			
			}

			
		}

	}); 