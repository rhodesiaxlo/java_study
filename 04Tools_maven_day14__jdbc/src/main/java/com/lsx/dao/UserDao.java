package com.lsx.dao;

import com.lsx.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public List<User> getAll() throws ClassNotFoundException, SQLException;
}
