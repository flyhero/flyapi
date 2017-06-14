package com.flyapi.web.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.ComplexResult2;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex2;
import com.baidu.unbiz.fluentvalidator.Result;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.constant.TipsEnum;
import com.flyapi.core.validator.StringValidator;
import com.flyapi.model.UcenterUser;
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

    @RequestMapping("go")
    public String go(){
        session.setAttribute("user","hahah");
        return "html/login";
    }
    @RequestMapping("login")
    public String login(UcenterUser user){
        Result result=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().result(toSimple());
        logger.info(result);
        ComplexResult complexResult=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().result(toComplex());
        logger.info(complexResult);
        String string=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().toString();
        logger.info(string);
        ComplexResult2 complexResult2=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().result(toComplex2());
        logger.info(complexResult2);
        if(userService.findUserByUsername(user.getUsername()) !=1){
            request.setAttribute("msg","用户名不存在");
            return "html/login";
        }
        UcenterUser userLogin = userService.login(user);
        if(userLogin == null){
            request.setAttribute("msg","用户名或密码错误！");
            return "html/login";
        }
        session.setAttribute("user",userLogin);
        return "html/index";
    }
}
