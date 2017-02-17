package com.flyhero.flyapi.pojo;

public class ParamPojo {
	
	private String name;
	private String isTrue;
	private String interType;
	private String des;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	public String getInterType() {
		return interType;
	}
	public void setInterType(String interType) {
		this.interType = interType;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "ParamPojo [name=" + name + ", isTrue=" + isTrue
				+ ", interType=" + interType + ", des=" + des + "]";
	}
	
	

}
