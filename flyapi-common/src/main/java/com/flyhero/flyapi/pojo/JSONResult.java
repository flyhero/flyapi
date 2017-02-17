package com.flyhero.flyapi.pojo;

import java.io.Serializable;

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

	/**
	 * 返回信息的成功与失败
	 */
	private String msg;
	/**
	 * 成功与失败的具体信息
	 */
	private Integer code;
	/**
	 * 返回的数据
	 */
	private Object data;
	
	public JSONResult(String msg, Integer code, Object data) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
	}
	
	public JSONResult(String msg, Integer code) {
		super();
		this.msg = msg;
		this.code = code;
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
