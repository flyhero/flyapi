package com.flyapi.dao;

import com.flyapi.model.CmsCollectArticle;

import java.util.List;

public interface CmsCollectArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsCollectArticle record);

    int insertSelective(CmsCollectArticle record);

    CmsCollectArticle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsCollectArticle record);

    int updateByPrimaryKey(CmsCollectArticle record);

    List<CmsCollectArticle> findArticleByUserId(Long articleId);
 }