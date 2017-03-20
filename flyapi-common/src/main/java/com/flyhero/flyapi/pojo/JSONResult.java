package com.flyhero.flyapi.pojo;

import java.io.Serializable;

import com.flyhero.flyapi.utils.Constant;

/**
 * 封装返回json结果
 * <p>Title: JSONResult</p>
 * <p>Description: </p>
 * <p>Company: flyhero.top</p>
 * @author qfwang
 * @date 2016年11月4日
 */
public class JSONResult implements Serializable{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = -3190673237558249474L;

	private boolean success;
	/**
	 * 返回信息的提示
	 */
	private String msg;
	/**
	 * 成功与失败的状态码
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
		return ok(Constant.CODE_200, data);
	}
	public static JSONResult ok(int code,Object data){
		return new JSONResult(Constant.SUCCESS_T,Constant.MSG_OK,code,data);
	}
	public static JSONResult ok(int code,String msg,Object data){
		return new JSONResult(Constant.SUCCESS_T,msg,code,data);
	}

	public static JSONResult error(){
		return error(null);
	}
	public static JSONResult error(Object data){
		return new JSONResult(Constant.MSG_ERROR,Constant.CODE_200,data);
	}
	public static JSONResult error(int code,Object data){
		return new JSONResult(Constant.SUCCESS_F,Constant.MSG_ERROR,code,data);
	}
	public static JSONResult error(int code,String msg,Object data){
		return new JSONResult(Constant.SUCCESS_F,msg,code,data);
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
