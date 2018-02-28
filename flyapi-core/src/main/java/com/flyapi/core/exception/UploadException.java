package com.flyapi.core.exception;

/**
 * 上传文件异常
 * Author: qfwang
 * Date: 2018-02-28 下午11:38
 */
public class UploadException extends RuntimeException{
    public UploadException() {
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
