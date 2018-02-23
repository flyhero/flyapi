package com.flyapi.pojo.dto;

/**
 * Author: qfwang
 * Date: 2018-02-23 下午9:39
 */
public class AddSubjectRequest {
    /**
     * 专题id
     */
    private Long subjectId;

    /**
     * 封面图
     */
    private String cover;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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


    @Override
    public String toString() {
        return "AddSubjectRequest{" +
                "subjectId=" + subjectId +
                ", cover='" + cover + '\'' +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", subjectDes='" + subjectDes + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
