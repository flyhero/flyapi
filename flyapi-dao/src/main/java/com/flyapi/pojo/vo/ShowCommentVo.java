package com.flyapi.pojo.vo;

import java.util.Date;
import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-03-23 下午5:37
 */
public class ShowCommentVo{

    private Long userId;
    private String commentId;
    private String content;
    private Date createTime;
    private ShowUserVo ucenterUser;

    private List<ShowReplyVo> cmsReplyList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ShowUserVo getUcenterUser() {
        return ucenterUser;
    }

    public void setUcenterUser(ShowUserVo ucenterUser) {
        this.ucenterUser = ucenterUser;
    }

    public List<ShowReplyVo> getCmsReplyList() {
        return cmsReplyList;
    }

    public void setCmsReplyList(List<ShowReplyVo> cmsReplyList) {
        this.cmsReplyList = cmsReplyList;
    }
}
