package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.Interface;
import com.flyhero.flyapi.entity.InterfaceWithBLOBs;

public interface InterfaceMapper {
    int deleteByPrimaryKey(Integer interfaceId);

    int insert(InterfaceWithBLOBs record);

    int insertSelective(InterfaceWithBLOBs record);

    InterfaceWithBLOBs selectByPrimaryKey(Integer interfaceId);

    int updateByPrimaryKeySelective(InterfaceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InterfaceWithBLOBs record);

    int updateByPrimaryKey(Interface record);
    
    List selectByModuleId(Integer moduleId);
}