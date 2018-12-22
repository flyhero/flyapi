package cn.iflyapi.blog.enums;

/**
 * @author qfwang
 * @date 2018-12-21 2:33 PM
 */
public enum OperationEnum {

    USER_REGISTER(1,"用户注册"),
    USER_LOGIN(2,"用户登录"),

    ARTICLE_READ(10, "阅读文章"),
    ARTICLE_WRITE(11, "发布文章"),
    ARTICLE_COMMENT(12, "评论文章"),

    SUBJECT_READ(15, "查询小书"),
    SUBJECT_WRITE(16, "创建小书"),
    SUBJECT_EXPORT(17, "导出小书"),
    ;

    private Integer code;
    private String msg;

    OperationEnum(Integer code, String msg) {
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
