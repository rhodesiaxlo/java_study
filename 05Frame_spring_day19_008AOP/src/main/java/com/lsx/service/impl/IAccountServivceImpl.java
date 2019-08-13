package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.lsx.service.IAccountService;
import com.lsx.util.TransactionManager;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

public class IAccountServivceImpl implements IAccountService {
    private TransactionManager tx = null;

    public void setTx(TransactionManager tx) {
        this.tx = tx;
    }

    public void transfer(Integer src, Integer target, float money) {

        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作
            userdao1.transfer(src,target, money);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }

    }

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

        List<Account>  list = null;
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作

            list = userdao1.findAll();

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }

        return list;
    }

    public Long getTotal()
    {

        Long total = 0L;
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作

            total = userdao1.getTotal();

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }
        return total;
    }

    public List<Account> findByName(String name) {

        List<Account> list = null;
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作

            list = userdao1.findByName(name);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }
        return list;
    }

    public Account findById(Integer id) {

        Account a = null;
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作

            a = userdao1.findById(id);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }

        return a;
    }

    public void saveAccount(Account a) {

        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作
            userdao1.saveAccount(a);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }


    }

    public void updateAccount(Account a) {
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作
            userdao1.updateAccount(a);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }

    }

    public void delAccount(Integer id) {
        try {
            // 开启事务
            tx.beginTransaction();

            // dao 操作
            userdao1.delAccount(id);

            // 提交
            tx.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tx.roolback();
        } finally {
            tx.release();
        }

    }
}
