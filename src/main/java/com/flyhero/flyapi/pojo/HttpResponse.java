package com.flyhero.flyapi.pojo;

import java.io.Serializable;

public class HttpResponse implements Serializable{
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1918154990679252827L;
	private String content;
	private String address;
	private int length;
	private int code;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "HttpResponse [content=" + content + ", address=" + address
				+ ", length=" + length + ", code=" + code + "]";
	}
	
	
}
