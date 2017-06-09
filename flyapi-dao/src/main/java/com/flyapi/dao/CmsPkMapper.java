package com.flyapi.dao;

import com.flyapi.model.CmsPk;

public interface CmsPkMapper {
    int deleteByPrimaryKey(Long pkId);

    int insert(CmsPk record);

    int insertSelective(CmsPk record);

    CmsPk selectByPrimaryKey(Long pkId);

    int updateByPrimaryKeySelective(CmsPk record);

    int updateByPrimaryKey(CmsPk record);
}