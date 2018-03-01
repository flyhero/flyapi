package com.flyapi.core.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * Author: qfwang
 * Date: 2018-03-01 下午11:21
 */
@Component
public class FlyapiExceptionHandler implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", e);

        // 根据不同错误转向不同页面
        if(e instanceof UploadException) {
            return new ModelAndView("error-business", model);
        } else {
            return new ModelAndView("error", model);
        }
    }
}
