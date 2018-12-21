package cn.iflyapi.blog.config;

import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.util.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.auth0.jwt.interfaces.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JwtInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    private List<String> excludedUrl = new ArrayList<>();

    public void register(String url) {
        excludedUrl.add(url);
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        try {
            //过滤 OPTIONS 请求
            if (HttpMethod.OPTIONS.name().equals(httpServletRequest.getMethod())) {
                return true;
            }
            System.out.println(excludedUrl.toString());
            String currentPath = httpServletRequest.getMethod() + httpServletRequest.getRequestURI();
            for (String target : excludedUrl) {
                if (pathMatch(currentPath, target)) {
                    return true;
                }
            }

            String token = httpServletRequest.getHeader("Authorization");

            if (StringUtils.isEmpty(token)) {
                logger.error("token validate failed, no auth info in http header");
                return setNoAuth(httpServletResponse);
            }

            Map<String, Claim> map = JwtUtils.verify(token);
            if (map != null) {
                return true;
            }
        } catch (Exception e) {
            logger.error("JWT验证失败 {}", e.getMessage());
            return setNoAuth(httpServletResponse);
        }

        return setNoAuth(httpServletResponse);
    }

    /**
     * 设置response 返回需要登录的标识
     *
     * @param response
     */
    private boolean setNoAuth(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(JSONObject.toJSONString(JSONResult.fail(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase()), SerializerFeature.WriteMapNullValue));
        return false;
    }

    /**
     * 匹配路径
     *
     * @param current 当前请求路径
     * @param target  目标开放路径
     * @return boolean
     */
    private boolean pathMatch(String current, String target) {
        if (current.equals(target)) {
            return true;
        }
        if (!target.contains("*")) {
            return false;
        }

        int index = target.indexOf("*");
        if (target.contains("**")) {
            String prefixPath = target.substring(0, index);
            if (current.startsWith(prefixPath)) {
                return true;
            }
        } else {
            String suffixPath = current.substring(index);
            if (suffixPath.split("/").length == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "/users/*";
        System.out.println(s.indexOf("*"));
        System.out.println(s.substring(0, s.indexOf("*")));
        System.out.println(s.substring(s.indexOf("*")));
        System.out.println(s.contains("**"));

        String p = "users";
        System.out.println(p.split("/").length);
        System.out.println(p.split("/")[0]);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
