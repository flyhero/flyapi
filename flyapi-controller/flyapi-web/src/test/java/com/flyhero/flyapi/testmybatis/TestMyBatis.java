package com.flyhero.flyapi.testmybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.utils.DocUtil;
import com.flyhero.flyapi.utils.Md5Util;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.flyhero.flyapi.service.InterfaceService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.service.UserService;
import com.github.pagehelper.PageInfo;
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  

   @Autowired
   private UserService userService;
   @Autowired
   private UserProjectService userProjectService;
   @Autowired
   private InterfaceService interfaceService;
   @Test
   public void testPage(){
	   PageInfo<User> pageInfo= userService.queryByPage(1, 10);
	   System.out.println(JSON.toJSONString(pageInfo));
   }
   
   @Test
   public void testPU(){
	   List<UserProject> list=userProjectService.findUserProject(1);
	   for(UserProject up:list){
		   System.out.println(up.toString());
	   }
   }
   @Test
   public void testInter(){
   }
   
/*	@Autowired
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
//			System.out.println(u.getProject().getCreateTime());
		}
			System.out.println(JSONObject.toJSONString(list));
    }
    @Test
	public void testModule(){
		System.out.println(); 
		List<Module> list=moduleService.selectByProjectId(1);
		System.out.println(JSONObject.toJSONString(list));
	}*/
}  