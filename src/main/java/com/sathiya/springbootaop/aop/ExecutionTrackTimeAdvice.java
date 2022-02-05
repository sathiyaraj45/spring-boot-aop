package com.sathiya.springbootaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class ExecutionTrackTimeAdvice {

    Logger log = LoggerFactory.getLogger(ExecutionTrackTimeAdvice.class);

    @Around("@annotation(com.sathiya.springbootaop.aop.TrackExecutionTime)")
    public Object MethodExecutionTimeTrack(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object resp = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Method execution time ==>"+ (endTime - startTime));
        return resp;
    }
}
