package com.abit.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Aspect
@Component
public class FirstAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {

    }

    @Pointcut("within(com.abit.spring.service.*Service)")
    public void isServiceLayer() {

    }

    //@Pointcut("this(org.springframework.stereotype.Repository)")
    @Pointcut("target(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer() {

    }

    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {

    }

    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelArg() {

    }

    @Pointcut("isControllerLayer() && @args(com.abit.spring.validator.UserInfo,..)")
    public void hasUserInfoParamAnnotation() {

    }

    @Pointcut("bean(userService)")
    public void isUserServiceBean() {
    }

    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {
    }

    @Pointcut("execution(public * com.abit.spring.service.*Service.findById(*))")
    public void anyServiceFindByIdMethod() {
    }

    @Pointcut("execution(public * findById(*))")
    public void anyFindByIdMethod() {
    }

    //Advice
    @Before("anyServiceFindByIdMethod()" +
            "&& args(id)" +
            "&& target(service)" +
            "&& this(proxyService)" +
            "&& @within(transactional)")
    public void addLogging(
            Object id,
            Object service,
            Object proxyService,
            Transactional transactional
    ) {
        log.info("Adding logging to the Aspect");
    }
}