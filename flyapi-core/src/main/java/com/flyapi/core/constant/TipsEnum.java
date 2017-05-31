package com.flyapi.core.constant;

/**
 * author: flyhero
 * Date: 2017/5/31 0031 上午 11:05
 */
public enum TipsEnum {

    OK(200,"成功"),
    ERROR(500,"失败"),
    USER_NAME_ERROR(3,"用户名错误");
    public int code;
    public String msg;
    private TipsEnum(int code, String msg) {
        this.code = code;
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
