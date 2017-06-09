package com.flyapi.model;

import java.io.Serializable;

/**
 * @author 
 */
public class CmsTypeLog implements Serializable {
    /**
     * 记录id
     */
    private Integer typeId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 准确率
     */
    private Short acc;

    /**
     * 单词数/分钟
     */
    private Integer wpm;

    private static final long serialVersionUID = 1L;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Short getAcc() {
        return acc;
    }

    public void setAcc(Short acc) {
        this.acc = acc;
    }

    public Integer getWpm() {
        return wpm;
    }

    public void setWpm(Integer wpm) {
        this.wpm = wpm;
    }
}