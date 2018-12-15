package cn.iflyapi.blog.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 防御CSRF,XSS,SQL
 * Author: qfwang
 * Date: 2018-03-21 上午11:45
 */
public class SQLInjectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Enumeration<String> names = httpServletRequest.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String[] values = httpServletRequest.getParameterValues(name);
            for(String value: values){
                //sql注入直接拦截
                if(judgeSQLInject(value.toLowerCase())){
                    httpServletResponse.setContentType("text/html;charset=UTF-8");
                    httpServletResponse.getWriter().print("参数含有非法攻击字符,已禁止继续访问！");
                    return false;
                }
                //跨站xss清理
                clearXss(value);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }

    /** * 判断参数是否含有攻击串 * @param value * @return */
    public boolean judgeSQLInject(String value) {
        return false;
//        if(value == null || "".equals(value)){
//            return false;
//        }
////        String xssStr = "and|or|select|update|delete|drop|truncate|%20|=|-|--|;|'|%|#|+|,|//|/| |\\|!=|(|)";
//        String xssStr = "and|or|select|update|delete|drop|truncate|=|;|'|#|,|//|/|\\|!=|(|)";
//        String[] xssArr = xssStr.split("\\|");
//        for(int i=0;i<xssArr.length;i++){
//            if(value.indexOf(xssArr[i])>-1){
//                return true;
//            }
//        }
//        return false;
    }

    /** * 处理跨站xss字符转义 * * @param value * @return */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
                "\"\"");
        value = value.replace("script", "");
        return value;
    }

}
