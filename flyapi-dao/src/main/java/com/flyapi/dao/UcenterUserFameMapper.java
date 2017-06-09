package com.flyapi.dao;

import com.flyapi.model.UcenterUserFame;

public interface UcenterUserFameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UcenterUserFame record);

    int insertSelective(UcenterUserFame record);

    UcenterUserFame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UcenterUserFame record);

    int updateByPrimaryKey(UcenterUserFame record);
}