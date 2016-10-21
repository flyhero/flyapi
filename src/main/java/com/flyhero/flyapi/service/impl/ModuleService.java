package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ModuleMapper;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.service.IModuleService;

@Service
public class ModuleService implements IModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	@Override
	public List<Module> selectByProjectId(Integer projectId) {
		return moduleMapper.selectByProjectId(projectId);
	}
	@Override
	public Module selectByPrimaryKey(Integer moduleId) {
		return moduleMapper.selectByPrimaryKey(moduleId);
	}
	@Override
	public int insertSelective(Module record) {
		return moduleMapper.insertSelective(record);
	}

}
