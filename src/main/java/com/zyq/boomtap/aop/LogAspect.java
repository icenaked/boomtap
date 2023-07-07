package com.zyq.boomtap.aop;


import com.alibaba.fastjson.JSONObject;
import com.zyq.boomtap.mapper.OperateLogMapper;
import com.zyq.boomtap.model.po.OperateLog;
import com.zyq.boomtap.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    OperateLogMapper operateLogMapper;

    //只有在方法上加@Log注解才会用到此aop类
    @Around("@annotation(com.zyq.boomtap.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法
        Object returnResult = proceedingJoinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();

        //从jwt得到用户id
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer operateUserId = (Integer) claims.get("id");

        //得到其他信息
        LocalDateTime now = LocalDateTime.now();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        String returnValue = JSONObject.toJSONString(returnResult);
        Long costTime = end-begin;

        //创建OperateLog对象并存入数据库
        OperateLog operateLog = new OperateLog(null,operateUserId,now,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        return returnResult;
    }
}
