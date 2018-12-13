package cn.iflyapi.blog.model;

import cn.iflyapi.blog.enums.CodeMsgEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: qfwang
 * @date: 2018-12-13 9:56 AM
 */
@Getter
@Setter
public class JSONResult {

    private int code;
    private String msg;
    private boolean success;
    private Object data;

    private JSONResult(int code, String msg, boolean success, Object data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public static JSONResult ok(int code, String msg, Object data) {
        return new JSONResult(code, msg, true, data);
    }

    public static JSONResult ok(CodeMsgEnum codeMsgEnum, Object data) {
        return ok(codeMsgEnum.getCode(), codeMsgEnum.getMsg(), data);
    }

    public static JSONResult ok(Object data) {
        return ok(CodeMsgEnum.OK, data);
    }

    public static JSONResult ok() {
        return ok(CodeMsgEnum.OK, null);
    }

    public static JSONResult fail(int code, String msg, Object data) {
        return new JSONResult(code, msg, false, data);
    }

    public static JSONResult fail(CodeMsgEnum codeMsgEnum, Object data) {
        return ok(codeMsgEnum.getCode(), codeMsgEnum.getMsg(), data);
    }

    public static JSONResult fail(CodeMsgEnum codeMsgEnum) {
        return ok(codeMsgEnum.getCode(), codeMsgEnum.getMsg(), null);
    }

    public static JSONResult fail(Object data) {
        return ok(CodeMsgEnum.FAIL, data);
    }

    public static JSONResult fail() {
        return ok(CodeMsgEnum.FAIL, null);
    }
}
