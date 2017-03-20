package com.flyhero.flyapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.dao.OperateLogMapper;
import com.flyhero.flyapi.dao.ProjectMapper;
import com.flyhero.flyapi.dao.UserProjectMapper;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ProjectService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.utils.Constant;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private LogService logService;
	@Autowired
	private UserProjectService UserProjectService;
	
	public int updateDoneCount(Integer projectId){
		return projectMapper.updateDoneCount(projectId);
	}
	
	public ProjectDetailpojo findProjectDetail(Integer projectId){
		return projectMapper.findProjectDetail(projectId);
	}
	
	public int deleteByPrimaryKey(Integer projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int saveProject(Project record,User user) {
		
		int flag=projectMapper.insertSelective(record);
		if(flag>0){
			UserProject userProject=new UserProject();
			OperateLog log=new OperateLog(user.getUserId(),user.getUserName(), 0, Constant.TYPE_INSERT, Constant.CLASS_PROJECT, 
					Constant.NAME_PROJECT, "创建："+record.getProName()+"项目", JSONObject.toJSONString(record));
			logService.addLog(log);
			if(user != null){
				userProject.setProjectId(record.getProjectId());
				userProject.setUserId(user.getUserId());
				userProject.setIsCreator(1);
				userProject.setIsEdit(1);
				userProject.setIsDelete(0);
				UserProjectService.insertSelective(userProject);
			}

		}
		
		return 1;
	}

	public Project selectByPrimaryKey(Integer projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}

	public int updateByPrimaryKeySelective(Project record) {
		return projectMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
