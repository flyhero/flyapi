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
    USER_ALREADY_REGISTER(40003, "你已经注册过了"),
    USER_NOT_LOGIN(40004, "你还没有登录"),

    IMG_BED_MUST_BE_SET(40010, "你必须设置你的图床或赞助使用我们提供的图床"),
    IMG_FILE_ALREADY_100M(40010, "由于空间有限，目前仅能提供100M免费存储，你可自行设置图床或赞助我们继续使用"),

    RESOURCE_FORBIDDEN(40300, "你没有操作该资源的权限"),

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
