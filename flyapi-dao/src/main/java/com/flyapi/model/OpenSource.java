package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class OpenSource implements Serializable {
    private Long osId;

    private Long userId;

    private String osName;

    private String account;

    /**
     * 1.github 2.oschina
     */
    private Byte osType;

    private Date createTime;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Byte getOsType() {
        return osType;
    }

    public void setOsType(Byte osType) {
        this.osType = osType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OpenSource other = (OpenSource) that;
        return (this.getOsId() == null ? other.getOsId() == null : this.getOsId().equals(other.getOsId()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getOsType() == null ? other.getOsType() == null : this.getOsType().equals(other.getOsType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOsId() == null) ? 0 : getOsId().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getOsType() == null) ? 0 : getOsType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", osId=").append(osId);
        sb.append(", osName=").append(osName);
        sb.append(", account=").append(account);
        sb.append(", osType=").append(osType);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}