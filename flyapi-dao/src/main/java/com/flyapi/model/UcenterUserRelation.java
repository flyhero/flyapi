package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UcenterUserRelation implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 来自id
     */
    private Long fromUserId;

    /**
     * 对应id
     */
    private Long toUserId;

    /**
     * 1粉丝关注2拉黑等
     */
    private Byte relType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0正常1删除
     */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Byte getRelType() {
        return relType;
    }

    public void setRelType(Byte relType) {
        this.relType = relType;
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