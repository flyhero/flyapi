package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: flyhero
 * Date: 2017/6/12 0012 上午 10:53
 */
@Controller("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
}
