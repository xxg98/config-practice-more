package com.yyh.outandinconfig.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class TestServiceAspect {

    @Before("execution(* com.yyh.outandinconfig.service.TestService.test(..))")
    public String before(){
        System.out.println("before执行");
        return "我是before";
    }

    @AfterReturning("execution(* com.yyh.outandinconfig.service.TestService.test(..))")
    public String afterReturning(){
        System.out.println("AfterReturning执行");
        return "我是AfterReturning";
    }

    @After("execution(* com.yyh.outandinconfig.service.TestService.test(..))")
    public String after(){
        System.out.println("After执行");
        return "我是After";
    }

    @Around("execution(* com.yyh.outandinconfig.service.TestService.test(..))")
    public String around(ProceedingJoinPoint jp) throws Throwable{
//        System.out.println("Around前置");
//        String str = (String)jp.proceed();
//        System.out.println("Around后置");
        return "我是Around";
    }

    @Around("execution(* com.yyh.outandinconfig.service.TestService.test2(..))")
    public List<Long> around2(ProceedingJoinPoint jp) throws Throwable{
        List<Long> a = (List<Long>)jp.proceed();
        System.out.println(a);
        return a;
    }

    @Around("execution(* com.yyh.outandinconfig.service.TestService.test3(..))")
    public void around3(ProceedingJoinPoint jp) throws Throwable{
        Object[] args = jp.getArgs();
        Integer i = (Integer) args[0];
        Long l = (Long) args[1];
        System.out.println("第一个参数："+i+"第二个参数："+l);
    }
}
