package cn.iflyapi.blog.enums;

/**
 * @author: qfwang
 * @date: 2018-12-13 10:02 AM
 */
public enum CodeMsgEnum {
    OK(200, "Success"),
    FAIL(-1, "Fail");


    private Integer code;
    private String msg;

    CodeMsgEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
