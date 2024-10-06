package com.abit.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(2)
public class SecondAspect {
    public Object addLoggingAround(ProceedingJoinPoint joinPoint, Object service, Object id) throws Throwable {
        log.info("AROUND before - invoke findById method in class {}, with id {}", service, id);
        try {
            Object result = joinPoint.proceed();
            log.info("AROUND afterReturning - invoke findById method in class {}, with id {}", service, result);
            return result;
        } catch (Throwable ex) {
            log.info("AROUND afterThrowing - invoke findById method in class {}, with id {}", service, ex.getClass());
            throw ex;
        } finally {
            log.info("AROUND after(finally) - invoke findById method in class {}", service);
        }
    }
}