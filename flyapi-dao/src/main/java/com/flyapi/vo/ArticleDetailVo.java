package com.flyapi.vo;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.UcenterUser;

/**
 * author: flyhero
 * Date: 2017/6/22 0022 上午 11:12
 */
public class ArticleDetailVo {
    private CmsArticle article;
    private UcenterUser user;

    public CmsArticle getArticle() {
        return article;
    }

    public void setArticle(CmsArticle article) {
        this.article = article;
    }

    public UcenterUser getUser() {
        return user;
    }

    public void setUser(UcenterUser user) {
        this.user = user;
    }
}
