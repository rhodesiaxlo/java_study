package com.lsx.domain;

import com.lsx.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) {

        // 获得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 获取对象
        IAccountService service = (IAccountService)ac.getBean("userservice1");
        System.out.println(service);
    }

}
