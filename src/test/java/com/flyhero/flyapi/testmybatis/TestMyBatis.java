package com.flyhero.flyapi.testmybatis;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.service.IModuleService;
import com.flyhero.flyapi.service.IUserProjectService;
import com.flyhero.flyapi.service.IUserService;
import com.flyhero.flyapi.utils.Md5Util;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  

    @Autowired
    private IUserService userService;
	@Autowired
	private IUserProjectService userProjectService;
	@Autowired
	private IModuleService moduleService;
    @Test
    public void test1(){
        User user=userService.findById(1);
        System.out.println(user.toString());
        logger.debug(user.toString());
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setUserId(1);
        System.out.println(userService.updateLoginCount(user));
    }
    @Test
    public void testPw(){
    	System.out.println(Md5Util.textToMD5L16("123456"));
    }
    @Test
    public void testProject(){
		List<UserProject> list=userProjectService.selectMyProject(2);
		for(UserProject u:list){
			System.out.println(u.getProject().getCreateTime());
		}
			System.out.println(JSONObject.toJSONString(list));
    }
    @Test
	public void testModule(){
		System.out.println(); 
		List<Module> list=moduleService.selectByProjectId(1);
		System.out.println(JSONObject.toJSONString(list));
	}
}  