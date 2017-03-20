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
	private UserProjectService userProjectService;
	
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

	public void saveProject(Project record,User user) {
		
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
				userProjectService.insertSelective(userProject);
			}

		}
	}

	public Project selectByPrimaryKey(Integer projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}

	public void updateProject(Project project,User user) {
		projectMapper.updateByPrimaryKeySelective(project);
		OperateLog log=new OperateLog(user.getUserId(),user.getUserName(), project.getProjectId(), Constant.TYPE_UPDATE,
				Constant.CLASS_PROJECT, Constant.NAME_PROJECT, "更新："+project.getProName()+"项目", JSONObject.toJSONString(project));
		logService.addLog(log);
	}

	public int updateByPrimaryKey(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteProject(Project project, User user) {
		project.setIsDelete(1);
		UserProject uProject=new UserProject();
		uProject.setProjectId(project.getProjectId());
		projectMapper.updateByPrimaryKeySelective(project);
		userProjectService.deleteUserProject(uProject);
		OperateLog log=new OperateLog(user.getUserId(),user.getUserName(), project.getProjectId(), Constant.TYPE_DELETE,
				Constant.CLASS_PROJECT, Constant.NAME_PROJECT, "删除："+project.getProName()+"项目", JSONObject.toJSONString(project));
		logService.addLog(log);
	}


}
