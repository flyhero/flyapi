package cn.iflyapi.blog.exception;

import cn.iflyapi.blog.enums.CodeMsgEnum;

/**
 * author: flyhero
 * date: 2018-12-13 11:08 AM
 */
public class FlyapiException extends RuntimeException {

    private int code = -1;
    private String msg;

    public FlyapiException(CodeMsgEnum codeMsgEnum) {
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMsg();
    }

    public FlyapiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public FlyapiException(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
