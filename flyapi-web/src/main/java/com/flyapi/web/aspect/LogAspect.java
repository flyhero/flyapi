package com.flyapi.web.aspect;

import com.flyapi.core.util.IPUtil;
import com.flyapi.model.UcenterLog;
import com.flyapi.model.UcenterUser;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

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
    //controller层切入点
    @Pointcut("@annotation(com.flyapi.core.annotation.EnableFlyapiLog)")
    public void controllerAspect() {
        System.out.println("========controllerAspect===========");
    }

    /**
     * 前置通知 用于拦截Controller层操作
     * @param joinPoint 切点
     */
    @Before("execution(* com.flyapi.web..*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
        System.out.println("前置通知");

    }

    @After("execution(* com.flyapi.web..*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("后置通知");

        endTime = System.currentTimeMillis();


        UcenterLog log = new UcenterLog();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        // 获取登陆用户信息
        UcenterUser manager = (UcenterUser) request.getSession().getAttribute(
                "currentManager");
        // 获取请求ip
        String ip = IPUtil.getIP(request);
        String uri = request.getRequestURI();
        String url = request.getContextPath();
        String method = request.getMethod();
        long spendTime = endTime - startTime;
        String ua = request.getHeader("User-Agent");
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
/*        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";
            }
        }*/
        try {
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "."
                    + joinPoint.getSignature().getName() + "()"));
            System.out.println("请求IP:" + ip);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setIp(ip);
            log.setParams(null);
            // 保存数据库
            System.out.println("=====前置通知结束=====");
        } catch (Exception e) {
            // 记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e);
        }

    }

}
