/**
 * Created by flyhero on 2017/6/19 0019.
 */
/*function timeago(dateTimeStamp){
    var t=(new Date(dateTimeStamp)).getTime();
    var minute = 1000 * 60;
    var hour = minute * 60;
    var day = hour * 24;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();
    var diffValue = now - t;
    if(diffValue < 0){return;}

    var weekC =diffValue/(7*day);
    var dayC =diffValue/day;
    var hourC =diffValue/hour;
    var minC =diffValue/minute;

    if(weekC>=1){
        result="" + parseInt(weekC) + "周前";
    }
    else if(dayC>=1){
        result=""+ parseInt(dayC) +"天前";
    }
    else if(hourC>=1){
        result=""+ parseInt(hourC) +"小时前";
    }
    else if(minC>=1){
        result=""+ parseInt(minC) +"分钟前";
    }else {
        result=timeFormatter(t);
    }
    return result;
}*/


function timeAgo(dateTimeStamp) {
    var SECOND_AGO = "秒前";
    var MINUTE_AGO = "分钟前";
    var HOUR_AGO = "小时前";
    var DAY_AGO = "天前";
    var WEEK_AGO = "周前";

    var ONE_SECOND = 1000;
    var ONE_MINUTE = 60*ONE_SECOND;
    var ONE_HOUR = 60*ONE_MINUTE;
    var ONE_DAY = 24*ONE_HOUR;
    var ONE_WEEK = 7*ONE_DAY;
    var t=(new Date(dateTimeStamp)).getTime();
    var now = new Date().getTime();
    var diffValue = now - t;

    if (diffValue>ONE_WEEK && diffValue < 4*ONE_WEEK){
        return parseInt(diffValue/ONE_WEEK)+WEEK_AGO;
    }else if(diffValue >ONE_DAY && time < ONE_WEEK) {
        return parseInt(diffValue/ONE_DAY)+DAY_AGO;
    }else if(diffValue >ONE_HOUR && time <ONE_DAY){
        return parseInt(diffValue/ONE_HOUR)+HOUR_AGO;
    }else if(diffValue > ONE_MINUTE && time < ONE_HOUR){
        return parseInt(diffValue/ONE_MINUTE)+MINUTE_AGO;
    }else if(diffValue > ONE_SECOND && time < ONE_MINUTE){
        return parseInt(diffValue/ONE_SECOND)+SECOND_AGO;
    }else {
        result=dateTimeStamp;
    }
    return result;
}

function timeFormatter(value) {

    var da = new Date(parseInt(value.replace("/Date(", "").replace(")/" , "").split( "+")[0]));

    return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();

}
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
function formatDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间
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

