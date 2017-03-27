package com.flyhero.flyapi.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.Version;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.impl.VersionServiceImpl;
/**
 * 版本控制器
 * @ClassName: VersionController 
 * @author flyhero(http://flyhero.top)
 * @date 2017年2月27日 下午3:26:43 
 *
 */
@Controller
@RequestMapping("version")
public class VersionController extends BaseController{

	Logger logger=Logger.getLogger(VersionController.class);
	@Autowired
	private VersionServiceImpl versionService;
	
	/**
	 * 获取版本日志
	 * @Title: findVersionLog 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2017年2月27日 下午4:35:10 
	 * @param @return   
	 * @return JSONResult    
	 */
	@ResponseBody
	@RequestMapping("findVersionLog.do")
	public JSONResult findVersionLog(){
		List<Version> versionList=null;
		try {
			versionList=versionService.findVersionLog();
		} catch (Exception e) {
			logger.error("获取版本日志出错",e);
			return JSONResult.error();
		}
		return JSONResult.ok(versionList);
	}
}
