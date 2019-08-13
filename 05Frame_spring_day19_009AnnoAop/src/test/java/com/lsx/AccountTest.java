package com.lsx;

import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
import com.lsx.service.impl.IAccountServivceImpl2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {

    @Autowired
    private IAccountService  service= null;

    @Test
    public void findTotalTest() {

        Long total = service.getTotal();
        System.out.println("总数" + total);

    }

    @Test
    public void findAllTest() {
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void  findByNameTest() {
        List<Account> list = service.findByName("%张%");
        System.out.println("----------- find by name ----------");
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void findByIdTest() {
        Account byId = service.findById(2);
        System.out.println("--------- find by id ----------");
        System.out.println(byId);
    }

    @Test
    /**
     * 如何把 id 返回回来？？？？？？
     */
    public void saveAccountTest() {
        Account a = new Account();
        a.setName("saved-account");
        a.setMoney(10000);

        service.saveAccount(a);
        System.out.println("---------- save account -----------");
        System.out.println(a);
    }

    @Test
    public void updateTest() {
        Account a = new Account();
        a.setId(2);
        a.setName("李四-update1234");
        a.setMoney(8888);
        service.updateAccount(a);
    }

    @Test
    public void delTest() {

    }

    @Test
    public void txText() {
        service.transfer(7,8,100);
    }

    @Test
    /**
     * 基于动态代理的事务控制
     */
    public  void proxyTransactionManager() {
        service.transfer(7,8,100);
    }

    /**
     * 切面测试
     * 前置通知 后置通知 异常通知 最终通知
     * 后置通知和异常通知取其一
     *
     */

    @Test
    public void aopTest() {
        service.transfer(7,8,100);

    }

    @Test
    /**
     * 环绕通知测试方法
     */
    public void aroundAdvisorTest() {
        service.findAll();
    }

    /**
     * 基于注解的aop编程
     */
    public void annotationAdvisorTest() {
        // 使用 spring 注解的 aop 的时候，最终通知会先余 后置/ 异常通知，要注意
    }


}
