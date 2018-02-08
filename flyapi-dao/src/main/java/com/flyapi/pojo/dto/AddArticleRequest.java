package com.flyapi.pojo.dto;

/**
 * Author: qfwang
 * Date: 2018-02-07 下午11:47
 */
public class AddArticleRequest {

    private Long articleId;
    private String title;
    private String articleDes;
    private String cover;
    private String mdContent;
    private String htmlContent;
    private Long subjectId;
    private String original;
    private Byte permissions;
    private Byte apply;
    private Byte status;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleDes() {
        return articleDes;
    }

    public void setArticleDes(String articleDes) {
        this.articleDes = articleDes;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Byte getPermissions() {
        return permissions;
    }

    public void setPermissions(Byte permissions) {
        this.permissions = permissions;
    }

    public Byte getApply() {
        return apply;
    }

    public void setApply(Byte apply) {
        this.apply = apply;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
