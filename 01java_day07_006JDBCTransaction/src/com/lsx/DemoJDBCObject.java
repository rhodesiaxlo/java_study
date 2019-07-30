package com.lsx;


import java.net.PasswordAuthentication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoJDBCObject {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 通过转账，实验事务操作
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {

            conn = JDBCUtils.getConnection();
            System.out.println("auto commit = " + conn.getAutoCommit());
            conn.setAutoCommit(false);
            System.out.println("auto commit = " + conn.getAutoCommit());
            String sql1 = "update account set money=money-100 where name = ?";
            ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, "张三");
            ps1.executeUpdate();
            int i = 10/0;
            String sql2 = "update account set money=money+100 where name = ?";
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, "李四");
            ps2.executeUpdate();
            conn.commit();
        } catch(Exception e) {
            if(null !=conn) {
                conn.rollback();
            }
            System.out.println("rollback");
        } finally {

            JDBCUtils.close(ps1, conn);
            JDBCUtils.close(ps2, conn);

        }



    }





}
