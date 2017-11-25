package com.flyapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UcenterLog implements Serializable {
    /**
     * 日志id
     */
    private Long logId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 花费时间
     */
    private Integer spendTime;

    /**
     * 基础路径
     */
    private String basePath;

    /**
     * 扩展路径
     */
    private String uri;

    /**
     * 全路径
     */
    private String url;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 参数
     */
    private String params;

    /**
     * 浏览器
     */
    private String userAgent;

    /**
     * ip
     */
    private String ip;

    private static final long serialVersionUID = 1L;

    public UcenterLog() {
    }

    public UcenterLog(Long logId, String username, String description, Date createTime, Integer spendTime, String basePath, String uri, String url, String method, String params, String userAgent, String ip) {
        this.logId = logId;
        this.username = username;
        this.description = description;
        this.createTime = createTime;
        this.spendTime = spendTime;
        this.basePath = basePath;
        this.uri = uri;
        this.url = url;
        this.method = method;
        this.params = params;
        this.userAgent = userAgent;
        this.ip = ip;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "UcenterLog{" +
                "logId=" + logId +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", spendTime=" + spendTime +
                ", basePath='" + basePath + '\'' +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}