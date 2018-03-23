package com.flyapi.pojo.vo;

import java.util.Date;

/**
 * Author: qfwang
 * Date: 2018-03-23 下午5:59
 */
public class ShowReplyVo {

    private String replyId;
    private String fromUserId;
    private Date createTime;
    private String content;

    private ShowUserVo fromUser;

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ShowUserVo getFromUser() {
        return fromUser;
    }

    public void setFromUser(ShowUserVo fromUser) {
        this.fromUser = fromUser;
    }
}
