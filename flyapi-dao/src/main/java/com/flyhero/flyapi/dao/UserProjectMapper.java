package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.TeamMemberPojo;

public interface UserProjectMapper {
	
	List<UserProject> findUserProject(Integer userId);
	
	List<UserProject> findUserCreate(UserProject up);
	
	List<UserProject> findUserJoin(UserProject up);
	
	List<UserProject> findUserEdit(Integer userId);
	
	List<TeamMemberPojo> findTeamMembers(UserProject up);
	
	int findUserIsEdit(UserProject up);
	
	int deleteUserProject(UserProject up);
	
    int deleteByPrimaryKey(Integer upId);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(Integer upId);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
}