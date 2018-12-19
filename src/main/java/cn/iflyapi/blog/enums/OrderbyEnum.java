package cn.iflyapi.blog.enums;

/**
 * @author flyhero
 * @date 2018-12-19 9:57 AM
 */
public enum OrderbyEnum {

    CREATETIME(1, "创建时间"),
    HOT(2, "热度"),
    PREDICTION(3, "预测");

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

    OrderbyEnum(Integer code, String msg) {
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
