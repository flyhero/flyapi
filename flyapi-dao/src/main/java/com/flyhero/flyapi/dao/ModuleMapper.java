package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.Module;

public interface ModuleMapper {
	
	List<Module> findModule(Integer projectId);
	
    int deleteByPrimaryKey(Integer moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    
}