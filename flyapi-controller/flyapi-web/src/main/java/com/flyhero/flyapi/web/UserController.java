package com.flyhero.flyapi.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.impl.ModuleServiceImpl;
import com.flyhero.flyapi.service.impl.ProjectServiceImpl;
import com.flyhero.flyapi.service.impl.UserProjectServiceImpl;
import com.flyhero.flyapi.service.impl.UserServiceImpl;
import com.flyhero.flyapi.service.impl.InterfaceServiceImpl;
import com.flyhero.flyapi.utils.Constant;
import com.flyhero.flyapi.utils.IPAddressUtil;
import com.flyhero.flyapi.utils.Md5Util;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器
 * 
 * @ClassName: UserController
 * @author flyhero(http://flyhero.top)
 * @date 2016年10月28日 下午5:50:47
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserProjectServiceImpl userProjectService;
	@Autowired
	private ModuleServiceImpl moduleService;
	@Autowired
	private InterfaceServiceImpl InterfaceService;
	@Autowired
	private ProjectServiceImpl projectService;

/*	
	   @Autowired  
	   private ProducerService producerService;  
	   @Autowired  
	   private Destination demoQueueDestination;  
	     
	   @RequestMapping("mq")
	   public void testSend() {  
	   	logger.info("this is a test");
	       for (int i=0; i<2; i++) {  
	           producerService.sendMessage(demoQueueDestination, "你好，生产者！这是消息：" + (i+1));  
	       }  
	   }  */
	/**
	 * restful
	 * @Title: get 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2017年3月1日 上午10:06:17 
	 * @param @param id
	 * @param @return   
	 * @return JSONResult    
	 */
	@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JSONResult get(@PathVariable("id") Integer id) {
		System.out.println("get" + id);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
	}
	/**
	 * 实际的登录代码
	 * 如果登录成功，跳转至首页；登录失败，则将失败信息反馈对用户
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dologin")
	public String doLogin(Model model) {
		String msg = "";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				return "redirect:/";
			} else {
				return "login";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
			System.out.println(msg);
		}
		return "login";
	}
	/**
	 * 用户注册
	 * 
	 * @Title: register
	 * @author flyhero
	 * @date 2016年10月12日
	 * @param @param user
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 */
	@RequestMapping(value = "register.do")
	@ResponseBody
	public JSONResult register(User user) throws Exception {
		try {
			String ip = IPAddressUtil.getIPAddr(request);
			user.setLoginIp(ip);
			user.setAddress(IPAddressUtil.getPosition(ip, "UTF-8"));
			user.setPassword(Md5Util.textToMD5L16(user.getPassword()));
			user.setCreateTime(new Date(System.currentTimeMillis()));
			user.setAvatarUrl("/static/images/head.jpg");
			int flag = userService.insertSelective(user);
			if (flag != 0) {
				userService.updateLoginCount(user);
				return JSONResult.ok();
			}
		} catch (Exception e) {
			logger.error("注册出错：", e);
			return JSONResult.error();
		}

		return JSONResult.ok();
	}

	/**
	 * 验证用户名是否存在
	 * 
	 * @Title: checkUserName
	 * @author flyhero
	 * @date 2016年10月12日
	 * @param @param user
	 * @param @return 参数
	 * @return JSONObject 返回类型
	 */
	@RequestMapping("checkUserName.do")
	@ResponseBody
	public JSONObject checkUserName(User user) {
		logger.info("正在验证用户:" + user.getUserName() + " 是否存在");
		User u = userService.findByUserName(user);
		if (u != null) {
			json.put("valid", false);
		} else {
			json.put("valid", true);
		}
		return json;
	}

	/**
	 * 用户登录
	 * 
	 * @Title: login
	 * @author flyhero
	 * @date 2016年10月12日
	 * @param @param user
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 */
	@RequestMapping(value = "login.do")
	public ModelAndView login(User user) throws Exception {
		if (getCuUser() != null) {
			return new ModelAndView("redirect:/forward/main.html");
		}

		user.setPassword(Md5Util.textToMD5L16(user.getPassword()));
		User user1 = userService.findByLogin(user);
		if (user1 != null) {
			userService.updateLoginCount(user1);
			session.setAttribute("user", user1);
			return new ModelAndView("redirect:/forward/main.html");
		}
		mv.setViewName("register");
		return mv;
	}

	/**
	 * 
	 * @Title: logout
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author flyhero
	 * @date 2016年10月12日下午5:56:57
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 */
	@RequestMapping(value = "logout.do")
	public String logout() throws Exception {
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping("goToModule.do")
	public ModelAndView goToModule(int projectId) {
		Project p = projectService.selectByPrimaryKey(projectId);
		UserProject up = new UserProject();
		User u = (User) session.getAttribute("user");
		up.setUserId(u.getUserId());
		up.setProjectId(projectId);
		UserProject up1 = userProjectService.selectByIdAndPro(up);
		mv.addObject("project", p);
		mv.addObject("up", up1);
		mv.setViewName("moduleList");
		return mv;
	}

	@RequestMapping("goToInterface.do")
	public ModelAndView goToInterface(int moduleId, int isEdit,
			String projectName) {
		String name = null;
		try {
			name = new String(projectName.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Module m = moduleService.selectByPrimaryKey(moduleId);
		mv.addObject("module", m);
		mv.addObject("isEdit", isEdit);
		mv.addObject("projectName", name);
		mv.setViewName("interfaceList");
		return mv;
	}

}
