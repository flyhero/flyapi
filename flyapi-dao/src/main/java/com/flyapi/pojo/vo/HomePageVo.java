package com.flyapi.pojo.vo;

import java.util.Date;

/**
 * Author: qfwang
 * Date: 2018-03-16 上午12:13
 */
public class HomePageVo {
    private byte applyStatus;
    private Long articleId;
    private String title;
    private Date createTime;

    public byte getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(byte applyStatus) {
        this.applyStatus = applyStatus;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
