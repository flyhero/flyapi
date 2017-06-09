package com.flyapi.dao;

import com.flyapi.model.UcenterUserRelation;

public interface UcenterUserRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UcenterUserRelation record);

    int insertSelective(UcenterUserRelation record);

    UcenterUserRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UcenterUserRelation record);

    int updateByPrimaryKey(UcenterUserRelation record);
}