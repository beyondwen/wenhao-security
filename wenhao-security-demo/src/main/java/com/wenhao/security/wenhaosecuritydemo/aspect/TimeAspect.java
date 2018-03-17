package com.wenhao.security.wenhaosecuritydemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/*@Aspect
@Component*/
public class TimeAspect {

    @Around("execution(* com.wenhao.security.wenhaosecuritydemo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("time aspesct start");
        long startTime = new Date().getTime();
        Object o = joinPoint.proceed();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("参数是=：" + arg);
        }
        System.out.println("time aspesct 耗时" + (new Date().getTime() - startTime));
        System.out.println("time aspesct end");
        return o;
    }
}
