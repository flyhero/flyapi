package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsCollectArticle;
import com.flyapi.pojo.vo.ArticleCollectVo;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface CollectArticleService extends BaseService<CmsCollectArticle> {

    List<ArticleCollectVo> findArticleByUserId(Long userId);

    int findCollectionCount(Long userId);

    int findIsCollectionByArticleId(Long articleId, Long userId);
}
