package cn.iflyapi.blog.pojo.po;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-22 7:38 PM
 */
@Data
public class ArticleStats {

    public static ArticleStats view(Long articleId) {
        ArticleStats articleStats = new ArticleStats();
        articleStats.setArticleId(articleId);
        articleStats.setNum(1);
        return articleStats;
    }

    public static ArticleStats comment(Long articleId) {
        ArticleStats articleStats = new ArticleStats();
        articleStats.setArticleId(articleId);
        articleStats.setNum(2);
        return articleStats;
    }

    public static ArticleStats like(Long articleId) {
        ArticleStats articleStats = new ArticleStats();
        articleStats.setArticleId(articleId);
        articleStats.setNum(3);
        return articleStats;
    }

    private Long articleId;

    /**
     * 1. view
     * 2. comment
     * 3. like
     */
    private Integer num;
}
