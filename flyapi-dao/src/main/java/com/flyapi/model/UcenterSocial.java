package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UcenterSocial implements Serializable {
    private Long socialId;

    private Long userId;

    /**
     * 1 github 2 知乎 3 微博 4 领英 5 开源中国 6 掘金 7 sf 
     */
    private Byte socialType;

    private String socialUrl;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getSocialType() {
        return socialType;
    }

    public void setSocialType(Byte socialType) {
        this.socialType = socialType;
    }

    public String getSocialUrl() {
        return socialUrl;
    }

    public void setSocialUrl(String socialUrl) {
        this.socialUrl = socialUrl;
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
        UcenterSocial other = (UcenterSocial) that;
        return (this.getSocialId() == null ? other.getSocialId() == null : this.getSocialId().equals(other.getSocialId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSocialType() == null ? other.getSocialType() == null : this.getSocialType().equals(other.getSocialType()))
            && (this.getSocialUrl() == null ? other.getSocialUrl() == null : this.getSocialUrl().equals(other.getSocialUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSocialId() == null) ? 0 : getSocialId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSocialType() == null) ? 0 : getSocialType().hashCode());
        result = prime * result + ((getSocialUrl() == null) ? 0 : getSocialUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", socialId=").append(socialId);
        sb.append(", userId=").append(userId);
        sb.append(", socialType=").append(socialType);
        sb.append(", socialUrl=").append(socialUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}