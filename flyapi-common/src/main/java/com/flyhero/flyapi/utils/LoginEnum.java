package com.flyhero.flyapi.utils;

public enum LoginEnum {

	SUCCESS(1,"SUCCESS"),
	ERROR(2,"ERROR"),
	USER_NAME_ERROR(3,"your name is invalid");
	public int code;
	public String msg;
	private LoginEnum(int code, String msg) {
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
