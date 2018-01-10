package com.flyapi.dao;

import com.flyapi.model.OpenSource;

import java.util.List;

public interface OpenSourceMapper {
    int deleteByPrimaryKey(Long osId);

    int insert(OpenSource record);

    int insertSelective(OpenSource record);

    OpenSource selectByPrimaryKey(Long osId);

    int updateByPrimaryKeySelective(OpenSource record);

    int updateByPrimaryKey(OpenSource record);

    List<OpenSource> findAll(Long userId);
}