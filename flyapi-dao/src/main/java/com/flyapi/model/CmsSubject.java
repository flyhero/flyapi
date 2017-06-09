package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CmsSubject implements Serializable {
    /**
     * 专题id
     */
    private Long subjectId;

    /**
     * 专题标题
     */
    private String subjectTitle;

    /**
     * 描述
     */
    private String subjectDes;

    /**
     * 权限0公开1私有
     */
    private Byte permissions;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0显示1删除
     */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectDes() {
        return subjectDes;
    }

    public void setSubjectDes(String subjectDes) {
        this.subjectDes = subjectDes;
    }

    public Byte getPermissions() {
        return permissions;
    }

    public void setPermissions(Byte permissions) {
        this.permissions = permissions;
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