package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.User;

public interface ModuleService{

	 List<Module> findModule(Integer projectId);

	 int deleteByPrimaryKey(Integer moduleId);

	 int insert(Module record);

	 int insertSelective(Module record);
	 
	 void addModule(Module module,User user);

	 Module selectByPrimaryKey(Integer moduleId);

	 int updateByPrimaryKeySelective(Module record);

	 int updateByPrimaryKey(Module record,User user);
}
