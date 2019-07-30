package com.lsx;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        //System.out.println("hello world");
        ComboPooledDataSource ds = new ComboPooledDataSource("lsx");
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("driver = " + ds.getDriverClass());
        System.out.println("url = " + ds.getJdbcUrl());
        System.out.println("user = " + ds.getUser());
        System.out.println("password = " + ds.getPassword());


        System.out.println("initial pool size = " + ds.getInitialPoolSize());
        System.out.println("max pool size = " + ds.getMaxPoolSize());
        System.out.println("min pool size = " + ds.getMinPoolSize());
        System.out.println("time out = " + ds.getCheckoutTimeout());


        for (int i = 0; i < 10; i++) {
            try {
                long l = System.currentTimeMillis();
                Connection conn = ds.getConnection();
                System.out.println(conn);
                //System.out.println("time consuming = " + (System.currentTimeMillis()-l));
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }




    }
}
