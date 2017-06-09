package com.flyapi.dao;

import com.flyapi.model.CmsRss;

public interface CmsRssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsRss record);

    int insertSelective(CmsRss record);

    CmsRss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsRss record);

    int updateByPrimaryKey(CmsRss record);
}