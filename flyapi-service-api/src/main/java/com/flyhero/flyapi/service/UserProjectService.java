package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.github.pagehelper.PageInfo;

public interface UserProjectService {

	 List<UserProject> findUserProject(Integer userId);
	 
	 PageInfo<UserProject> findUserCreate(UserProject up);
	 
	 PageInfo<UserProject> findUserJoin(UserProject up);
	 
	 List<UserProject> findUserEdit(Integer userId);
	 
	 int deleteUserProject(UserProject up);
	 
	 List<TeamMemberPojo> findTeamMembers(UserProject up);
	 
	 int findUserIsEdit(UserProject up);

	 int insert(UserProject record);

	 int insertSelective(UserProject record);

	 UserProject selectByPrimaryKey(Integer r1Id);

	 UserProject selectByIdAndPro(UserProject up);

	 int updateByPrimaryKeySelective(UserProject record);

	 int updateByPrimaryKey(UserProject record);

}
