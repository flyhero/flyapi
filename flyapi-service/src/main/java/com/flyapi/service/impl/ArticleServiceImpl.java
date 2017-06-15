package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsSubjectMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsSubject;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<CmsArticle,CmsArticleMapper> implements ArticleService {

}
