package com.zyq.boomtap.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    //aop应用到哪些方法上,这里是service包里所有类的所有方法
    @Around("execution(* com.zyq.boomtap.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法
        Object returnResult = proceedingJoinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        log.info("方法"+proceedingJoinPoint.getSignature()+"耗时:{}ms", end - begin);

        return returnResult;
    }
}
