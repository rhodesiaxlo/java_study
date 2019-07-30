package com.lsx;

import com.mysql.cj.protocol.Resultset;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class DemoJDBCObject {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // 加载配置文件
        Properties prop = new Properties();
        try {
            prop.load(DemoJDBCObject.class.getClassLoader().getResourceAsStream("ou.prop"));
        } catch (IOException e) {
            e.printStackTrace();
        }



        // 加载驱动
        Class.forName(prop.getProperty("driver"));

        try {
            // 获取连接
            conn = DriverManager.getConnection(prop.getProperty("connectionstring"),prop.getProperty("user"), prop.getProperty("password"));

            // 生成 sql
            String sql = "select * from account ;";

            // 获得statement 对象
            stmt = conn.createStatement();

            // 获得查询结果集
            rs = stmt.executeQuery(sql);

            // 遍历结果集 封装对象
            List<Account> list =new ArrayList<>();
            while(rs.next()) {
                list.add(new Account(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
            }

            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
