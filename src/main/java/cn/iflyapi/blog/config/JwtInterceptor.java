package cn.iflyapi.blog.config;

import cn.iflyapi.blog.entity.User;
import cn.iflyapi.blog.util.JwtUtils;
import com.auth0.jwt.interfaces.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class JwtInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        User userInfo = null;

        try {
            //过滤 OPTIONS 请求
            if ("OPTIONS".equals(httpServletRequest.getMethod())) {
                return true;
            }

            String token = httpServletRequest.getHeader("Authorization");

            if (StringUtils.isEmpty(token)) {
                logger.error("token validate failed, no auth info in http header");
                return setNoAuth(httpServletResponse);
            }

            String[] codes = token.split("\\.");

            if (null == codes || codes.length < 2) {
                logger.error("token validate failed, format error");
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
/*        JSONResult result = new JSONResult(ErrorTypes.NEED_LOGIN.name(), HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));*/
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
