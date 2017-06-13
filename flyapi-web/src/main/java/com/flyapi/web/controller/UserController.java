package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.constant.TipsEnum;
import com.flyapi.service.api.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: flyhero
 * Date: 2017/6/12 0012 上午 10:53
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    private Logger logger = LogManager.getLogger(UserController.class);
    @RequestMapping("register")
    @ResponseBody
    public JSONResult register(){
        logger.info("请求参数："+"this is a test");
        logger.warn("请求参数："+"this is a test");
        logger.error("请求参数："+"this is a test");
        logger.debug("请求参数："+"this is a test");

        return JSONResult.ok(TipsEnum.OK);
    }
}
