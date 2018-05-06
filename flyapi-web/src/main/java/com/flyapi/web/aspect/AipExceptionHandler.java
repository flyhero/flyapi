package com.flyapi.web.aspect;

import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.exception.UploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Author: qfwang
 * Date: 2018-03-06 下午11:45
 */
//@ControllerAdvice(annotations = Controller.class)
public class AipExceptionHandler {


//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
    public ResponseEntity exception(Exception e, HttpServletResponse response){
        JSONResult jsonResult = new JSONResult();
        if(e instanceof UploadException){
            UploadException uploadException = (UploadException) e;
//            jsonResult.setCode(uploadException.get);
        }
        jsonResult.setMsg(e.getMessage());
        return new ResponseEntity(jsonResult, HttpStatus.OK);
    }

}
