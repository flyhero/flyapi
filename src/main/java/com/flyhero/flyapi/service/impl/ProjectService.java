package com.flyhero.flyapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ProjectMapper;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.service.IProjectService;

@Service
public class ProjectService implements IProjectService{

	@Autowired
	private ProjectMapper projectMapper;
	@Override
	public int deleteByPrimaryKey(Integer projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Project record) {
		return projectMapper.insertSelective(record);
	}

	@Override
	public Project selectByPrimaryKey(Integer projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}

	@Override
	public int updateByPrimaryKeySelective(Project record) {
		return projectMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Project record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
