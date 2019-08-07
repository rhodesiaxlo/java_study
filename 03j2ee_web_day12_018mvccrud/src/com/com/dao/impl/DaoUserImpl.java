package com.com.dao.impl;

import com.com.dao.DaoUser;
import com.domain.PageBean;
import com.domain.User;
import com.lsx.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaoUserImpl implements DaoUser {
    @Override
    public Integer totalCount(Map<String, String[]> condition) {

        // 使用 jdbctemplate 查询

        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());

        String sql = "select count(*) from user where 1";

        List<String> params = new ArrayList<>();
        StringBuilder sb = new StringBuilder(sql);
        if(null!=condition) {
            Set<String> keys = condition.keySet();
            for (String key : keys) {
                if("currentPage".equalsIgnoreCase(key)||"recordPerPage".equalsIgnoreCase(key)) {
                    continue;
                }
                String val = condition.get(key)[0];

                if(!val.isEmpty()) {
                    sb.append("  and " + key + " like ? ");
                    params.add("%" +val+ "%");
                }
            }
        }

        System.out.println("query string = " +sb.toString());
        System.out.println("param = " +params);
        Integer count = tpl.queryForObject(sb.toString(), Integer.class, params.toArray());
        return count;

    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {
        // 生成空的pagebean
        PageBean<User> page = new PageBean<>();
        // 设置当前页面的属
        page.setCurrent(currentPage);
        page.setRecordPerPage(rows);

        // 获得所有记录数
        Integer total = totalCount(condition);
        int pageTotal = total % rows ==0?total/rows:total/rows+1;
        page.setRecordTotal(total);
        page.setPageTotal(pageTotal);

        // 根据 current 和 record_per_page 查询记录 dao.findbypage(
        // 查询  (current-1)*rows
        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());

        // 动态sql


        String sql = "select * from user where 1";
        List<String> params = new ArrayList<>();

        StringBuilder sb = new StringBuilder(sql);
        if(null!=condition) {
            Set<String> keys = condition.keySet();
            for (String key : keys) {
                if("currentPage".equalsIgnoreCase(key)||"recordPerPage".equalsIgnoreCase(key)) {
                    continue;
                }
                String val = condition.get(key)[0];

                if(!val.isEmpty()) {
                    sb.append("  and " + key + " like ? ");
                    params.add("%" +val+ "%");
                }
            }
        }





        Integer start = (currentPage-1)*rows;
        Integer end = currentPage*rows;

        sb.append(" limit " + start + ", " + end);


        System.out.println("  find user by page  sql = " + sb.toString());
        System.out.println(" find user by page params = " + params);

        List<User> lst = tpl.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());

        page.setList(lst);
        // 返回 pagebean 对象

        return page;
    }

    @Override
    public User userLogin(User u) {
        JdbcTemplate tpl = new JdbcTemplate(DruidUtil.getDatasource());

        String sql = "select * from user where name = ? and password = ? ";
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
