package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UcenterFame implements Serializable {
    /**
     * 声望id
     */
    private Long fameId;

    /**
     * 起始值
     */
    private Integer startValue;

    /**
     * 结束值
     */
    private Integer endValue;

    /**
     * 声望名称
     */
    private String fameName;

    /**
     * 声望icon
     */
    private String fameIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0否1是
     */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getFameId() {
        return fameId;
    }

    public void setFameId(Long fameId) {
        this.fameId = fameId;
    }

    public Integer getStartValue() {
        return startValue;
    }

    public void setStartValue(Integer startValue) {
        this.startValue = startValue;
    }

    public Integer getEndValue() {
        return endValue;
    }

    public void setEndValue(Integer endValue) {
        this.endValue = endValue;
    }

    public String getFameName() {
        return fameName;
    }

    public void setFameName(String fameName) {
        this.fameName = fameName;
    }

    public String getFameIcon() {
        return fameIcon;
    }

    public void setFameIcon(String fameIcon) {
        this.fameIcon = fameIcon;
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
}