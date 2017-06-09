package com.flyapi.dao;

import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsArticleWithBLOBs;

public interface CmsArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(CmsArticleWithBLOBs record);

    int insertSelective(CmsArticleWithBLOBs record);

    CmsArticleWithBLOBs selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(CmsArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CmsArticleWithBLOBs record);

    int updateByPrimaryKey(CmsArticle record);
}