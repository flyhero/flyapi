package com.flyhero.flyapi.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.utils.Constant;
import com.github.pagehelper.PageInfo;

/**
 * 操作日志控制器
 * @ClassName: LogController 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月15日 下午2:30:08 
 *
 */
@Controller
@RequestMapping("log")
public class LogController extends BaseController{

	@Autowired
	private LogService logService;
	
	@RequestMapping("findLog.do")
	@ResponseBody
	public JSONResult findLogByProjectId(Integer projectId){
		Map<String, Object> map=logService.findLog(projectId);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, map);
	}
	
	/**
	 * 获取日志详情根据项目号
	 * @Title: findLogDetialByProId 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月23日 上午11:14:51 
	 * @param @param projectId
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findLogDetial.do")
	public JSONResult findLogDetialByProId(Integer projectId){
		List<OperateLog> list=logService.findLogDetialByProId(projectId);
		if(list != null &&list.isEmpty()){
			return new JSONResult(Constant.MSG_OK, Constant.CODE_404, list);	
		}
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
	}
	/**
	 * 
	 * @Title: findAllLogByUserId 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月23日 下午5:15:36 
	 * @param @param userId
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findAllLog.do")
	public JSONResult findAllLogByUserId(Integer userId,Integer pageNumber,Integer pageSize){
		PageInfo<OperateLog> list=logService.findAllLogByUserId(userId,pageNumber,pageSize);
		Map<String, Object> map=new HashMap<String, Object>();
		if(list != null ){
			map.put("rows", list.getList());
			map.put("total", list.getTotal());
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);	
		}
		return new JSONResult(Constant.MSG_OK, Constant.CODE_404, list);
	}
}
