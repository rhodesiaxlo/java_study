package com.Dao;

import com.Domain.User;

public interface UserDao {
    public User userLogin(String name, String password);
}
