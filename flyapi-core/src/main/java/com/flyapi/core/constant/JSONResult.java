package com.flyapi.core.constant;

import java.io.Serializable;

/**
 * author: flyhero
 * Date: 2017/5/31 0031 上午 11:02
 */
public class JSONResult implements Serializable{

    /**
     * 成功或失败
     */
    private boolean success;
    /**
     * 返回信息的提示
     */
    private String msg;
    /**
     * 信息对应的状态码
     */
    private Integer code;
    /**
     * 返回的数据
     */
    private Object data;


    public JSONResult(boolean success, String msg, Integer code, Object data) {
        super();
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public JSONResult(String msg, Integer code, Object data) {
        super();
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public JSONResult(Boolean success,String msg, Integer code) {
        super();
        this.success = success;
        this.msg = msg;
        this.code = code;
    }
    public JSONResult(String msg, Integer code) {
        super();
        this.msg = msg;
        this.code = code;
    }

    public static JSONResult ok(){
        return ok(null);
    }
    public static JSONResult ok(Object data){
        return ok(TipsEnum.OK.getMsg(),TipsEnum.OK.getCode(), data);
    }
    public static JSONResult ok(String msg,int code,Object data){
        return new JSONResult(Constant.SUCCESS_T,msg,code,data);
    }

    public static JSONResult ok(TipsEnum tips){
        return ok(tips, null);
    }
    public static JSONResult ok(TipsEnum tips,Object data){
        return new JSONResult(Constant.SUCCESS_T,tips.getMsg(),tips.getCode(),data);
    }

    public static JSONResult error(){
        return error(null);
    }
    public static JSONResult error(Object data){
        return error(TipsEnum.ERROR.getMsg(),TipsEnum.ERROR.getCode(), data);
    }
    public static JSONResult error(String msg,int code,Object data){
        return new JSONResult(Constant.SUCCESS_F,msg,code,data);
    }

    public static JSONResult error(TipsEnum tips){
        return error(tips, null);
    }
    public static JSONResult error(TipsEnum tips,Object data){
        return new JSONResult(Constant.SUCCESS_F,tips.getMsg(),tips.getCode(),data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}
