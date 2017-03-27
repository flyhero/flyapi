package com.flyhero.flyapi.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSON;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.pojo.Message;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ModuleService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.websocket.SystemWebSocketHandler;

/**
 * 项目模块控制器
 * @ClassName: ModuleController 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月7日 下午3:34:34 
 *
 */
@Controller
@RequestMapping("module")
public class ModuleController extends BaseController{

	Logger logger=Logger.getLogger(ModuleController.class);
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private LogService LogService;
	@Autowired
	private UserProjectService userProjectService;
	@Resource
	private SystemWebSocketHandler handler;
	/**
	 * 添加模块
	 * @Title: addModule  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月10日 下午12:20:47 
	 * @param @param module
	 * @param @return    
	 * @return JSONResult    返回类型 
	 */
	@RequestMapping("addModule.do")
	@ResponseBody
	public JSONResult addModule(Module module){
			try {
				User user=getCuUser();
				moduleService.addModule(module,user);
				UserProject up=new UserProject();
				up.setUserId(getCuUser().getUserId());
				up.setProjectId(module.getProjectId());
				List<TeamMemberPojo>  list=userProjectService.findTeamMembers(up);
				Message msg = new Message(-1L, "系统广播", 0L,1, user.getUserName()+"新建："+module.getModuleName()+"模块", new Date());
				handler.sendMessageToTeam(list, new TextMessage(JSON.toJSONString(msg)));
			} catch (IOException e) {
				logger.error("添加模块",e);
				return JSONResult.error();
			}
		return JSONResult.ok();
	}
	
	/**
	 * 删除模块
	 * @Title: deleteModule  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月10日 下午1:10:00 
	 * @param @param module
	 * @param @return    
	 * @return JSONResult    返回类型 
	 */
	@RequestMapping("deleteModule.do")
	@ResponseBody
	public JSONResult deleteModule(Module module){
		try {
			int flag=moduleService.updateByPrimaryKeySelective(module);
		} catch (Exception e) {
			logger.error("deleteModule出错：",e);
			return JSONResult.error();
		}
		
		return JSONResult.ok();
	}
	
	/**
	 * 更新模块
	 * @Title: updateModule  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月10日 下午1:28:08 
	 * @param @param module
	 * @param @return    
	 * @return JSONResult    返回类型 
	 */
	@RequestMapping("updateModule.do")
	@ResponseBody
	public JSONResult updateModule(Module module){
		try {
			int flag=moduleService.updateByPrimaryKeySelective(module);
		} catch (Exception e) {
			logger.error("updateModule出错：",e);
			return JSONResult.error();
		}
		
		return JSONResult.ok();
	}
	
	/**
	 * 获取项目模块
	 * @Title: findModule  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月10日 下午1:33:38 
	 * @param @param module
	 * @param @return    
	 * @return JSONResult    返回类型 
	 */
	@RequestMapping("findModule.do")
	@ResponseBody
	public JSONResult findModule(Module module){
		List<Module> list = null;
		try {
			list=moduleService.findModule(module.getProjectId());
		} catch (Exception e) {
			logger.error("findModule出错：",e);
			return JSONResult.error();
		}
		
		return JSONResult.ok(list);
	}
	
}
