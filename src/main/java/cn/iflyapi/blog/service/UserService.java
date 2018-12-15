package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.UserDao;
import cn.iflyapi.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qfwang
 * @date: 2018-12-13 11:05 AM
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUser() {
        return userDao.findAllByIsDeleteEquals(false);
    }

    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
