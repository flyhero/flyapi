package com.flyapi.dao;

import com.flyapi.model.CmsTypeLog;

public interface CmsTypeLogMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(CmsTypeLog record);

    int insertSelective(CmsTypeLog record);

    CmsTypeLog selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(CmsTypeLog record);

    int updateByPrimaryKey(CmsTypeLog record);
}