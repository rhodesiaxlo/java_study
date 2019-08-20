package com.lsx.dao;

import com.lsx.domain.User;

import java.util.List;

public interface IDaoUser {

    /**
     * mybatis 的常见操作
     *
     * findall
     * findbyid
     * insert
     * update
     * delete
     */


    /**
     * 演示一行一列数据
     * @return
     */
    public Integer findTotal();

    /**
     * 最简单入门
     * @return
     */
    public List<User> findAll();

    /**
     * 参数查询
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     * 保存用户
     * @param u
     */
    public void save(User u);

    /**
     * 更新用户
     * 动态sql
     * 事务控制
     * @param u
     */
    public void updateUser(User u);

    /**
     * 删除用户
     * @param id
     */
    public void del(Integer id);
}
