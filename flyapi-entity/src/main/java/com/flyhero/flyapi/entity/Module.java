package com.flyhero.flyapi.entity;

import java.util.Date;

import com.flyhero.flyapi.entity.base.Entity;

public class Module extends Entity{
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 495136417768786593L;

	private Integer moduleId;

    private String moduleName;

    private String moduleDes;

    private Integer projectId;

    private Date createTime;

    private Date updateTime;

    private Integer isDetele;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleDes() {
        return moduleDes;
    }

    public void setModuleDes(String moduleDes) {
        this.moduleDes = moduleDes == null ? null : moduleDes.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public Integer getIsDetele() {
        return isDetele;
    }

    public void setIsDetele(Integer isDetele) {
        this.isDetele = isDetele;
    }
}