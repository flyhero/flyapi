package com.flyhero.flyapi.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyhero.flyapi.dao.UserMapper;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	public User findById(int id) {
		User result = null;
		try {
			result = userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public User findByUserName(User user) {
		User user2=userMapper.findByUserName(user);
		if(user2 == null){
			return null;
		}
		return user2;
	}
	
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public PageInfo<User> queryByPage(Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userMapper.findAll();
		//用PageInfo对结果进行包装
		PageInfo<User> page = new PageInfo<User>(list);
		//测试PageInfo全部属性
		System.out.println(page.getPageNum());
		System.out.println(page.getPageSize());
		System.out.println(page.getStartRow());
		System.out.println(page.getEndRow());
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
		System.out.println(page.getFirstPage());
		System.out.println(page.getLastPage());
		System.out.println(page.isHasPreviousPage());
		System.out.println(page.isHasNextPage());
		return page;
	}  
	
	public User findByLogin(User user) {
		User user2=userMapper.findByLogin(user);
		if(user2 != null){
			return user2;
		}
		return null;
	}
	public int updateLoginCount(User user){
		return userMapper.updateLoginCount(user);
	}
	
	@Transactional
	public int insert() {
		int num=0;

			User user=new User();
			user.setUserName("wangfly4");
			user.setPassword("wang123456");
			user.setLoginIp("192.168.1.84");
			user.setCreateTime(new Date());
			num=userMapper.insertSelective(user);
			String string=null;
//			try {
			if(string.equals("456")){
				System.out.println("相等");
				return 25;
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 26;
//		}

		return num;
	}
}
