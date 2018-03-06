package com.flyapi.core.exception;

/**
 * Author: qfwang
 * Date: 2018-03-07 上午12:25
 */
public class DenyOperationException extends RuntimeException{
    public DenyOperationException(String message) {
        super(message);
    }

    public DenyOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
