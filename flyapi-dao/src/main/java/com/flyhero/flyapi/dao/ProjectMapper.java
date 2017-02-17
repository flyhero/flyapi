package com.flyhero.flyapi.dao;

import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;

public interface ProjectMapper {
	
	ProjectDetailpojo findProjectDetail(Integer upId);
	
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    int updateDoneCount(Integer projectId);
}