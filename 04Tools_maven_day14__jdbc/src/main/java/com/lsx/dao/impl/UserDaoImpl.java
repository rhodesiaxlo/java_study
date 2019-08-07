package com.lsx.dao.impl;

import com.lsx.dao.UserDao;
import com.lsx.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl  implements UserDao {
    public List<User> getAll() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // 获取 connection 对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://139.129.212.114:3306/lsx_test", "root", "ba22c096d6af7ca3");
        //
        CallableStatement stmt = conn.prepareCall("select * from user");

        ResultSet rs = stmt.executeQuery();


        List<User> list = new ArrayList<User>();
        while(rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setPassword(rs.getString("password"));
            list.add(u);
        }

        return list;

    }
}
