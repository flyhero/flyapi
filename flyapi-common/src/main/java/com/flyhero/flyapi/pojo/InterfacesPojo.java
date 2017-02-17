package com.flyhero.flyapi.pojo;

import java.util.Date;
import java.util.List;

public class InterfacesPojo {
    private Integer interfaceId;

    private String interName;

    private String interDes;

    private String status;

    private String interUrl;

    private String method;

    private Date createTime;

    private Date updateTime;

    private Integer moduleId;

    private Integer creator;

    private Integer isDelete;
    
    private List<ParamPojo> param;
    
    private String requestExam;

    private String responseParam;

    private String trueExam;

    private String falseExam;
    
    private String content;
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
        this.interName = interName == null ? null : interName.trim();
    }

    public String getInterDes() {
        return interDes;
    }

    public void setInterDes(String interDes) {
        this.interDes = interDes == null ? null : interDes.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterUrl() {
        return interUrl;
    }

    public void setInterUrl(String interUrl) {
        this.interUrl = interUrl == null ? null : interUrl.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
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
 
    public List<ParamPojo> getParam() {
		return param;
	}

	public void setParam(List<ParamPojo> param) {
		this.param = param;
	}

	public String getRequestExam() {
        return requestExam;
    }

    public void setRequestExam(String requestExam) {
        this.requestExam = requestExam == null ? null : requestExam.trim();
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam == null ? null : responseParam.trim();
    }

    public String getTrueExam() {
        return trueExam;
    }

    public void setTrueExam(String trueExam) {
        this.trueExam = trueExam == null ? null : trueExam.trim();
    }

    public String getFalseExam() {
        return falseExam;
    }

    public void setFalseExam(String falseExam) {
        this.falseExam = falseExam == null ? null : falseExam.trim();
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Interfaces [interfaceId=" + interfaceId + ", interName="
				+ interName + ", interDes=" + interDes + ", status=" + status
				+ ", interUrl=" + interUrl + ", method=" + method
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", moduleId=" + moduleId + ", creator=" + creator
				+ ", isDelete=" + isDelete + ", param=" + param
				+ ", requestExam=" + requestExam + ", responseParam="
				+ responseParam + ", trueExam=" + trueExam + ", falseExam="
				+ falseExam + ", content=" + content + "]";
	}

    
    
}