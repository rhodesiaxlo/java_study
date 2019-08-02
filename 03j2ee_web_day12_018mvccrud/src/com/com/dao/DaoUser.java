package com.com.dao;

import com.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface DaoUser {

    public User userLogin(User u);

    public List<User> getUsers();

    public boolean createUser(User u);

    public boolean delUser(User u);

    public User findById(Integer id);

    public boolean updateUser(User u);

    public List<User> findByName(String name);
}
