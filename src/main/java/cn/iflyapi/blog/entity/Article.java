package cn.iflyapi.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * author flyhero
 * date 2018/12/16 6:46 PM
 */
@Data
@Entity
@Table(name = "cms_article")
public class Article {
    /**
     * 文章id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;

    /**
     * 专题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    /**
     * 作者id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String articleDes;

    /**
     * 封面
     */
    private String cover;

    /**
     * 原文链接
     */
    private String original;

    /**
     * 阅读数
     */
    private Integer viewNum;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 喜欢数
     */
    private Integer likeNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 0草稿1发布
     */
    private Integer status;

    /**
     * 0显示1删除
     */
    private Boolean isDelete;

    /**
     * md内容
     */
    private String mdContent;

    /**
     * html内容
     */
    private String htmlContent;
}
