package com.flyapi.dao;

import com.flyapi.model.UpmsAdminRole;

public interface UpmsAdminRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UpmsAdminRole record);

    int insertSelective(UpmsAdminRole record);

    UpmsAdminRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UpmsAdminRole record);

    int updateByPrimaryKey(UpmsAdminRole record);
}