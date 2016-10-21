package com.flyhero.flyapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserProject implements Serializable{
    private Integer r1Id;

    private Timestamp createTime;

    private Integer userId;

    private Integer projectId;

    private Integer isEdit;

    private Integer isDelete;

    private Project project;
    

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getR1Id() {
        return r1Id;
    }

    public void setR1Id(Integer r1Id) {
        this.r1Id = r1Id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public Integer getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "UserProject [r1Id=" + r1Id + ", createTime=" + createTime
				+ ", userId=" + userId + ", projectId=" + projectId
				+ ", isEdit=" + isEdit + ", isDelete=" + isDelete
				+ ", project=" + project + "]";
	}
    
}