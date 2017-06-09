package com.flyapi.dao;

import com.flyapi.model.UcenterUserAuth;

public interface UcenterUserAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UcenterUserAuth record);

    int insertSelective(UcenterUserAuth record);

    UcenterUserAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UcenterUserAuth record);

    int updateByPrimaryKey(UcenterUserAuth record);
}