package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.UserProjectMapper;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.service.IUserProjectService;

@Service
public class UserProjectService implements IUserProjectService {

	@Autowired
	private UserProjectMapper userProjectMapper;
	@Override
	public List selectMyProject(Integer userId) {
		return userProjectMapper.selectMyProject(userId);
	}
	@Override
	public int deleteByPrimaryKey(Integer r1Id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(UserProject record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertSelective(UserProject record) {
		return userProjectMapper.insertSelective(record);
	}
	@Override
	public UserProject selectByPrimaryKey(Integer r1Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateByPrimaryKeySelective(UserProject record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKey(UserProject record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserProject selectByIdAndPro(UserProject up) {
		return userProjectMapper.selectByIdAndPro(up);
	}

}
