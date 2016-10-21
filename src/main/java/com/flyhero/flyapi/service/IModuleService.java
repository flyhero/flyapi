package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.Module;

public interface IModuleService {

	List<Module> selectByProjectId(Integer projectId);
	
	Module selectByPrimaryKey(Integer moduleId);
	
    int insertSelective(Module record);
}
