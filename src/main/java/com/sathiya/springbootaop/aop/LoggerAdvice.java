package com.sathiya.springbootaop.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Sathiyaraj created on 05-02-2022
 * <p>
 * TODO
 */

@Aspect
@Component
public class LoggerAdvice {

    Logger log = LoggerFactory.getLogger(LoggerAdvice.class);

    @Pointcut(value = "execution(* com.sathiya.springbootaop.*.*.*(..))")
    public void loggerPointcut() {

    }

    @Around("loggerPointcut()")
    public Object loggerEntry(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();
        ObjectMapper mapper = new ObjectMapper();
        Object[] args = pjp.getArgs();
        log.info("Method Invoked " + className +" : " + methodName + "() arguments :" + mapper.writeValueAsString(args));
        Object resp = pjp.proceed();
        log.info("Method Invoked " + className +" : " + methodName + "() arguments :" + mapper.writeValueAsString(resp));
        return resp;
    }
}
