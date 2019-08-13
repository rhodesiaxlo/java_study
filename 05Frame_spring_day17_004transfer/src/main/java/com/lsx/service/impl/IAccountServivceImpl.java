package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
import org.springframework.stereotype.Component;

import java.util.List;

public class IAccountServivceImpl implements IAccountService {
    public void transfer(Integer src, Integer target, float money) {
        userdao1.transfer(src,target, money);
    }

    /** 没有getter setter 是无法实现注入的 **/
    private IUserDao userdao1 = null;


    public IUserDao getUserdao1() {
        return userdao1;
    }

    public void setUserdao1(IUserDao userdao1) {
        this.userdao1 = userdao1;
    }

    public List<Account> findAll() {
        return userdao1.findAll();
    }

    public Long getTotal() {
        return userdao1.getTotal();
    }

    public List<Account> findByName(String name) {
        return userdao1.findByName(name);
    }

    public Account findById(Integer id) {
        return userdao1.findById(id);
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
}
