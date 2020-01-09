package com.akon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.akon..*.*(..))")
    public void Log(){}

    @Before("Log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("before....");
        System.out.println("joinPoint..."+joinPoint.toString());
    }
}
