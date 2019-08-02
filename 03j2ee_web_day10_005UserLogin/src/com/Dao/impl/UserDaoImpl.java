package com.Dao.impl;

import com.Dao.UserDao;
import com.Domain.User;
import com.lsx.DruidUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl {

    public User userLogin(String name, String password) {
            JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());
            String sql = "select * from user where name=? and password = ?";

            try {

                return tpl.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            } catch (EmptyResultDataAccessException e) {
                return null;
            }

    }
}
