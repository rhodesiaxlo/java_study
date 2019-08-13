package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class IUserDaoImpl implements IUserDao {

    private JdbcTemplate tpl;


    public void setTpl(JdbcTemplate tpl) {

        this.tpl = tpl;
    }

    public List<Account> findAll(){
        return  tpl.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));

    }

    public Long getTotal() {
        Long aLong = tpl.queryForObject("select count(*) from account", Long.class);
        return aLong;
    }

    public List<Account> findByName(String name) {
        List<Account> query = tpl.query("select * from account where name like ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        return query;

    }

    public Account findById(Integer id) {
        List<Account> query = tpl.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        if(null!=query&&query.size()>1){
            throw  new RuntimeException("结果集不唯一");
        } else if(null == query) {
            return null;
        } else {
            return query.get(0);
        }

    }

    public void saveAccount(Account a) {
        tpl.update("insert into account(name, age, money) values (?, ?, ?)", a.getName(), 10, a.getMoney());
    }

    public void updateAccount(Account a) {
        tpl.update("update account set name=?, money=? where id = ?", a.getName(), a.getMoney(), a.getId());
    }

    public void delAccount(Integer id) {
        tpl.update("delete from account where id = ?", id);
    }

    /**
     * 转账 srcid
     * @param srcID
     * @param targetId
     * @param money
     */
    public void transfer(Integer srcID, Integer targetId, float money){
        Account src = findById(srcID);
        Account target = findById(targetId);

        src.setMoney(src.getMoney()-money);
        target.setMoney(target.getMoney() + money);

        updateAccount(src);

        int i = 5/0;


        updateAccount(target);
    }
}
