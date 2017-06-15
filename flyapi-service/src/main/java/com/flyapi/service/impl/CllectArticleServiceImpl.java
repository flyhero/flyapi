package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsCollectArticleMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsCollectArticle;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.CollectArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class CllectArticleServiceImpl extends BaseServiceImpl<CmsCollectArticle,CmsCollectArticleMapper> implements CollectArticleService {

    @Autowired
    private CmsCollectArticleMapper cmsCollectArticleMapper;
}
