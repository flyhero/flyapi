package cn.iflyapi.blog.model;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-25 6:22 PM
 */
@Data
public class OpLogArticle {
    private Long articleId;
    private String title;
    private String tags;

    public static OpLogArticle valueOf(Long articleId, String title, String tags) {
        OpLogArticle opLogArticle = new OpLogArticle();
        opLogArticle.setArticleId(articleId);
        opLogArticle.setTitle(title);
        opLogArticle.setTags(tags);
        return opLogArticle;
    }
}
