package com.flyapi.dao;

import com.flyapi.model.UpmsAdmin;

public interface UpmsAdminMapper {
    int deleteByPrimaryKey(Long adminId);

    int insert(UpmsAdmin record);

    int insertSelective(UpmsAdmin record);

    UpmsAdmin selectByPrimaryKey(Long adminId);

    int updateByPrimaryKeySelective(UpmsAdmin record);

    int updateByPrimaryKey(UpmsAdmin record);
}