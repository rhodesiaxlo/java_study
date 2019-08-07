package com.com.dao;

import com.domain.PageBean;
import com.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface DaoUser {

    public User userLogin(User u);

    public List<User> getUsers();

    public boolean createUser(User u);

    public boolean delUser(User u);

    public User findById(Integer id);

    public boolean updateUser(User u);

    public List<User> findByName(String name);

    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition);

    public Integer totalCount(Map<String, String[]> condition);
}
