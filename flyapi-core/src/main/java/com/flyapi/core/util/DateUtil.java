package com.flyapi.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * author: flyhero
 * Date: 2017/5/15 0015 上午 10:50
 */
public class DateUtil {
    public static final String SECOND_AGO = "秒前";
    public static final String MINUTE_AGO = "分钟前";
    public static final String HOUR_AGO = "小时前";
    public static final String DAY_AGO = "天前";
    public static final String WEEK_AGO = "周前";

    public static final long ONE_SECOND = 1000L;
    public static final long ONE_MINUTE = 60*ONE_SECOND;
    public static final long ONE_HOUR = 60*ONE_MINUTE;
    public static final long ONE_DAY = 24*ONE_HOUR;
    public static final long ONE_WEEK = 7*ONE_DAY;


    /**
     * Title: formatDate
     * params: [date]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/26 0026 下午 1:31
     */
    public static String formatDate(Date date){

        long time= System.currentTimeMillis()-date.getTime();
        if (time>ONE_WEEK && time < 4*ONE_WEEK){
            return toWeeks(time)+WEEK_AGO;
        }else if(time >ONE_DAY && time < ONE_WEEK) {
            return toDays(time)+DAY_AGO;
        }else if(time >ONE_HOUR && time <ONE_DAY){
            return toHours(time)+HOUR_AGO;
        }else if(time > ONE_MINUTE && time < ONE_HOUR){
            return toMinutes(time)+MINUTE_AGO;
        }else if(time > ONE_SECOND && time < ONE_MINUTE){
            return toSeconds(time)+SECOND_AGO;
        }else {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }

    }

    public static long toSeconds(long time){
        return time/ONE_SECOND;
    }
    public static long toMinutes(long time){
        return time/ONE_MINUTE;
    }
    public static long toHours(long time){
        return time/ONE_HOUR;
    }
    public static long toDays(long time){
        return time/ONE_DAY;
    }
    public static long toWeeks(long time){
        return time/ONE_WEEK;
    }
    public static void main(String[] args) {
        try {
            Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-05-29 14:26:47");
            System.out.println(formatDate(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
