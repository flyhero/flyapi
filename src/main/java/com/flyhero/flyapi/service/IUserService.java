package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.User;


public interface IUserService {
	
	public User findById(int id);
	
	public User findByUserName(User user);
	
	public int insertSelective(User record);
	
	public User findByLogin(User user);

	public int updateLoginCount(User user);

	public int updateLoginTime(User user);
}
