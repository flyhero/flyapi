package com.flyhero.flyapi.dao;

import com.flyhero.flyapi.entity.VersionLog;

public interface VersionLogMapper {
    int deleteByPrimaryKey(Integer versionLogId);

    int insert(VersionLog record);

    int insertSelective(VersionLog record);

    VersionLog selectByPrimaryKey(Integer versionLogId);

    int updateByPrimaryKeySelective(VersionLog record);

    int updateByPrimaryKey(VersionLog record);
}