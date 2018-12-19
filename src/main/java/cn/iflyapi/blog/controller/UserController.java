package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.UserService;
import cn.iflyapi.blog.util.IPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author: flyhero
 * date: 2018-12-13 9:55 AM
 */

@Api(value = "UserController", tags = "用户接口模块")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取指定用户信息")
    @GetMapping("/users/{userId}")
    public JSONResult findUser(@PathVariable Long userId) {
        return JSONResult.ok(userService.findOne(userId));
    }


    @ApiOperation(value = "用户注册", notes = "platform 1:web 2:mobile")
    @PostMapping("/users")
    public JSONResult login(String username, String password, Integer platform) {
        String ip = IPUtils.getIP(request);
        return JSONResult.ok(userService.register(username, password, platform, ip));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/users/login")
    public JSONResult login(String username, String password) {
        return JSONResult.ok(userService.login(username, password));
    }

}
