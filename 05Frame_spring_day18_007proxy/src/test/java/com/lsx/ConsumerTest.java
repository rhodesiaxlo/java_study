package com.lsx;

import com.lsx.impl.ProducerImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ConsumerTest {

    @Test
    /**
     * 演示代理模式
     * 标准即接口
     */
    public  void buyTest() {
        ProducerImpl pro = new ProducerImpl();

        Consumer c = new Consumer();
        c.setProducer(pro);

        c.buy(1000F);
    }

    @Test
    /**
     * 基于接口的动态代理
     * 特点：
     *     不需要修改源码的情况下对又有方法增强
     *     随用随加载
     *
     * 步骤：
     *    1. 被代理类最少实现一个接口，如果没有则不能被代理
     *    3. 工具 proxy 类中的 newProxyInstance
     *
     *
     *
     *
     */
    public void interfaceProxyTest() {

        final ProducerImpl pro = new ProducerImpl();

        // o 现在就是增强的类
        IProducer o = (IProducer)Proxy.newProxyInstance(ProducerImpl.class.getClassLoader(), ProducerImpl.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object rtValue = null;
                if ("sale".equalsIgnoreCase(method.getName())) {
                    Float money = (Float) args[0];
                    rtValue = method.invoke(pro, money * 0.8F);

                } else {
                    rtValue = method.invoke(pro, args);

                }

                return rtValue;
            }
        });


        o.sale(10000F);
    }

    @Test
    /**
     * 基于类的动态代理
     * 特点：
     *      不修改源码的情况下方法增强
     *
     * 步骤：
     *      enhancer 中的create
     */
    public  void  classProxyTest() {
        final ProducerImpl pro = new ProducerImpl();

        ProducerImpl proxyPro = (ProducerImpl)Enhancer.create(ProducerImpl.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if ("sale".equalsIgnoreCase(method.getName())) {
                    Object rtvalue = null;
                    Float money = (Float) objects[0];
                    rtvalue = method.invoke(pro, money * 0.8F);
                    return rtvalue;
                } else {
                    return method.invoke(pro, objects);
                }
            }
        });

        proxyPro.sale(1000F);
    }
}
