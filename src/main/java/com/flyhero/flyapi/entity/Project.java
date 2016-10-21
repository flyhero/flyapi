package com.flyhero.flyapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Project implements Serializable{
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 4931019194027193834L;

	private Integer projectId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private Timestamp createTime;

    private String projectName;

    private String description;

    private String projectVersion;

    private Integer isDelete;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion == null ? null : projectVersion.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", createTime=" + createTime
				+ ", projectName=" + projectName + ", description="
				+ description + ", projectVersion=" + projectVersion
				+ ", isDelete=" + isDelete + "]";
	}
    
}