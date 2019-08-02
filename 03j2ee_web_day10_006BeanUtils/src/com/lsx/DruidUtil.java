package com.lsx;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
    private static DataSource ds;
    private static Properties prop = new Properties();

    static {
        try {
            InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.cfg");
            System.out.println("is = " +is);
            prop.load(is);

            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDatasource() {
        System.out.println(prop);
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void  close(Statement stmt, Connection conn) {
        if(null!=stmt){
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
        if(null!=stmt){
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
