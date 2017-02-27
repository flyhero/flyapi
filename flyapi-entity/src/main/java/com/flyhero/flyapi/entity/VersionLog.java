package com.flyhero.flyapi.entity;

import java.util.Date;

public class VersionLog {
    private Integer versionLogId;

    private String versionLogContent;

    private Integer versionId;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Integer getVersionLogId() {
        return versionLogId;
    }

    public void setVersionLogId(Integer versionLogId) {
        this.versionLogId = versionLogId;
    }

    public String getVersionLogContent() {
        return versionLogContent;
    }

    public void setVersionLogContent(String versionLogContent) {
        this.versionLogContent = versionLogContent == null ? null : versionLogContent.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}