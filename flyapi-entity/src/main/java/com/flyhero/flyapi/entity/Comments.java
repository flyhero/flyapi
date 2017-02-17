package com.flyhero.flyapi.entity;

import java.util.Date;

import com.flyhero.flyapi.entity.base.Entity;

public class Comments extends Entity{
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1579847371980240871L;

	private Integer commentId;

    private Integer userId;

    private String content;

    private Integer interfaceId;

    private Integer targetId;

    private Date createTime;

    private Integer isDelete;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", userId=" + userId
				+ ", content=" + content + ", interfaceId=" + interfaceId
				+ ", targetId=" + targetId + ", createTime=" + createTime
				+ ", isDelete=" + isDelete + "]";
	}
    
}