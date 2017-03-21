package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.dao.ModuleMapper;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ModuleService;
import com.flyhero.flyapi.utils.Constant;

@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private LogService logService;

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

	public void addModule(Module module,User user) {
		OperateLog log=new OperateLog(user.getUserId(),user.getUserName(), module.getProjectId(), Constant.TYPE_INSERT, Constant.CLASS_MODULE, 
				Constant.NAME_MODULE, "新建："+module.getModuleName()+"模块", JSONObject.toJSONString(module));
		logService.addLog(log);
		
	}
	@Override
	public int updateByPrimaryKey(Module record, User user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
