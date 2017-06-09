package com.flyapi.dao;

import com.flyapi.model.CmsBook;

public interface CmsBookMapper {
    int deleteByPrimaryKey(Long bookId);

    int insert(CmsBook record);

    int insertSelective(CmsBook record);

    CmsBook selectByPrimaryKey(Long bookId);

    int updateByPrimaryKeySelective(CmsBook record);

    int updateByPrimaryKey(CmsBook record);
}