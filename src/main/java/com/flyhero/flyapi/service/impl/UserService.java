package com.flyhero.flyapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.UserMapper;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.service.IUserService;


@Service
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findById(int id) {
		User result = null;
		try {
			result = userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public User findByUserName(User user) {
		User user2=userMapper.selectByUserName(user);
		if(user2 == null){
			return null;
		}
		return user2;
	}


	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}


	@Override
	public User findByLogin(User user) {
		User user2=userMapper.selectByLogin(user);
		if(user2 != null){
			return user2;
		}
		return null;
	}
	@Override
	public int updateLoginCount(User user){
		return userMapper.updateLoginCount(user);
	}


	@Override
	public int updateLoginTime(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
}
