package com.flyhero.flyapi.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.service.IProjectService;
import com.flyhero.flyapi.service.IUserProjectService;
import com.flyhero.flyapi.service.IUserService;

@Controller
@RequestMapping("project")
public class ProjectController extends BaseController{

	@Autowired
	private IProjectService projectService;
	@Autowired
	private IUserProjectService userProjectService;
	@Autowired
	private IUserService userService;
	
	@RequestMapping("addProject.do")
	@ResponseBody
	public JSONObject addProject(Project project){
		int flag=projectService.insertSelective(project);
		if(flag>0){
			UserProject record=new UserProject();
			User u=(User)session.getAttribute("user");
			if(u != null && u.getUserId() !=null){
				record.setProjectId(project.getProjectId());
				record.setUserId(u.getUserId());
				userProjectService.insertSelective(record);
				json.put("msg", "success");
				return json;
			}

		}
		json.put("msg", "error");
		return json;
	}
	@RequestMapping("updateProject.do")
	@ResponseBody
	public JSONObject updateProject(Project project){

		int flag=projectService.updateByPrimaryKeySelective(project);
		if(flag>0){
			json.put("msg", "success");
		}else{
			json.put("msg", "error");
		}
		return json;
	}
	@RequestMapping("addActor.do")
	@ResponseBody
	public JSONObject addActor(String userName,Integer projectId,int isEdit){
		User u1=new User();
		u1.setUserName(userName);
		User u=userService.findByUserName(u1);
		UserProject up=new UserProject();
		up.setUserId(u.getUserId());
		up.setProjectId(projectId);
		up.setIsEdit(isEdit);
		up.setCreateTime(new Timestamp(System.currentTimeMillis()));
		int flag=userProjectService.insertSelective(up);
		if(flag>0){
			json.put("msg", "success");
		}else{
			json.put("msg", "error");
		}
		return json;
	}
}
