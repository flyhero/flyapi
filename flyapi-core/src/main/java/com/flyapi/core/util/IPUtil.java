package com.flyapi.core.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: qfwang
 * Date: 2017-11-24 下午6:10
 */
public class IPUtil {
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
            ip = request.getHeader("PRoxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDEC_FOR");
        }
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }
}
