package com.flyhero.flyapi.entity;

import java.util.Date;
import java.util.List;

public class Version {
    private Integer versionId;

    private String versionNum;

    private String versionDes;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;
    
    private List<VersionLog> versionLogList;

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum == null ? null : versionNum.trim();
    }

    public String getVersionDes() {
        return versionDes;
    }

    public void setVersionDes(String versionDes) {
        this.versionDes = versionDes == null ? null : versionDes.trim();
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

	public List<VersionLog> getVersionLogList() {
		return versionLogList;
	}

	public void setVersionLogList(List<VersionLog> versionLogList) {
		this.versionLogList = versionLogList;
	}
    
    
}