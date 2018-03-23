package com.flyapi.pojo.vo;

/**
 * Author: qfwang
 * Date: 2018-03-23 下午4:23
 */
public class ShowSubjectVo {
    /**
     * 专题id
     */
    private String subjectId;

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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
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
}
