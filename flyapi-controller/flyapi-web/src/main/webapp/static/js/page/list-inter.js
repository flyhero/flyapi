	function addParentTabs(id,title,url) {  
		parent.Addtabs.add({
            id: id,
            title: title,
            content: '',
            url: url,
            ajax: false
        });
	} 
    	
    	var isEdit='';
		$.ajax({
			type : 'POST',
			url : "../project/findUserIsEdit.do",
			dataType : "json",
			data : {
				"projectId":projectId
			},
			success : function(data) {
				if(data.data>0){
					isEdit='&nbsp;&nbsp;<a href="#"><i class="fa fa-edit"></i>修改</a> &nbsp;';
				}
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
					$("#module-id").append('<option value="'+module.moduleId+'">'+module.moduleName+'</option>');
				});
				
			}

		});
    	
    	logPage(1,5);
    	function logPage(pageNumber,pageSize){
        	var interName=$("#interName").val();
        	var userName=$("#uName").val();
        	var moId=$("#module-id").val();
    		$.ajax({
    			type : 'POST',
    			url : "../interface/findInterface.do",
    			dataType : "json",
    			data : {
    				"projectId":projectId,
    				"interName":interName,
    				"userName":userName,
    				"moduleId":moId,
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
    				
    				$("#inter-list").empty();
    				$.each(data.data.list,function(index,inter){
    					var debugTitle="'"+inter.interName+"-debug'";
    					var debugId=parseInt(inter.interfaceId.toString()+'1');
    					var debugUrl="'../forward/debug_interface.html?interfaceId="+inter.interfaceId+"'";
    					var detailTitle="'"+inter.interName+"-详细'";
    					var detailId=parseInt(inter.interfaceId.toString()+'2');
    					var detailUrl="'../forward/detail_interface.html?interfaceId="+inter.interfaceId+"'";
    					$("#inter-list").append('<div class="list">'
								+'<p class="date">'
								+getMonth(inter.createTime)+'月<b>'+getDay(inter.createTime)+'</b>'
								+'</p>'
								+'<h2>'
								+'	<a href="../forward/detail_interface.html?interfaceId='+inter.interfaceId+'">'+inter.interName+'</a>'
								+'</h2>'
								+'<p>'+inter.interDes+'</p>'
								+'<p class="meta">时间：'+getMyDate(inter.createTime)
								+'&nbsp;	模块：<a href="/">'+inter.moduleName+'</a>&nbsp;创建者：<a href="/">'+inter.userName+'</a>&nbsp;&nbsp;'
								+'		<a href="#" onclick="addParentTabs('+detailId+','+detailTitle+','+detailUrl+');"><i class="fa fa-eye"></i> 详情</a> &nbsp;'
								+'		<a href="#" onclick="addParentTabs('+debugId+','+debugTitle+','+debugUrl+');"><i class="fa fa-wrench"></i> 调试</a>&nbsp;'
								+isEdit+'</p></div>');
    				});
    				
    			}

    		}); 
    	}