package com.flyapi.web.controller;

import com.flyapi.service.api.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: qfwang
 * Date: 2017-09-25
 * Time: 下午6:05
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class UserControllerTest {
    @Autowired
    private UserService userService;
}
