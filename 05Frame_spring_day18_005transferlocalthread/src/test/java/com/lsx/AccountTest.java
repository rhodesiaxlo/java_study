package com.lsx;

import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
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

}
