package com.flyhero.flyapi.service;

import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;

public interface ProjectService {

	int updateDoneCount(Integer projectId);

	ProjectDetailpojo findProjectDetail(Integer projectId);

	int deleteByPrimaryKey(Integer projectId);

	int insert(Project record);

	void saveProject(Project record,User user);

	Project selectByPrimaryKey(Integer projectId);

	void updateProject(Project record,User user);
	
	void deleteProject(Project record,User user);

	int updateByPrimaryKey(Project record);

}
