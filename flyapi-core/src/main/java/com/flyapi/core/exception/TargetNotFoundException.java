package com.flyapi.core.exception;

/**
 * Author: qfwang
 * Date: 2018-03-07 上午12:20
 */
public class TargetNotFoundException extends RuntimeException{
    public TargetNotFoundException(String message) {
        super(message);
    }

    public TargetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
