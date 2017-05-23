package com.flyapi.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author: flyhero
 * Date: 2017/5/23 0023 上午 9:57
 */
public class CookieUtil {

    /**
     * 设置Cookie
     * Title: setCookie
     * params: [response, name, value, path, maxAge]
     * return: void
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/23 0023 上午 11:50
     */
    public static void setCookie(HttpServletResponse response,String name,String value,String path,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath(path);
        if(maxAge>0){
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static void setCookie(HttpServletResponse response,String name,String value,int maxAge){
        setCookie(response,name,value,"/",maxAge);
    }
    public static void setCookie(HttpServletResponse response,String name,String value){
        setCookie(response,name,value,"/",3600);
    }
    public static void setCookie(HttpServletResponse response, String name) {
        setCookie(response, name, "", "/", 3600);
    }
    /**
     * 获取cookie
     * Title: getCookie
     * params: [request, name]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/23 0023 上午 11:55
     */
    public static String getCookie(HttpServletRequest request,String name){
        String value = null;
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(name)){
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    /**
     * 删除Cookie
     * Title: delCookie
     * params: [response, name]
     * return: void
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/23 0023 下午 12:01
     */
    public static void delCookie(HttpServletResponse response,String name){
        setCookie(response,name,"","/",3600);
    }

}
