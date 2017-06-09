package com.flyapi.dao;

import com.flyapi.model.UpmsPermission;

public interface UpmsPermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(UpmsPermission record);

    int insertSelective(UpmsPermission record);

    UpmsPermission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(UpmsPermission record);

    int updateByPrimaryKey(UpmsPermission record);
}