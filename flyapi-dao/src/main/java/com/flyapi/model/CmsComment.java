package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class CmsComment implements Serializable {
    /**
     * id
     */
    private Long commentId;

    /**
     * 文章,漫等画,pk榜id
     */
    private Long targetId;

    private Long authorId;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 1文章2漫画3pk榜等
     */
    private Byte targetType;

    private Byte isRead;
    /**
     * 发表时间
     */
    private Date createTime;

    /**
     * 0显示1删除
     */
    private Byte isDelete;

    /**
     * 评论内容
     */
    private String content;

    private List<CmsReply> cmsReplyList;

    private static final long serialVersionUID = 1L;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Byte getTargetType() {
        return targetType;
    }

    public void setTargetType(Byte targetType) {
        this.targetType = targetType;
    }

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CmsReply> getCmsReplyList() {
        return cmsReplyList;
    }

    public void setCmsReplyList(List<CmsReply> cmsReplyList) {
        this.cmsReplyList = cmsReplyList;
    }
}