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

@Controller
@RequestMapping("webinfo")
public class WebInfoController extends BaseController{

	Logger logger=Logger.getLogger(WebInfoController.class);
	@Autowired
	private WebInfoServiceImpl webInfoService;
	
	/**
	 * 根据语言获取web信息
	 * @Title: findWebInfo
	 * @date 2017年3月27日 下午2:57:47 
	 * @author flyhero(http://flyhero.top)
	 * @param language
	 * @return
	 * @return: JSONResult
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
