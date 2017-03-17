package com.flyhero.flyapi.service;

import com.flyhero.flyapi.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	User findById(int id);

	User findByUserName(User user);

	int insertSelective(User record);

	PageInfo<User> queryByPage(Integer pageNo, Integer pageSize);

	User findByLogin(User user);

	int updateLoginCount(User user);
}
