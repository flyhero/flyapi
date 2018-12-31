package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.annotation.OpenApi;
import cn.iflyapi.blog.entity.User;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.pojo.dto.LoginDto;
import cn.iflyapi.blog.pojo.dto.ResetPwDto;
import cn.iflyapi.blog.pojo.dto.Support;
import cn.iflyapi.blog.pojo.dto.UserBaseDto;
import cn.iflyapi.blog.service.UserService;
import cn.iflyapi.blog.util.IPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author flyhero
 * @date 2018-12-13 9:55 AM
 */

@Api(value = "UserController", tags = "用户接口")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @OpenApi("/users/*")
    @ApiOperation(value = "获取指定用户信息")
    @GetMapping("/users/{userId}")
    public JSONResult findUser(@PathVariable Long userId) {
        User user = userService.findOne(userId);
        user.setUsername("");
        user.setPassword("");
        return JSONResult.ok();
    }

    @OpenApi("/users")
    @ApiOperation(value = "用户注册", notes = "platform 1:web 2:mobile")
    @PostMapping("/users")
    public JSONResult register(@RequestBody LoginDto loginDto) {
        String ip = IPUtils.getIP(request);
        return JSONResult.ok(userService.register(loginDto.getUsername(), loginDto.getPassword(), loginDto.getPlatform(), ip));
    }

    @OpenApi("/users/login")
    @ApiOperation(value = "用户登录")
    @PostMapping("/users/login")
    public JSONResult login(@RequestBody LoginDto loginDto) {
        return JSONResult.ok(userService.login(loginDto.getUsername(), loginDto.getPassword()));
    }

    @ApiOperation(value = "用户信息修改")
    @PatchMapping("/users/{userId}")
    public JSONResult update(@RequestBody UserBaseDto user, @PathVariable Long userId) {
        userService.update(user, getUserId());
        return JSONResult.ok();
    }

    @OpenApi("/users/*/view")
    @ApiOperation(value = "用户主页浏览")
    @PatchMapping("/users/{userId}/view")
    public JSONResult view(@PathVariable Long userId) {
        userService.viewHomePage(userId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "重置密码")
    @PatchMapping("/users/password")
    public JSONResult resetPw(@RequestBody ResetPwDto resetPwDto) {
        userService.resetPassword(resetPwDto.getOldPassword(), resetPwDto.getNewPassword(), getUserId());
        return JSONResult.ok();
    }

    @ApiOperation("修改赞赏")
    @PatchMapping("/users/support")
    public JSONResult update(@RequestBody Support support) {
        userService.updateSupport(support, getUserId());
        return JSONResult.ok();
    }

}
