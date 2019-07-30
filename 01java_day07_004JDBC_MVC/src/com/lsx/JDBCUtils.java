package com.lsx;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc 工具类
 */
public class JDBCUtils {
    private static Properties prop = new Properties();
    private static Connection conn = null;

    static {

        // 获取 source code 根目录
        try {
            prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("ou.prop"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try-- catch 出现异常后会直接跳转 exception 执行，所以多个 exception 需要分开执行
        try {
            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(prop.getProperty("connectionstring"), prop.getProperty("user"), prop.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return conn;
    }

    public static void close(Statement stmt , Connection conn) {
        if(null!=stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if(null!=rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
