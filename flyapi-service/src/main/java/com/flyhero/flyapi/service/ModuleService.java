package com.flyhero.flyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ModuleMapper;
import com.flyhero.flyapi.entity.Module;

@Service
public class ModuleService{

	@Autowired
	private ModuleMapper moduleMapper;

	public List<Module> findModule(Integer projectId) {
		return moduleMapper.findModule(projectId);
	}

	public int deleteByPrimaryKey(Integer moduleId) {
		return moduleMapper.deleteByPrimaryKey(moduleId);
	}

	public int insert(Module record) {
		return moduleMapper.insert(record);
	}

	public int insertSelective(Module record) {
		return moduleMapper.insertSelective(record);
	}

	public Module selectByPrimaryKey(Integer moduleId) {
		return moduleMapper.selectByPrimaryKey(moduleId);
	}

	public int updateByPrimaryKeySelective(Module record) {
		return moduleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Module record) {
		return moduleMapper.updateByPrimaryKey(record);
	}
}
