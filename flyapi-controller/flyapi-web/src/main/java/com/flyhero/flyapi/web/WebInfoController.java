package com.flyhero.flyapi.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.WebInfo;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.impl.WebInfoServiceImpl;
import com.flyhero.flyapi.utils.Constant;

@Controller
@RequestMapping("webinfo")
public class WebInfoController extends BaseController{

	Logger logger=Logger.getLogger(WebInfoController.class);
	@Autowired
	private WebInfoServiceImpl webInfoService;
	
	/**
	 * 根据语言获取web信息
	 * @Title: findWebInfo 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年12月19日 上午11:24:13 
	 * @param @param language zh or en
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findWebInfo.do")
	public JSONResult findWebInfo(String language){
		List<WebInfo> webInfolList;
		try {
			webInfolList=webInfoService.findAllByLanguage(language);
		} catch (Exception e) {
			logger.error("根据语言获取web信息出错",e);
			return JSONResult.error();
		}
		return JSONResult.ok(webInfolList);
	}
}
