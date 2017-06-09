package com.flyapi.dao;

import com.flyapi.model.CmsLike;

public interface CmsLikeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsLike record);

    int insertSelective(CmsLike record);

    CmsLike selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsLike record);

    int updateByPrimaryKey(CmsLike record);
}