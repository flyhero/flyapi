package com.flyhero.flyapi.pojo;

import java.io.Serializable;
import java.util.Date;

public class InterPojo implements Serializable{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = -4471693493132653065L;

	private Integer projectId;
	
	private String moduleName;

    private Integer interfaceId;

    private String interName;

    private String interDes;

    private Integer status;

    private String interUrl;

    private String method;

    private Date createTime;

    private Date updateTime;

    private Integer moduleId;

    private Integer creator;

    private Integer isDelete;
    
    private String param;

    private String requestExam;

    private String responseParam;

    private String trueExam;

    private String falseExam;
    
    private String userName;
    
    private String avatarUrl;
    
    private String email;

	public Integer pageNumber=1;
	public Integer pageSize=10;
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getInterName() {
		return interName;
	}

	public void setInterName(String interName) {
		this.interName = interName;
	}

	public String getInterDes() {
		return interDes;
	}

	public void setInterDes(String interDes) {
		this.interDes = interDes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInterUrl() {
		return interUrl;
	}

	public void setInterUrl(String interUrl) {
		this.interUrl = interUrl;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getRequestExam() {
		return requestExam;
	}

	public void setRequestExam(String requestExam) {
		this.requestExam = requestExam;
	}

	public String getResponseParam() {
		return responseParam;
	}

	public void setResponseParam(String responseParam) {
		this.responseParam = responseParam;
	}

	public String getTrueExam() {
		return trueExam;
	}

	public void setTrueExam(String trueExam) {
		this.trueExam = trueExam;
	}

	public String getFalseExam() {
		return falseExam;
	}

	public void setFalseExam(String falseExam) {
		this.falseExam = falseExam;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "InterPojo [projectId=" + projectId + ", moduleName="
				+ moduleName + ", interfaceId=" + interfaceId + ", interName="
				+ interName + ", interDes=" + interDes + ", status=" + status
				+ ", interUrl=" + interUrl + ", method=" + method
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", moduleId=" + moduleId + ", creator=" + creator
				+ ", isDelete=" + isDelete + ", param=" + param
				+ ", requestExam=" + requestExam + ", responseParam="
				+ responseParam + ", trueExam=" + trueExam + ", falseExam="
				+ falseExam + ", userName=" + userName + ", avatarUrl="
				+ avatarUrl + ", email=" + email + "]";
	}
	
}
