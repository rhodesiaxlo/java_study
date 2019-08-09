package com.lsx.dao;

import com.lsx.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
