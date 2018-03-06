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
import com.flyapi.core.exception.UploadException;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.core.util.AESUtil;
import com.flyapi.core.util.CookieUtil;
import com.flyapi.core.validator.StringValidator;
import com.flyapi.model.*;
import com.flyapi.pojo.dto.PasswordDto;
import com.flyapi.pojo.dto.RegisterDto;
import com.flyapi.pojo.vo.ActiveVo;
import com.flyapi.pojo.vo.CommentVo;
import com.flyapi.pojo.vo.ViewLevelVo;
import com.flyapi.service.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/12 0012 上午 10:53
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserFameService userFameService;
    @Autowired
    private FameService fameService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private SettingStoreService settingStoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private OpenSourceService openSourceService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private SubjectService subjectService;

    private Logger logger = LogManager.getLogger(UserController.class);

    /**
     * 跳转到某处
     * Title: go
     * params: [html]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/16 0016 下午 5:56
     */
    @RequestMapping("go")
    public ModelAndView go(String html){
        mv.setViewName(html);
        return mv;
    }


    /**
     * 注册
     * Title: register
     * params: [registerDto]
     * return: ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/15 0015 下午 5:49
     */
    @RequestMapping("register")
    public ModelAndView register(RegisterDto registerDto){
        Result result=FluentValidator.checkAll()
                .on(registerDto.getUsername(),new StringValidator(0,11,"用户名"))
                .on(registerDto.getPw(),new StringValidator("密码"))
                .on(registerDto.getConfirmPw(),new StringValidator("再次密码"))
                .doValidate().result(toSimple());
        logger.debug("验证结果："+result.isSuccess());
        if(!result.isSuccess()){
            mv.addObject("msg",result.getErrors());
            mv.setViewName("login");
            return mv;
        }
        if(userService.findUserByUsername(registerDto.getUsername()) == 1){
            mv.addObject("msg","用户名已存在");
            mv.setViewName("login");
            return mv;
        }
        if(!registerDto.getPw().equals(registerDto.getConfirmPw())){
            mv.addObject("msg","两次密码不同！");
            mv.setViewName("login");
            return mv;
        }
        UcenterUser user =new UcenterUser();
        user.setUserId(snowflakeIdWorker.nextId());
        user.setUsername(registerDto.getUsername());
        user.setNickName(registerDto.getUsername());
        user.setPassword(AESUtil.AESEncode(registerDto.getPw()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        if(userService.insertSelective(user) > 0){
            SettingStore store = new SettingStore();
            store.setId(snowflakeIdWorker.nextId());
            UcenterUser login = userService.initStore(user,store);
            login.setPassword("");
            session.setAttribute("user",login);
            CookieUtil.setCookie(response,"isLogin","true");
            mv.setViewName("index");
            return mv;
        }
        return mv;
    }

    @PostMapping("register")
    @ResponseBody
    public JSONResult userRegister(RegisterDto registerDto){
        Result result=FluentValidator.checkAll()
                .on(registerDto.getUsername(),new StringValidator(0,11,"用户名"))
                .on(registerDto.getPw(),new StringValidator("密码"))
                .on(registerDto.getConfirmPw(),new StringValidator("再次密码"))
                .doValidate().result(toSimple());
        logger.debug("验证结果："+result.isSuccess());
        if(!result.isSuccess()){
            return JSONResult.error(result.getErrors().toString(),300,null);
        }
        if(userService.findUserByUsername(registerDto.getUsername()) == 1){
            return JSONResult.error("用户名已存在",300,null);
        }
        if(!registerDto.getPw().equals(registerDto.getConfirmPw())){
            return JSONResult.error("两次密码不同！",300,null);
        }
        UcenterUser user =new UcenterUser();
        user.setUserId(snowflakeIdWorker.nextId());
        user.setUsername(registerDto.getUsername());
        user.setNickName(registerDto.getUsername());
        user.setPassword(AESUtil.AESEncode(registerDto.getPw().trim()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        if(userService.insertSelective(user) > 0){
            SettingStore store = new SettingStore();
            store.setId(snowflakeIdWorker.nextId());
            UcenterUser login = userService.initStore(user,store);
            login.setPassword("");
            session.setAttribute("user",login);
            CookieUtil.setCookie(response,"isLogin","true");
            mv.setViewName("index");
            return JSONResult.ok();
        }
        return JSONResult.ok();
    }

    /**
     * 登录
     * Title: login
     * params: [user] 用户名和密码
     * return: ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/15 0015 下午 4:26
     */
    @RequestMapping("login")
    public ModelAndView login(UcenterUser user){
        Result result=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"用户名"))
                .on(user.getPassword(),new StringValidator("密码")).doValidate().result(toSimple());
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
        if(!result.isSuccess()){
            mv.addObject("msg",result.getErrors());
            mv.setViewName("login");
            return mv;
        }
        if(userService.findUserByUsername(user.getUsername()) !=1){
            mv.addObject("msg","用户名不存在");
            mv.setViewName("login");
            return mv;
        }
        user.setPassword(AESUtil.AESEncode(user.getPassword()));
        UcenterUser userLogin = userService.login(user);
        if(userLogin == null){
            mv.addObject("msg","用户名或密码错误！");
            mv.setViewName("login");
            return mv;
        }

        userFameService.addFameValue(userLogin.getUserId(),1);
        //CookieUtil.setCookie(response,"isLogin",String.valueOf(userLogin.getUserId()));
        userLogin.setPassword("");
        session.setAttribute("user",userLogin);
        CookieUtil.setCookie(response,"isLogin","true");
        mv.setViewName("index");
        return mv;
    }
    @PostMapping("login")
    @ResponseBody
    public JSONResult userLogin(UcenterUser user){
        Result result=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"用户名"))
                .on(user.getPassword(),new StringValidator("密码")).doValidate().result(toSimple());
        ComplexResult complexResult=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().result(toComplex());
        String string=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().toString();
        ComplexResult2 complexResult2=FluentValidator.checkAll().on(user.getUsername(),new StringValidator(0,11,"username"))
                .on(user.getPassword(),new StringValidator("password")).doValidate().result(toComplex2());
        if(!result.isSuccess()){
            mv.addObject("msg",result.getErrors());
            mv.setViewName("login");
            return JSONResult.error("error",300,null);
        }
        if(userService.findUserByUsername(user.getUsername()) !=1){
            return JSONResult.error("用户名不存在",300,null);
        }
        user.setPassword(AESUtil.AESEncode(user.getPassword()));
        UcenterUser userLogin = userService.login(user);
        if(userLogin == null){
            return JSONResult.error("用户名或密码错误！",300,null);
        }

        userFameService.addFameValue(userLogin.getUserId(),1);
        //CookieUtil.setCookie(response,"isLogin",String.valueOf(userLogin.getUserId()));
        userLogin.setPassword("");
        session.setAttribute("user",userLogin);
        CookieUtil.setCookie(response,"isLogin","true");
        return JSONResult.ok();
    }
    /**
     * 更新用户信息
     * @title: updateUser
     * @author flyhero <http://www.iflyapi.cn>
     * @params [user]
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/1/15 下午11:33
     */
    @PostMapping("info")
    @ResponseBody
    public JSONResult updateUser(UcenterUser user){
        UcenterUser user1 = (UcenterUser) currentUser();
        if(user1 == null){
            return JSONResult.error("用户未登录");
        }
        user.setUserId(user1.getUserId());
        int num = userService.updateByPrimaryKeySelective(user);
        return num > 0 ? JSONResult.ok() : JSONResult.error();
    }

    /**
     * 修改密码
     * @title: updateUserPassword
     * @param passwordDto
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/4 下午1:08
     */
    @PostMapping("pass")
    @ResponseBody
    public JSONResult updateUserPassword(PasswordDto passwordDto){
        UcenterUser user = (UcenterUser) currentUser();
        if(user == null || !user.getPassword().equals(AESUtil.AESEncode(passwordDto.getNowpass().trim()))){
            return JSONResult.error("密码不正确");
        }
        UcenterUser user1 = new UcenterUser();
        user1.setUserId(user.getUserId());
        user1.setPassword(AESUtil.AESEncode(passwordDto.getNowpass().trim()));
        int num = userService.updateByPrimaryKeySelective(user1);
        return num > 0 ? JSONResult.ok() : JSONResult.error();
    }
    /**
     * 退出
     * Title: logout
     * params: []
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/19 0019 下午 3:55
     */
    @RequestMapping("logout")
    public ModelAndView logout(){
        session.removeAttribute("user");
//        CookieUtil.delCookie(response,"isLogin");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("set")
    public ModelAndView setInfo(){
        System.out.println("==========user/set");
        UcenterUser currentUser = (UcenterUser)currentUser();
        UcenterUser user=userService.selectByPrimaryKey(currentUser.getUserId());
        SettingStore settingStore = settingStoreService.selectByPrimaryKey(currentUser.getUserId());
        user.setPassword("");
        mv.addObject("setInfo",user);
        mv.addObject("settingStore",settingStore);
        mv.setViewName("/user/set");
        return mv;
    }
    @GetMapping("message")
    public ModelAndView message(){
        System.out.println("==========user/message");
        UcenterUser currentUser = (UcenterUser)currentUser();
        List<SysNotice> noticeList = noticeService.findNoticeByUserId(currentUser.getUserId());

        List<CommentVo> commentVoList = commentService.findCommentByAuthorId(currentUser.getUserId());

        mv.addObject("sysNoticeList",noticeList);
        mv.addObject("commentVoList",commentVoList);
        mv.setViewName("/user/message");
        return mv;
    }

    /**
     *
     * @title: userIndex
     * @author flyhero <http://www.iflyapi.cn>
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * @date 2018/1/30 上午12:10
     */
    @GetMapping("index")
    public ModelAndView userIndex(){
        UcenterUser currentUser = (UcenterUser)currentUser();
        List<CmsSubject> subjectList =null;
        try {
            subjectList = subjectService.findUserSubject(currentUser.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("subjectList",subjectList);
        mv.setViewName("/user/index");
        return mv;
    }

    @GetMapping("{userId}")
    public ModelAndView space(@PathVariable Long userId){
        System.out.println("==========user/set");
        UcenterUser user=userService.selectByPrimaryKey(userId);
        UcenterFame fame =fameService.findByFameValue(user.getFameValue());
        List<ActiveVo> activeVos=userFameService.findActive(userId);
        List<ViewLevelVo> levelVos = articleService.findViewLevel(userId);
        List<OpenSource> sourceList = openSourceService.findAll(userId);
        List<CmsArticle> hotArticleList = articleService.findHotArticlesByUserId(userId);
        List<CmsArticle> lastArticleList = articleService.findLastUpdateArticlesByUserId(userId);
        user.setPassword("");
        mv.addObject("fame",fame);
        mv.addObject("setInfo",user);
        mv.addObject("activeVos",activeVos);
        mv.addObject("levelVos",levelVos);
        mv.addObject("sourceList",sourceList);
        mv.addObject("hotArticleList",hotArticleList);
        mv.addObject("lastArticleList",lastArticleList);
        mv.setViewName("user/home");
        return mv;
    }


}
