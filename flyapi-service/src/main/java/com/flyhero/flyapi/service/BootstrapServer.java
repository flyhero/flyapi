package com.flyhero.flyapi.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动
 *
 */
public class BootstrapServer 
{
	private static Logger logger=Logger.getLogger(BootstrapServer.class);
    public static void main( String[] args )
    {
    	logger.info("=====================flyapi-service 正在启动=========================");
		new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
		logger.info("=====================flyapi-service 启动完成=========================");
    }
}
