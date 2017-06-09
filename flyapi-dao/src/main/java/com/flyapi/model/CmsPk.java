package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CmsPk implements Serializable {
    /**
     * id
     */
    private Long pkId;

    /**
     * 题目
     */
    private String pkTitle;

    /**
     * 描述
     */
    private String pkDes;

    /**
     * 正方
     */
    private Integer agreeNum;

    /**
     * 反方
     */
    private Integer disagreeNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0正常1删除
     */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getPkTitle() {
        return pkTitle;
    }

    public void setPkTitle(String pkTitle) {
        this.pkTitle = pkTitle;
    }

    public String getPkDes() {
        return pkDes;
    }

    public void setPkDes(String pkDes) {
        this.pkDes = pkDes;
    }

    public Integer getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(Integer agreeNum) {
        this.agreeNum = agreeNum;
    }

    public Integer getDisagreeNum() {
        return disagreeNum;
    }

    public void setDisagreeNum(Integer disagreeNum) {
        this.disagreeNum = disagreeNum;
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