package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.dao.UserDao;
import cn.iflyapi.blog.model.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qfwang
 * @date: 2018-12-13 9:55 AM
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public JSONResult findUser() {
        return JSONResult.ok(userDao.findAll());
    }
}
