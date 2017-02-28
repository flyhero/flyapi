package com.flyhero.flyapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.Version;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.VersionService;
import com.flyhero.flyapi.utils.Constant;
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

	@Autowired
	private VersionService versionService;
	
	/**
	 * 获取版本日志
	 * @Title: findVersionLog 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2017年2月27日 下午4:35:10 
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findVersionLog.do")
	public JSONResult findVersionLog(){
		List<Version> versionList=null;
		try {
			versionList=versionService.findVersionLog();
		} catch (Exception e) {
			return new JSONResult(Constant.MSG_OK, Constant.CODE_500);
		}
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, versionList);
	}
}
