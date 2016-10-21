package com.flyhero.flyapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.service.IModuleService;

@Controller
@RequestMapping("module")
public class ModuleController extends BaseController{

	@Autowired
	private IModuleService moduleService;
	
	@RequestMapping("addModule.do")
	@ResponseBody
	public JSONObject addModule(Module module){
		int flag=moduleService.insertSelective(module);
		if(flag != 0){
			json.put("msg", "success");
			return json;
		}
		json.put("msg", "error");
		return json;
	}
}
