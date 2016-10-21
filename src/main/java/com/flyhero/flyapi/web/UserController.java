package com.flyhero.flyapi.web;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flyhero.flyapi.pojo.Test;
import com.flyhero.flyapi.service.IInterfaceService;
import com.flyhero.flyapi.service.IModuleService;
import com.flyhero.flyapi.service.IProjectService;
import com.flyhero.flyapi.service.IUserProjectService;
import com.flyhero.flyapi.service.IUserService;
import com.flyhero.flyapi.service.impl.InterfaceService;
import com.flyhero.flyapi.utils.IPAddressUtil;
import com.flyhero.flyapi.utils.Md5Util;
import com.flyhero.flyapi.entity.Interface;
import com.flyhero.flyapi.entity.InterfaceWithBLOBs;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IUserProjectService userProjectService;
	@Autowired
	private IModuleService moduleService;
	@Autowired
	private IInterfaceService InterfaceService;
	@Autowired
	private IProjectService projectService;
	/**
	 * 前往主页
	 * @Title: main
	 * @author flyhero
	 * @date 2016年10月15日上午10:41:44
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("main.do")
	public String main() {
		return "main";
	}
	/**
	 * 前往登录页
	 * @Title: gotoLogin
	 * @author flyhero
	 * @date 2016年10月20日下午2:58:21
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("gotoLogin.do")
	public String gotoLogin() {
		return "login";
	}
	/**
	 * 前往注册页
	 * @Title: goToRegister
	 * @author flyhero
	 * @date 2016年10月11日上午10:42:02
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("gotoRegister.do")
	public String goToRegister() {
		return "register";
	}
	@RequestMapping("projectList.do")
	public String projectList() {
		return "projectList";
	}
	@RequestMapping("test2.do")
	public ModelAndView test2() {
		Test t= new Test();
		t.setDate(new Date());
		mv.addObject("d", t);
		mv.setViewName("test");
		return mv;
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
	 * @throws
	 */
	@RequestMapping(value = "register.do")
	public String register(User user) throws Exception {
		user.setLoginIp(IPAddressUtil.getIPAddr(request));
		user.setUserPw(Md5Util.textToMD5L16(user.getUserPw()));
		user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		int flag = userService.insertSelective(user);
		if (flag != 0) {
			userService.updateLoginCount(user);
			return "main";
		}
		return "error";
	}

	/**
	 * 验证用户名是否存在
	 * 
	 * @Title: validUserName
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author flyhero
	 * @date 2016年10月12日
	 * @param @param user
	 * @param @return 参数
	 * @return JSONObject 返回类型
	 * @throws
	 */
	@RequestMapping("validUserName.do")
	@ResponseBody
	public JSONObject validUserName(User user) {
		System.out.println("正在验证用户是否存在！"+user.getUserName());
		User u=userService.findByUserName(user);
		if(u != null){
			json.put("valid", false);
		}else{
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
	 * @throws
	 */
	@RequestMapping(value = "login.do")
	public ModelAndView login(User user) throws Exception {
		user.setUserPw(Md5Util.textToMD5L16(user.getUserPw()));
		User user1 = userService.findByLogin(user);
		if (user1 != null) {
			userService.updateLoginCount(user1);
/*			User u=new User();
			u.setUserId(user1.getUserId());
			u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			userService.updateLoginTime(u);*/
			session.setAttribute("user", user1);
			mv.addObject("u", user1);
			mv.setViewName("main");
			return mv;
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
	 * @throws
	 */
	@RequestMapping(value = "logout.do")
	public String logout() throws Exception {
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping("getMyProject.do")
	@ResponseBody
	public List<UserProject> getMyProject(int userId){
		List<UserProject> list=userProjectService.selectMyProject(userId);
		return list;
	}
	@RequestMapping("goToModule.do")
	public ModelAndView goToModule(int projectId){
		Project p=projectService.selectByPrimaryKey(projectId);
		UserProject up= new UserProject();
		User u=(User) session.getAttribute("user");
		up.setUserId(u.getUserId());
		up.setProjectId(projectId);
		System.out.println(up.toString());
		UserProject up1=userProjectService.selectByIdAndPro(up);
		mv.addObject("project", p);
		mv.addObject("up", up1);
		mv.setViewName("moduleList");
		return mv;
	}
	@RequestMapping("getModuleByprojectId.do")
	@ResponseBody
	public List<Module> getModuleByprojectId(int projectId){
		return moduleService.selectByProjectId(projectId);
	}
	@RequestMapping("goToInterface.do")
	public ModelAndView goToInterface(int moduleId,int isEdit,String projectName){
		String name = null;
		try {
			name = new String(projectName.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Module m=moduleService.selectByPrimaryKey(moduleId);
		mv.addObject("module", m);
		mv.addObject("isEdit", isEdit);
		mv.addObject("projectName", name);
		mv.setViewName("interfaceList");
		return mv;
	}
	
	@RequestMapping("goToInterfaceDetail.do")
	public ModelAndView goToInterfaceDetail(int interfaceId){
		InterfaceWithBLOBs in= InterfaceService.selectByPrimaryKey(interfaceId);
		mv.addObject("interface1", in);
		mv.setViewName("interfaceDetial");
		return mv;
	}
	@RequestMapping("getInterfaceByModuleId.do")
	@ResponseBody
	public List<Interface> getInterfaceByModuleId(int moduleId){
		return InterfaceService.selectByModuleId(moduleId);
	}


}
