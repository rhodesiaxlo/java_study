package com.lsx;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DemoJDBC {

    // java.lang
    // java.util
    // java.net
    // java.io
    // java.sql

    // 快速入门
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // 导入 jar 包 add as libs
        Properties prop = new Properties();
        InputStream resourceAsStream = DemoJDBC.class.getClassLoader().getResourceAsStream("ou.prop");
        System.out.println(resourceAsStream);

        prop.load(resourceAsStream);
        // 加载驱动
        Class.forName(prop.getProperty("driver"));
        // 获取连接connection

        try(
            Connection conn = DriverManager.getConnection(prop.getProperty("connectionstring"), prop.getProperty("user"), prop.getProperty("password"));
            Statement statement = conn.createStatement();
            // 执行，
        ) {
            // statement

            String sql = "select * from account";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("id") + ", name" + rs.getString("name"));
            }

            String sql_insert = "insert into account(name) values ('libiao');";

            Statement statement1 = conn.createStatement();
            statement1.executeUpdate(sql_insert);

            String sql_del = "delete from account where id=3;";
            statement1.executeUpdate(sql_del);

            String insert_sql  = "insert into account(`name`) values (?);";
            PreparedStatement ps = conn.prepareStatement(insert_sql);
            ps.setString(1, "name");
            ps.execute();

            boolean execute = statement.execute("select * from account");
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()) {
                System.out.println("name = " + resultSet.getString("name"));
            }


            //execute update  ddl create alter drop

            // dm insert del update
            // int executeUpdate


        }catch(Exception e) {
            e.printStackTrace();
        }


    }
}
