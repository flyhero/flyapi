package com.flyapi.dao;

import com.flyapi.model.CmsCollectArticle;
import com.flyapi.pojo.vo.ArticleCollectVo;

import java.util.List;

public interface CmsCollectArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsCollectArticle record);

    int insertSelective(CmsCollectArticle record);

    CmsCollectArticle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsCollectArticle record);

    int updateByPrimaryKey(CmsCollectArticle record);

    List<ArticleCollectVo> findArticleByUserId(Long userId);

    int findIsCollectionByArticleId(CmsCollectArticle cmsCollectArticle);

    int findCollectionCount(Long userId);
}