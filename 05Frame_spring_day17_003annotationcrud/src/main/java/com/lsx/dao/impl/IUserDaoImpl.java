package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private QueryRunner runner = null;

    public QueryRunner getRunner() {

        return runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll(){
        List<Account> list = null;
        try {
            list = runner.query("select * from account ", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public Long getTotal() {
        Long count = 0L;
        try {
            count = (Long)runner.query("select count(*) from account", new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<Account> findByName(String name) {
        List<Account> a = null;

        try {
            a = runner.query("select * from account where name like ?", new BeanListHandler<Account>(Account.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;

    }

    public Account findById(Integer id) {
        Account a = null;

        try {
            a = runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void saveAccount(Account a) {

        try {
            runner.update("insert into account (name, age, money) values (?, 10 , ?) ", a.getName(), a.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateAccount(Account a) {
        try {
            runner.update("update  account set name=?, money=? where id = ?", a.getName(), a.getMoney(), a.getId());
        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }

    public void delAccount(Integer id) {
        try {
            runner.update(" delete from account  where id = ?", id);
        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }
}
