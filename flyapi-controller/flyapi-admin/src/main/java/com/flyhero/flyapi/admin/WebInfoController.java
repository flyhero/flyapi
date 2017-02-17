package com.flyhero.flyapi.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.WebInfo;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.WebInfoService;
import com.flyhero.flyapi.utils.Constant;

@Controller
@RequestMapping("webinfo")
public class WebInfoController extends BaseController{

	@Autowired
	private WebInfoService webInfoService;
	
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
			return new JSONResult(Constant.MSG_OK, Constant.CODE_500);
		}
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, webInfolList);
	}
}
