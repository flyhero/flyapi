package com.flyapi.dao;

import com.flyapi.model.CmsHomepageApply;

public interface CmsHomepageApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsHomepageApply record);

    int insertSelective(CmsHomepageApply record);

    CmsHomepageApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsHomepageApply record);

    int updateByPrimaryKey(CmsHomepageApply record);

    CmsHomepageApply findByArticleId(Long articleId);
}