package com.flyhero.flyapi.pojo;

/**
 * 提示枚举
 * @ClassName: TipsEnum 
 * @author flyhero(http://flyhero.top)
 * @date 2017年3月20日 下午4:47:24 
 *
 */
public enum TipsEnum {

	OK(200,"成功"),
	ERROR(500,"失败"),
	USER_NAME_ERROR(3,"your name is invalid");
	public int code;
	public String msg;
	private TipsEnum(int code, String msg) {
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
