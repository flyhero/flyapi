package cn.iflyapi.blog.enums;

/**
 * author: flyhero
 * date: 2018-12-13 10:02 AM
 */
public enum CodeMsgEnum {
    OK(200, "Success"),
    FAIL(-1, "Fail"),
    USERNAME_OR_PASSWD_INVALID(40000, "用户名或密码不正确"),
    USERNAME_EXIST(40001, "用户名已存在"),
    USERNAME_MUST_MAIL_OR_PHONE(40002, "用户名必须是邮箱或手机号"),

    RESOURCE_FORBIDDEN(40300, "你没有查看该资源的权限"),

    RESOURCE_NOT_EXIST(40400, "你查询的资源不存在"),

    USER_IS_DISABLED(50000, "用户已被禁用");


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
