package com.flyhero.flyapi.service;

import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;

public interface ProjectService {

	int updateDoneCount(Integer projectId);

	ProjectDetailpojo findProjectDetail(Integer projectId);

	int deleteByPrimaryKey(Integer projectId);

	int insert(Project record);

	int saveProject(Project record,User user);

	Project selectByPrimaryKey(Integer projectId);

	int updateByPrimaryKeySelective(Project record);

	int updateByPrimaryKey(Project record);

}
