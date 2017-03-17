package com.flyhero.flyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ModuleMapper;
import com.flyhero.flyapi.entity.Module;

public interface ModuleService{

	 List<Module> findModule(Integer projectId);

	 int deleteByPrimaryKey(Integer moduleId);

	 int insert(Module record);

	 int insertSelective(Module record);

	 Module selectByPrimaryKey(Integer moduleId);

	 int updateByPrimaryKeySelective(Module record);

	 int updateByPrimaryKey(Module record);
}
