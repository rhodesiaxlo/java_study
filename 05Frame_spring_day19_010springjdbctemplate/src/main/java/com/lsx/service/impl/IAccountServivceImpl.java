package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
import java.util.List;

public class IAccountServivceImpl implements IAccountService {


    /** 没有getter setter 是无法实现注入的 **/
    private IUserDao userdao1 = null;


    public IUserDao getUserdao1() {
        return userdao1;
    }

    public void setUserdao1(IUserDao userdao1) {
        this.userdao1 = userdao1;
    }

    public List<Account> findAll()
    {

        List<Account>  list = userdao1.findAll();


        return list;
    }

    public Long getTotal()
    {

        Long total = userdao1.getTotal();
        return total;

    }

    public List<Account> findByName(String name) {

        List<Account> listlist = userdao1.findByName(name);
        return listlist;

    }

    public Account findById(Integer id) {
        return userdao1.findById(id);
    }

    public void saveAccount(Account a) {


    }

    public void updateAccount(Account a) {


    }

    public void delAccount(Integer id) {


    }

    public void transfer(Integer src, Integer target, float money) {

    }
}
