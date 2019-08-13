package com.lsx;

import com.lsx.service.IUserService;
import com.lsx.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public  void mainTest() {
        IUserService service = new IUserServiceImpl();
        service.findAllUser();
    }

    @Test
    public void springTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice1 = (IUserService) ac.getBean("userservice1");
        userservice1.findAllUser();

        // 释放资源
        ac.close();
    }

    @Test
    /**
     * di 根据类型查找
     * 只有一个还好
     * 没有呢？
     * 有多个呢？
     */
    public void diTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice1 = (IUserService) ac.getBean("userservice1");
        userservice1.findAllUser();

        // 释放资源
        ac.close();
    }

    @Test
    /**
     * di 有多个匹配的时候
     * 首先用类型匹配
     * 其次用变量名匹配
     * 最后用qualifer匹配
     */
    public void diMultiMatchTest() {

    }

    @Test
    public void resourceDiTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice1 = (IUserService) ac.getBean("userservice2");
        userservice1.findAllUser();

        // 释放资源
        ac.close();
    }

    @Test
    /**
     * 基本类型注入
     */
    public void primitiveDiTest() {

    }

    @Test
    /**
     * 集合类型的注解注入
     */
    public void collectionDiTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice5 = (IUserService) ac.getBean("userservice5");
        userservice5.findAllUser();
        // 释放资源
        ac.close();
    }

    @Test
    /**
     * 检测作用敢为
     */
    public void scopeTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice1 = (IUserService) ac.getBean("userservice2");
        IUserService userservice2 = (IUserService) ac.getBean("userservice2");
        System.out.println(userservice1==userservice2);
        // 释放资源
        ac.close();
    }

    @Test
    /**
     *
     */
    public  void lifeCycleTest() {
        // 获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userservice = (IUserService) ac.getBean("userservice2");
        userservice.findAllUser();
        // 释放资源
        ac.close();
    }

}
