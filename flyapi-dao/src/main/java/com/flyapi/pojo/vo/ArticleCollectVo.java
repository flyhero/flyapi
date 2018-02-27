package com.flyapi.pojo.vo;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsCollectArticle;

/**
 * Author: qfwang
 * Date: 2018-02-27 下午10:32
 */
public class ArticleCollectVo extends CmsCollectArticle{
    private CmsArticle cmsArticle;

    public CmsArticle getCmsArticle() {
        return cmsArticle;
    }

    public void setCmsArticle(CmsArticle cmsArticle) {
        this.cmsArticle = cmsArticle;
    }
}
