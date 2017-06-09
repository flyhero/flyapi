package com.flyapi.dao;

import com.flyapi.model.SysInfo;

public interface SysInfoMapper {
    int deleteByPrimaryKey(Long infoId);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    SysInfo selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}