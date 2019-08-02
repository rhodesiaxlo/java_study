package com.com.dao.impl;

import com.com.dao.DaoUser;
import com.domain.User;
import com.lsx.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DaoUserImpl implements DaoUser {
    @Override
    public User userLogin(User u) {
        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());

        String sql = "select * from user where name = ? and password = ?";
        User user;
        System.out.println("login user = " + u);
        try {

            user = tpl.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getName(), u.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;

    }

    @Override
    public boolean createUser(User u) {
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
            String sql = "insert into user values(null, ?, ?, ?, null)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getAge());

            int i = stmt.executeUpdate();

            if(i>0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public List<User> getUsers() {
        // 使用 jdbctemplate 查询

        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());
        
        String sql = "select * from user";
        List<User> lst = tpl.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return lst;

    }

    @Override
    public boolean delUser(User u) {
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
            String sql = "delete from user where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, u.getId());

            int i = stmt.executeUpdate();

            if(i>0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<User> findByName(String name) {
        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());

        String sql = "select * from user where name = ? ";

        List<User> list = tpl.query(sql, new BeanPropertyRowMapper<User>(User.class), name);
        return list;
    }

    @Override
    public User findById(Integer id) {
        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());
        String sql = "select * from user where id = ?";
        User user = null;
        try {

            user = tpl.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        }catch (Exception e) {
            return null;
        }

        return user;
    }

    @Override
    public boolean updateUser(User u) {
        // 更新user
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
            String sql = "update user set name=?, password=? , age=? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getAge());
            stmt.setInt(4, u.getId());

            int i = stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
