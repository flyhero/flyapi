package cn.iflyapi.blog.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author flyhero
 * @date 2018/12/17 7:53 PM
 */
@Data
public class ArticleVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;

    /**
     * 专题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    private String subjectTitle;

    /**
     * 作者id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String nickName;

    private String avatar;

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

    public ArticleVo(Long articleId, Long subjectId, String subjectTitle,
                     Long userId, String nickName, String avatar,
                     String title, String articleDes, String cover,
                     Integer viewNum, Integer commentNum, Integer likeNum) {
        this.articleId = articleId;
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.userId = userId;
        this.nickName = nickName;
        this.avatar = avatar;
        this.title = title;
        this.articleDes = articleDes;
        this.cover = cover;
        this.viewNum = viewNum;
        this.commentNum = commentNum;
        this.likeNum = likeNum;
    }
}
