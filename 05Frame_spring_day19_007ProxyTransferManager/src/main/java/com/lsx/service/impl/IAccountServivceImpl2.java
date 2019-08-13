package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
import com.lsx.util.TransactionManager;

import java.sql.SQLException;
import java.util.List;

public class IAccountServivceImpl2 implements IAccountService {



    /** 没有getter setter 是无法实现注入的 **/
    private IUserDao userdao1 = null;


    public IUserDao getUserdao1() {
        return userdao1;
    }

    public void setUserdao1(IUserDao userdao1) {
        this.userdao1 = userdao1;
    }

    public IAccountServivceImpl2(IUserDao userdao1) {
        this.userdao1 = userdao1;
    }

    public IAccountServivceImpl2() {
    }

    public List<Account> findAll()
    {

        List<Account>  list = null;
        list = userdao1.findAll();

        return list;
    }

    public Long getTotal()
    {

        Long total = 0L;
        total = userdao1.getTotal();

        return total;
    }

    public List<Account> findByName(String name) {

        List<Account> list = null;

        list = userdao1.findByName(name);

        return list;
    }

    public Account findById(Integer id) {

        Account a = null;

        a = userdao1.findById(id);

        return a;
    }

    public void saveAccount(Account a) {

        userdao1.saveAccount(a);
    }

    public void updateAccount(Account a) {
        userdao1.updateAccount(a);
    }

    public void delAccount(Integer id) {

        userdao1.delAccount(id);

    }

    public void transfer(Integer src, Integer target, float money) {
        // dao 操作
        userdao1.transfer(src,target, money);
    }

}
