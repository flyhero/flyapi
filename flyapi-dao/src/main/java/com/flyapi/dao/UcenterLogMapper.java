package com.flyapi.dao;

import com.flyapi.model.UcenterLog;

public interface UcenterLogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(UcenterLog record);

    int insertSelective(UcenterLog record);

    UcenterLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(UcenterLog record);

    int updateByPrimaryKey(UcenterLog record);
}