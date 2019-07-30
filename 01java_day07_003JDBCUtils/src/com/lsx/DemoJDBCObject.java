package com.lsx;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoJDBCObject {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

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

            JDBCUtils.close(rs, stmt, conn);

            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }

}
