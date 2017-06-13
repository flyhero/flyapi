package com.flyapi.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author: flyhero
 * Date: 2017/6/12 0012 下午 4:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class WebTest {
    Logger logger = LogManager.getLogger(WebTest.class);
    @Test
    public void logTest(){
        logger.info("haha");
        logger.debug("wang");
        logger.error("error");
        logger.warn("warn");
    }
}
