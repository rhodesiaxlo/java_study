package com.lsx.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advisor {

    /**
     * 前置通知
     */
    public void before() {
        System.out.println("前置通知...");
    }


    /**
     * 后置通知
     */
    public  void afterReturn() {
        System.out.println("后置通知");
    }

    /***
     * 异常通知
     */
    public void afterThrow() {
        System.out.println("异常通知");
    }


    /**
     * 最终通知
     */
    public void after() {
        System.out.println("最终通知");
    }

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
