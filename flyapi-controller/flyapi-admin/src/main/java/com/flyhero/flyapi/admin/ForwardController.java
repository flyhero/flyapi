package com.flyhero.flyapi.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("forward")
public class ForwardController extends BaseController{

	/**
	 * 前往注册页
	 * @Title: goToRegister
	 * @author flyhero
	 * @date 2016年10月11日上午10:42:02
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("register.html")
	public String goToRegister() {
		return "register";
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
	@RequestMapping("login.html")
	public String gotoLogin() {
		return "login";
	}
	@RequestMapping("main.html")
	public String gotoMain(){
		System.out.println("★★★★★★★★★★★");
		return "main";
	}
	@RequestMapping("index_main.html")
	public String gotoIndexMain(){
		return "index_main";
	}
	@RequestMapping("druid.html")
	public String gotoDruid(){
		return "druid";
	}
	@RequestMapping("projects.html")
	public String gotoProject(){
		return "projects";
	}
	@RequestMapping("newProject.html")
	public String newProjects(){
		return "new_project";
	}
	
	@RequestMapping("listCreatedProject.html")
	public String gotoCreatedProject(){
		return "list_createdproject";
	}
	@RequestMapping("listJoinProject.html")
	public String gotoJoinProject(){
		return "list_joinproject";
	}
	@RequestMapping("project_detail.html")
	public ModelAndView gotoProjectDetail(Integer projectId,Integer upId,int isEdit){
		mv.addObject("projectId", projectId);
		mv.addObject("upId", upId);
		mv.addObject("isEdit", isEdit);
		mv.setViewName("detail_project");
		return mv;
	}
	@RequestMapping("demo.html")
	public String gotoDemo1(){
		return "demo";
	}
	@RequestMapping("new_interfaces.html")
	public String gotoDemo(){
		return "new_interfaces";
	}
	@RequestMapping("data_base.html")
	public String gotoDataBase(){
		return "list_database";
	}
	
	@RequestMapping("new_database.html")
	public String gotoNewDataBase(){
		return "new_database";
	}
	@RequestMapping("detail_interface.html")
	public ModelAndView gotoDetial(Integer interfaceId){
		mv.addObject("interfaceId", interfaceId);
		mv.setViewName("detail_interface");
		return mv;
	}
	@RequestMapping("list_interfaces.html")
	public ModelAndView gotoListInterfaces(Integer projectId){
		mv.addObject("projectId", projectId);
		mv.setViewName("list_interfaces");
		return mv;
	}
	
	@RequestMapping("detail_tableinfo.html")
	public ModelAndView gotoTableinfo(Integer dbId){
		mv.addObject("dbId", dbId);
		mv.setViewName("detail_tableinfo");
		return mv;
	}
	
	@RequestMapping("goto.html")
	public ModelAndView gotoJsp(String name){
		mv.setViewName(name);
		return mv;
	}
	
	@RequestMapping("debug_interface.html")
	public ModelAndView gotoDebugInter(Integer interfaceId){
		mv.addObject("interfaceId", interfaceId);
		mv.setViewName("debug_interface");
		return mv;
	}
}
