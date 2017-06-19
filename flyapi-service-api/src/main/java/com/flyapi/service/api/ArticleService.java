package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsArticle;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface ArticleService extends BaseService<CmsArticle> {
    int updateCommentNumOrLikeNumOrViewNum(CmsArticle record);
}
