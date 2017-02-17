package com.flyhero.flyapi.admin;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.entity.Project;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.pojo.ProjectDetailpojo;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ProjectService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.service.UserService;
import com.flyhero.flyapi.utils.Constant;
import com.github.pagehelper.PageInfo;
/**
 * 项目控制器
 * @ClassName: ProjectController 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月1日 下午5:38:30 
 *
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController{

	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserProjectService userProjectService;
	@Autowired
	private UserService userService;
	@Autowired
	private LogService LogService;
	
	/**
	 * 我创建的项目
	 * @Title: findUserCreate  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月3日 下午5:41:24 
	 * @param @param up
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	@RequestMapping("findUserCreate.do")
	@ResponseBody
	public JSONObject findUserCreate(UserProject up){
		PageInfo<UserProject> list=userProjectService.findUserCreate(up);
/*		OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), 0, Constant.TYPE_SELECT, Constant.CLASS_PROJECT, 
				Constant.NAME_PROJECT, "查询："+getCuUser().getUserName()+"创建的项目", JSONObject.toJSONString(up));
		LogService.addLog(log);*/
		if(list != null){
			json.put("total",list.getTotal());
			json.put("rows", list.getList());
			return json;
		}
		return null;
	}
	/**
	 * 我参与的项目
	 * @Title: findUserJoin  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月3日 下午6:42:30 
	 * @param @param up
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("findUserJoin.do")
	@ResponseBody
	public JSONObject findUserJoin(UserProject up){
		PageInfo<UserProject> list=userProjectService.findUserJoin(up);
/*		OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), 0, Constant.TYPE_SELECT, Constant.CLASS_PROJECT, 
				Constant.NAME_PROJECT, "查询："+getCuUser().getUserName()+"参与的项目", JSONObject.toJSONString(up));
		LogService.addLog(log);*/
		if(list != null){
			json.put("total",list.getTotal());
			json.put("rows", list.getList());
			return json;
		}
		return null;
	}
	/**
	 * 
	 * @Title: findUserProject  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月1日 下午5:43:21 
	 * @param @param userId
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("findUserProject.do")
	@ResponseBody
	public JSONResult findUserProject(Integer userId){
		List<UserProject> list=userProjectService.findUserProject(userId);
		if(list != null && !list.isEmpty()){
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
		}
		return null;
	}

	/**
	 * 获取用户拥有权限的项目
	 * @Title: findUserEdit  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月15日 下午5:16:19 
	 * @param @param userId
	 * @param @return    
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("findUserEdit.do")
	@ResponseBody
	public JSONResult findUserEdit(Integer userId){
		List<UserProject> list=userProjectService.findUserEdit(userId);
		if(list != null && !list.isEmpty()){
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200, list);
	}
	/**
	 * 新建项目
	 * @Title: addProject  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月5日 上午10:44:00 
	 * @param @param project
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("addProject.do")
	@ResponseBody
	public JSONResult addProject(Project project){
		int flag=projectService.insertSelective(project);
		System.out.println("id:"+project.getProjectId());
		if(flag>0){
			UserProject record=new UserProject();
			User u=(User)getCuUser();
			OperateLog log=new OperateLog(u.getUserId(),getCuUser().getUserName(), 0, Constant.TYPE_INSERT, Constant.CLASS_PROJECT, 
					Constant.NAME_PROJECT, "创建："+project.getProName()+"项目", JSONObject.toJSONString(project));
			LogService.addLog(log);
			if(u != null){
				record.setProjectId(project.getProjectId());
				record.setUserId(u.getUserId());
				record.setIsCreator(1);
				record.setIsEdit(1);
				record.setIsDelete(0);
				userProjectService.insertSelective(record);
				return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
			}

		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
	}
	/**
	 * 更新项目
	 * @Title: updateProject  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月7日 下午3:45:30 
	 * @param @param project
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("updateProject.do")
	@ResponseBody
	public JSONResult updateProject(Project project){

		int flag=projectService.updateByPrimaryKeySelective(project);
		if(flag>0){
			OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), project.getProjectId(), Constant.TYPE_UPDATE,
					Constant.CLASS_PROJECT, Constant.NAME_PROJECT, "更新："+project.getProName()+"项目", JSONObject.toJSONString(project));
			LogService.addLog(log);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
	}
	/**
	 * 项目详情
	 * @Title: findProjectDetail  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月8日 下午5:47:41 
	 * @param @param upId
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("findProjectDetail.do")
	@ResponseBody
	public JSONResult findProjectDetail(Integer upId){
		ProjectDetailpojo projectDetailpojo= projectService.findProjectDetail(upId);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200,projectDetailpojo);
	}
	/**
	 * 删除项目
	 * @Title: deleteProject  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月9日 下午5:46:21 
	 * @param @param project
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("deleteProject.do")
	@ResponseBody
	public JSONResult deleteProject(Project project){
		project.setIsDelete(1);
		UserProject uProject=new UserProject();
		uProject.setProjectId(project.getProjectId());
		int flag=projectService.updateByPrimaryKeySelective(project);
		int flag1=userProjectService.deleteUserProject(uProject);
		if(flag>0 && flag1>0){
			OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), project.getProjectId(), Constant.TYPE_DELETE,
					Constant.CLASS_PROJECT, Constant.NAME_PROJECT, "删除："+project.getProName()+"项目", JSONObject.toJSONString(project));
			LogService.addLog(log);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
	}
	
	/**
	 * 添加项目成员
	 * @Title: addMember  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月8日 下午4:20:07 
	 * @param @param userName
	 * @param @param projectId
	 * @param @param isEdit
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("addMember.do")
	@ResponseBody
	public JSONResult addMember(String userName,Integer projectId,int isEdit){
		User u1=new User();
		u1.setUserName(userName);
		User u=userService.findByUserName(u1);
		UserProject up=new UserProject();
		up.setUserId(u.getUserId());
		up.setProjectId(projectId);
		up.setIsEdit(isEdit);
		up.setIsCreator(0);
		int flag=userProjectService.insertSelective(up);
		if(flag>0){
			OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), projectId, Constant.TYPE_INSERT,
					Constant.CLASS_TEAM, Constant.NAME_TEAM, "添加：项目成员-"+userName, JSONObject.toJSONString(up));
			LogService.addLog(log);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
	}

	/**
	 * 查询项目成员
	 * @Title: findTeamMembers  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月8日 下午5:49:05 
	 * @param @param up
	 * @param @return    设定文件 
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("findTeamMembers.do")
	@ResponseBody
	public JSONResult findTeamMembers(UserProject up){
		List<TeamMemberPojo>  list=userProjectService.findTeamMembers(up);
		OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), up.getProjectId(), Constant.TYPE_SELECT,
				Constant.CLASS_TEAM, Constant.NAME_TEAM, "查询：项目成员", JSONObject.toJSONString(up));
		LogService.addLog(log);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
	}
	/**
	 * 删除团队成员
	 * @Title: deleteTeamMembers 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月29日 上午11:43:59 
	 * @param @param up
	 * @param @param name
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@RequestMapping("deleteTeamMembers.do")
	@ResponseBody
	public JSONResult deleteTeamMembers(UserProject up,String name){
		int flag=userProjectService.updateByPrimaryKeySelective(up);
		if(flag>0){
			OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), up.getProjectId(), Constant.TYPE_DELETE,
					Constant.CLASS_TEAM, Constant.NAME_TEAM, "删除："+name+"-成员", JSONObject.toJSONString(up));
			LogService.addLog(log);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
	}
	/**
	 * 更新成员权限
	 * @Title: updateMemberPermission  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月10日 上午11:00:52 
	 * @param @param up
	 * @param @param name
	 * @param @return    
	 * @return JSONResult    返回类型 
	 * @throws
	 */
	@RequestMapping("updateMemberPermission.do")
	@ResponseBody
	public JSONResult updateMemberPermission(UserProject up,String name){
		Integer id=up.getProjectId();
		up.setProjectId(null);
		int flag=userProjectService.updateByPrimaryKeySelective(up);
		if(flag>0){
			OperateLog log=new OperateLog(getCuUser().getUserId(),getCuUser().getUserName(), id, Constant.TYPE_UPDATE,
					Constant.CLASS_TEAM, Constant.NAME_TEAM, "更新："+name+"的权限", JSONObject.toJSONString(up));
			LogService.addLog(log);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);
		
	}
	/**
	 * 获取用户对某个项目的权限
	 * @Title: findUserIsEdit 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月24日 下午1:38:30 
	 * @param @param up
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findUserIsEdit.do")
	public JSONResult findUserIsEdit(UserProject up){
		up.setUserId(getCuUser().getUserId());
		int count=userProjectService.findUserIsEdit(up);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200,count);
		
	}
	
}
