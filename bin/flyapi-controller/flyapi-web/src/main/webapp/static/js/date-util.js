    function getMyDate(str){  
        var oDate = new Date(str),  
        oYear = oDate.getFullYear(),  
        oMonth = oDate.getMonth()+1,  
        oDay = oDate.getDate(),  
        oHour = oDate.getHours(),  
        oMin = oDate.getMinutes(),  
        oSen = oDate.getSeconds(),  
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
        return oTime;  
    };  
    function getMonth(str){
        var oDate = new Date(str);
        var oMonth = oDate.getMonth()+1;
        return getzf(oMonth);
    }
    function getDay(str){
        var oDate = new Date(str);
        var oDay = oDate.getDate();
        return getzf(oDay);
    }
    //补0操作  
    function getzf(num){  
        if(parseInt(num) < 10){  
            num = '0'+num;  
        }  
        return num;  
    }  
    
    function getDaydiff(start,end){
		var total = (start-end)/1000;
		var day = parseInt(total / (24*60*60));//计算整数天数
		var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
		var hour = parseInt(afterDay/(60*60));//计算整数小时数
		var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
		var min = parseInt(afterHour/60);//计算整数分
		var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
		return day;
    }
    
    function getDayToNow(start){
    	var total = (Math.round(new Date())-start)/1000;
    	var day = parseInt(total / (24*60*60));//计算整数天数
		return day;
    }