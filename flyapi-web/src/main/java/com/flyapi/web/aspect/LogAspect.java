package com.flyapi.web.aspect;

import com.alibaba.fastjson.JSON;
import com.flyapi.core.annotation.EnableFlyapiLog;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.core.util.IPUtil;
import com.flyapi.model.UcenterLog;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.LogService;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * author: flyhero
 * Date: 2017/5/15 0015 下午 6:36
 */
@Component
@Aspect
public class LogAspect {

    Logger logger = LogManager.getLogger(LogAspect.class);

    private long startTime = 0L;
    private long endTime = 0L;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private LogService logService;
    //controller层切入点
    @Pointcut("@annotation(com.flyapi.core.annotation.EnableFlyapiLog)")
    public void controllerAspect() {
        System.out.println("========controllerAspect===========");
    }

    /**
     * 前置通知 用于拦截Controller层操作
     *
     * @param joinPoint 切点
     */
    @Before("execution(* com.flyapi.web.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();

    }

    @After("execution(* com.flyapi.web.controller..*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        endTime = System.currentTimeMillis();

        UcenterUser user = null;

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        user = (UcenterUser) request.getSession().getAttribute("user");

        String username = "未登录用户";
        if (user != null) {
            username = user.getUsername();
        }
        String basePath =request.getRemoteHost()+":"+request.getLocalPort();
        String ip = IPUtil.getIP(request);
        String uri = request.getRequestURI();
        String url = basePath+uri;
        String method = request.getMethod();
        int spendTime = (int)(endTime - startTime);
        String ua = request.getHeader("User-Agent");
        //获取用户请求方法的参数并序列化为JSON格式字符串
        HashMap<String, String> requestParams = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            requestParams.put(paramName, paramValue);
        }
        String params = JSON.toJSONString(requestParams);


        String description = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()";
        UcenterLog log = new UcenterLog(snowflakeIdWorker.nextId(),username,description,new Date(),spendTime,basePath,uri,url,method,params,ua,ip);
        System.out.println(log.toString());

        logService.insertSelective(log);
    }

    /**
     * 获取方法注解中的描述
     * @title: getMthodRemark
     * @author qfwang
     * @params [joinPoint]
     * @return java.lang.String
     * @date 2017/11/25 下午3:51
     */
    public static String getMthodRemark(JoinPoint joinPoint) throws Exception {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System. out.println("====调用" +methodName+"方法-开始！");
        Object[] arguments = joinPoint.getArgs();   //获得参数列表
        System.out.println("打印出方法调用时传入的参数，可以在这里通过添加参数的类型，进行一些简易逻辑处理和判断");
        if(arguments.length<=0){
            System.out.println("=== "+methodName+" 方法没有参数");
        }else{
            for(int i=0;i<arguments.length;i++){
                System.out.println("==== 参数   "+(i+1)+" : "+arguments[i]);
            }
        }

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String description = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    EnableFlyapiLog methodCache = m.getAnnotation(EnableFlyapiLog.class);
                    description = methodCache.description();
                    break;
                }
            }
        }
        return description;
    }

}
