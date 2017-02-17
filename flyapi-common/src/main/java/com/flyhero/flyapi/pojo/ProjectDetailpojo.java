package com.flyhero.flyapi.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProjectDetailpojo implements Serializable{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = -8689530079817031049L;

	private Integer upId;
	private Integer isEdit;
	private Integer isCreator;
	private Integer projectId;
	private String userName;
	private String avatarUrl;
	private String company;
	private String proName;
	private String proDes;
	private String proVersion;
	private Date createTime;
	private Integer targetCount;
	private Integer doneCount;
	public Integer getUpId() {
		return upId;
	}
	public void setUpId(Integer upId) {
		this.upId = upId;
	}
	public Integer getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Integer isEdit) {
		this.isEdit = isEdit;
	}
	public Integer getIsCreator() {
		return isCreator;
	}
	public void setIsCreator(Integer isCreator) {
		this.isCreator = isCreator;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDes() {
		return proDes;
	}
	public void setProDes(String proDes) {
		this.proDes = proDes;
	}
	public String getProVersion() {
		return proVersion;
	}
	public void setProVersion(String proVersion) {
		this.proVersion = proVersion;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTargetCount() {
		return targetCount;
	}
	public void setTargetCount(Integer targetCount) {
		this.targetCount = targetCount;
	}
	public Integer getDoneCount() {
		return doneCount;
	}
	public void setDoneCount(Integer doneCount) {
		this.doneCount = doneCount;
	}
	
	
}
