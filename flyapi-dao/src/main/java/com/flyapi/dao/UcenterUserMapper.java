package com.flyapi.dao;

import com.flyapi.model.UcenterUser;

public interface UcenterUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UcenterUser record);

    int insertSelective(UcenterUser record);

    UcenterUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UcenterUser record);

    int updateByPrimaryKey(UcenterUser record);
}