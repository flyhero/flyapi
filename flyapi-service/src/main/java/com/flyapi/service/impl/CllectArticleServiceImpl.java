package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsCollectArticleMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsCollectArticle;
import com.flyapi.pojo.vo.ArticleCollectVo;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.CollectArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class CllectArticleServiceImpl extends BaseServiceImpl<CmsCollectArticle,CmsCollectArticleMapper> implements CollectArticleService {

    @Autowired
    private CmsCollectArticleMapper cmsCollectArticleMapper;

    @Override
    public List<ArticleCollectVo> findArticleByUserId(Long userId) {
        return cmsCollectArticleMapper.findArticleByUserId(userId);
    }

    @Override
    public int findCollectionCount(Long userId) {
        return cmsCollectArticleMapper.findCollectionCount(userId);
    }

    @Override
    public int findIsCollectionByArticleId(Long articleId, Long userId) {
        CmsCollectArticle cmsCollectArticle = new CmsCollectArticle();
        cmsCollectArticle.setArticleId(articleId);
        cmsCollectArticle.setUserId(userId);
        return cmsCollectArticleMapper.findIsCollectionByArticleId(cmsCollectArticle);
    }
}
