package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CmsReply implements Serializable {
    /**
     * 回复id
     */
    private Long replyId;

    /**
     * 评论id
     */
    private Long commentId;

    /**
     * 回复某人的回复
     */
    private Long reReplyId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复人
     */
    private Long fromUserId;

    /**
     * 被回复人
     */
    private Long toUserId;

    /**
     * 0回复评论1回复回复
     */
    private Byte replyType;

    /**
     * 回复时间
     */
    private Date createTime;

    private UcenterUser fromUser;

    private static final long serialVersionUID = 1L;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReReplyId() {
        return reReplyId;
    }

    public void setReReplyId(Long reReplyId) {
        this.reReplyId = reReplyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Byte getReplyType() {
        return replyType;
    }

    public void setReplyType(Byte replyType) {
        this.replyType = replyType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UcenterUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(UcenterUser fromUser) {
        this.fromUser = fromUser;
    }
}