package com.flyapi.dao;

import com.flyapi.model.CmsRss;

import java.util.List;

public interface CmsRssMapper {
    int deleteByPrimaryKey(Long rssId);

    int insert(CmsRss record);

    int insertSelective(CmsRss record);

    CmsRss selectByPrimaryKey(Long rssId);

    int updateByPrimaryKeySelective(CmsRss record);

    int updateByPrimaryKey(CmsRss record);

    List<CmsRss> findByUserIdAndSubjectId(CmsRss cmsRss);
}