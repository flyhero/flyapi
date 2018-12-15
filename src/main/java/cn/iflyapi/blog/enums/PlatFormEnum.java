package cn.iflyapi.blog.enums;

/**
 * author: flyhero
 * date: 2018-12-15 4:15 PM
 */
public enum PlatFormEnum {
    PC(10, "pc"),
    MOBILE(20, "MOBILE");

    private Integer code;
    private String msg;

    public static boolean isExistCode(Integer code) {
        for (PlatFormEnum platFormEnum : PlatFormEnum.values()) {
            if (platFormEnum.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    PlatFormEnum(Integer code, String msg) {
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
