package com.flyhero.flyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ProjectMapper;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;

@Service
public class ProjectService{

	@Autowired
	private ProjectMapper projectMapper;
	
	public int updateDoneCount(Integer projectId){
		return projectMapper.updateDoneCount(projectId);
	}
	
	public ProjectDetailpojo findProjectDetail(Integer upId){
		return projectMapper.findProjectDetail(upId);
	}
	
	public int deleteByPrimaryKey(Integer projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Project record) {
		return projectMapper.insertSelective(record);
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
