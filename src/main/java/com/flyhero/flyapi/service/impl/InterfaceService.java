package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.InterfaceMapper;
import com.flyhero.flyapi.entity.Interface;
import com.flyhero.flyapi.entity.InterfaceWithBLOBs;
import com.flyhero.flyapi.service.IInterfaceService;

@Service
public class InterfaceService implements IInterfaceService {

	@Autowired
	private InterfaceMapper interfaceMapper;
	@Override
	public List selectByModuleId(Integer moduleId) {
		return interfaceMapper.selectByModuleId(moduleId);
	}
	@Override
	public InterfaceWithBLOBs selectByPrimaryKey(Integer interfaceId) {
		return interfaceMapper.selectByPrimaryKey(interfaceId);
	}
	@Override
	public int insertSelective(InterfaceWithBLOBs record) {
		return interfaceMapper.insertSelective(record);
	}

}
