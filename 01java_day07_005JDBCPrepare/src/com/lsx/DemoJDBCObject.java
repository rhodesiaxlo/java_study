package com.lsx;


import java.net.PasswordAuthentication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoJDBCObject {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.print(name);
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        System.out.print(password.replaceAll(".", "*"));

        if(login(name, password)) {
            System.out.println("登录成功!");
        } else {
            System.out.println("登录失败!");
        }

    }

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    public static  boolean login(String name, String password) throws SQLException {
        if(name == null || password == null) {
            return false;
        }

        Connection conn = JDBCUtils.getConnection();

        String sql = "select * from user where name=? and password=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);

        ResultSet rs = preparedStatement.executeQuery();
        boolean result = rs.next();
        // 释放资源

        return rs.next();
    }



}
