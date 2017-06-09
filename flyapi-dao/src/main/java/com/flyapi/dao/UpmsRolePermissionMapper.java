package com.flyapi.dao;

import com.flyapi.model.UpmsRolePermission;

public interface UpmsRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UpmsRolePermission record);

    int insertSelective(UpmsRolePermission record);

    UpmsRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UpmsRolePermission record);

    int updateByPrimaryKey(UpmsRolePermission record);
}