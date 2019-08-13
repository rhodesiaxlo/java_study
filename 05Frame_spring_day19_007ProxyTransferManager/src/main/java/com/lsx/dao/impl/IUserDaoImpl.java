package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import com.lsx.util.ConnUtil;
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

    private ConnUtil connUtil = null;

    public QueryRunner getRunner() {

        return runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public ConnUtil getConnUtil() {
        return connUtil;
    }

    public void setConnUtil(ConnUtil connUtil) {
        this.connUtil = connUtil;
    }

    public List<Account> findAll(){
        List<Account> list = null;
        try {
            list = runner.query(connUtil.getConn(), "select * from account ", new BeanListHandler<Account>(Account.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public Long getTotal() {
        Long count = 0L;
        try {
            count = (Long)runner.query(connUtil.getConn(), "select count(*) from account", new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<Account> findByName(String name) {
        List<Account> a = null;

        try {
            a = runner.query(connUtil.getConn(), "select * from account where name like ?", new BeanListHandler<Account>(Account.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;

    }

    public Account findById(Integer id) {
        Account a = null;

        try {
            a = runner.query(connUtil.getConn(), "select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void saveAccount(Account a) {

        try {
            runner.update(connUtil.getConn(), "insert into account (name, age, money) values (?, 10 , ?) ", a.getName(), a.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateAccount(Account a) {
        try {
            runner.update(connUtil.getConn(), "update  account set name=?, money=? where id = ?", a.getName(), a.getMoney(), a.getId());
        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }

    public void delAccount(Integer id) {
        try {
            runner.update(connUtil.getConn(), " delete from account  where id = ?", id);
        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }

    /**
     * 转账 srcid
     * @param srcID
     * @param targetId
     * @param money
     */
    public void transfer(Integer srcID, Integer targetId, float money){


            // 查询源账户
            Account src = findById(srcID);
            // 查询目标账户
            Account target = findById(targetId);

            // 原账户减钱
            src.setMoney(src.getMoney()-money);
            // 目标账户增加
            target.setMoney(target.getMoney() + money);

            // 保存原账户
            updateAccount(src);
            //int i = 2/0;
            // 保存目标账户
            updateAccount(target);


    }
}
