package com.lsx.service;

import com.lsx.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 查询所有记录
     * @return
     */
    public List<Account> findAll();

    /**
     * 获取总记录条数
     * @return
     */
    public Long getTotal();

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    public List<Account> findByName(String name);

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 保存账户
     * @param a
     */
    public void saveAccount(Account a);

    /**
     * 跟新账户
     * @param a
     */
    public void updateAccount(Account a);


    /**
     * 删除账户
     * @param id
     */
    public  void delAccount(Integer id);
}
