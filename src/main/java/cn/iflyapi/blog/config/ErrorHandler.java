package cn.iflyapi.blog.config;

import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.model.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * author: flyhero
 * date: 2018-12-13 11:09 AM
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(FlyapiException.class)
    public JSONResult handlerFlyapiException(FlyapiException ex) {

        log.error(ex.getMsg(), ex.getCause());

        return JSONResult.fail(ex.getCode(), ex.getMsg());
    }
}
