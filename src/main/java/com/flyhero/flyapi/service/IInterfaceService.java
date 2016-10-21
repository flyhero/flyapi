package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.Interface;
import com.flyhero.flyapi.entity.InterfaceWithBLOBs;

public interface IInterfaceService {
	List selectByModuleId(Integer moduleId);
	InterfaceWithBLOBs selectByPrimaryKey(Integer interfaceId);
    int insertSelective(InterfaceWithBLOBs record);
}
