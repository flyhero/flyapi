package com.flyhero.flyapi.dao;

import com.flyhero.flyapi.entity.User;


public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);
    User selectByLogin(User record);
    User selectByPrimaryKey(Integer userId);
    User selectByUserName(User record);
    int updateByPrimaryKeySelective(User record);
    int updateLoginCount(User user);
    int updateByPrimaryKey(User record);



}