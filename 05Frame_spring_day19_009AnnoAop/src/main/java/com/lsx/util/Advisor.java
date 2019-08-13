package com.lsx.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value = "adv")
@Aspect
public class Advisor {

    @Pointcut(value = "execution(* com.lsx.dao.impl.IUserDaoImpl.transfer(..))")
    public void pt1(){}

    @Pointcut(value = "execution(* com.lsx.dao.impl.IUserDaoImpl.findAll(..))")
    public void pt2() {}


    /**
     * 前置通知
     */
    @Before(value = "pt1()")
    public void before() {
        System.out.println("前置通知...");
    }


    /**
     * 后置通知
     */
    @AfterReturning(value = "pt1()")
    public  void afterReturn() {
        System.out.println("后置通知");
    }

    /***
     * 异常通知
     */
    @AfterThrowing(value = "pt1()")
    public void afterThrow() {
        System.out.println("异常通知");
    }


    /**
     * 最终通知
     */
    @After(value = "pt1()")
    public void after() {
        System.out.println("最终通知");
    }

    @Around(value = "pt2()")
    public Object around(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        Object rtValue= null;
        try {
            System.out.println("前置通知");
            rtValue = pjp.proceed(args);
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();

        } finally {
            System.out.println("最终通知");
        }

        return  rtValue;
    }


}
