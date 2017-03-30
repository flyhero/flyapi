package com.flyhero.flyapi.testmybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Destination;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/*import com.flyhero.flyapi.activemq.producer.ProducerService;
import com.flyhero.flyapi.activemq.topic.TopicService;*/
import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.entity.Module;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.service.InterfaceService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.service.UserService;
import com.flyhero.flyapi.service.impl.InterfaceServiceImpl;
import com.flyhero.flyapi.service.impl.UserProjectServiceImpl;
import com.flyhero.flyapi.service.impl.UserServiceImpl;
import com.flyhero.flyapi.utils.DocUtil;
import com.flyhero.flyapi.utils.Md5Util;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.util.Assert;

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
	   System.out.println("=====================");
	   Assert.isTrue(1 < 0, "请上传营业执照号电子版！");
	   System.out.println("=====================");
   }
   
/*   @Test
   public void testPU(){
	   List<UserProject> list=userProjectService.findUserProject(1);
	   for(UserProject up:list){
		   System.out.println(up.toString());
	   }
   }*/
/*   @Test
   public void testInter(){
	   int a= 0;
	   try {
		  a= userService.insert();
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	  System.out.println(a);
   }*/
   
/*   @Autowired  
   private ProducerService producerService;  
   @Autowired
   private TopicService topicService;
   @Autowired  
   @Qualifier("demoQueueDestination")  
   private Destination demoQueueDestination; 
   
   @Autowired  
   @Qualifier("flyTopicDestination")  
   private Destination flyTopicDestination;  
     
   @Test  
   public void testSend() {  
	   User user=new User();
	   user.setUserName("张三");
   		logger.info("this is a test");
       for (int i=0; i<2; i++) {  
           producerService.sendMessage(demoQueueDestination, "你好，生产者！这是消息：" + (i+1));  
       }  
       topicService.publish(flyTopicDestination,user);
   }  */
}  