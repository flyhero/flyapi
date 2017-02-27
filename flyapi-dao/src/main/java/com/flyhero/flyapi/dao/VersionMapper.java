package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.Version;

public interface VersionMapper {
	
	List<Version> findVersionLog();
	
	
    int deleteByPrimaryKey(Integer versionId);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Integer versionId);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}