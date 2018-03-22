package cn.flyapi.admin.inerceptor;

import com.flyapi.model.UcenterUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private List<String> excludedUrls;

    private Logger logger = LogManager.getLogger(LoginInterceptor.class);

    private static final String url = "http://www.iflyapi.cn:8090/admin/";

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当拦截器抛出异常时,依然会从当前拦截器往回执行所的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false 则退出本拦截器，本拦截器后面的postHandle与afterCompletion不再执行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        }
        String requestUri = request.getRequestURI();
        logger.info("请求URI"+requestUri);
        request.setAttribute("rootPath", url);
        for (String url : excludedUrls) {
            if (requestUri.contains(url)) {
                return true;
            }
        }
        logger.info(request.getSession().getId());
        HttpSession session = request.getSession();
        UcenterUser login = (UcenterUser) session.getAttribute("user");
        if (login == null) {
            logger.info("request.getContextPath():"+request.getContextPath());
            response.sendRedirect(url+"index.html");
        }
        return true;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
}