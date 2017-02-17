package com.flyhero.flyapi.entity;

import java.util.Date;

import com.flyhero.flyapi.entity.base.Entity;

public class OperateLog extends Entity{
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = -6183965629102820847L;

	private Integer logId;

    private Integer userId;

    private Integer projectId;

    private String userName;

    private String operateType;

    private String modelClass;

    private String modelName;

    private String remark;

    private String content;

    private Date createTime;

    private Integer isDelete;

    public OperateLog() {
		super();
	}
	public OperateLog(Integer userId, Integer projectId, String operateType,
			String modelClass, String modelName, String remark, String content) {
		super();
		this.userId = userId;
		this.projectId = projectId;
		this.operateType = operateType;
		this.modelClass = modelClass;
		this.modelName = modelName;
		this.remark = remark;
		this.content = content;
	}
    public OperateLog(Integer userId,String userName, Integer projectId, String operateType,
			String modelClass, String modelName, String remark, String content) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.projectId = projectId;
		this.operateType = operateType;
		this.modelClass = modelClass;
		this.modelName = modelName;
		this.remark = remark;
		this.content = content;
	}
    
	public OperateLog(Integer logId, Integer userId, Integer projectId,
			String userName, String operateType, String modelClass,
			String modelName, String remark, String content, Date createTime,
			Integer isDelete) {
		super();
		this.logId = logId;
		this.userId = userId;
		this.projectId = projectId;
		this.userName = userName;
		this.operateType = operateType;
		this.modelClass = modelClass;
		this.modelName = modelName;
		this.remark = remark;
		this.content = content;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}
	public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass == null ? null : modelClass.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "OperateLog [logId=" + logId + ", userId=" + userId
				+ ", projectId=" + projectId + ", userName=" + userName
				+ ", operateType=" + operateType + ", modelClass=" + modelClass
				+ ", modelName=" + modelName + ", remark=" + remark
				+ ", content=" + content + ", createTime=" + createTime
				+ ", isDelete=" + isDelete + "]";
	}
    
}