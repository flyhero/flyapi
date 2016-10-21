package com.flyhero.flyapi.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.InterfaceWithBLOBs;
import com.flyhero.flyapi.pojo.HttpResponse;
import com.flyhero.flyapi.service.IInterfaceService;
import com.flyhero.flyapi.utils.Constant;
import com.flyhero.flyapi.utils.HttpClientUtil;

@Controller
@RequestMapping("interface")
public class InterfaceController extends BaseController{

	@Autowired
	private IInterfaceService interfaceService;
	
	@RequestMapping("addInterface")
	@ResponseBody
	public JSONObject addInterface(InterfaceWithBLOBs interfaces){
		int flag=interfaceService.insertSelective(interfaces);
		if(flag != 0){
			json.put("msg", Constant.MSG_OK);
		}else{
			json.put("msg", Constant.MSG_ERROR);
		}
		return json;
		
	}
	
	@RequestMapping("testHttp.do")
	@ResponseBody
	public JSONObject testHttp(String method,String url,String param,int jsonWay){
		System.out.println("参数为"+param+"way:"+jsonWay);
		JSONObject  jsonget=HttpClientUtil.getUrl(method, url, param,jsonWay);
		HttpResponse hr=JSON.parseObject(jsonget.toString(), HttpResponse.class);
		System.out.println(hr.toString());
	       for (Map.Entry<String, Object> entry : jsonget.entrySet()) {
	            System.out.println(entry.getKey() + ":" + entry.getValue());
	        }
	    json.put("result", hr.getContent());
		json.put("msg", Constant.MSG_OK);
		return json;
	}
}
