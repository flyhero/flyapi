package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.User;

public interface UserMapper {
	
	User findByUserName(User user);
	
	User findByLogin(User user);
	
	int updateLoginCount(User user);
	
	List<User> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}