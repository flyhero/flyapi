package com.flyapi.dao;

import com.flyapi.model.UpmsRole;

public interface UpmsRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(UpmsRole record);

    int insertSelective(UpmsRole record);

    UpmsRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(UpmsRole record);

    int updateByPrimaryKey(UpmsRole record);
}