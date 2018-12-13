package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qfwang
 * @date: 2018-12-13 11:05 AM
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
}
