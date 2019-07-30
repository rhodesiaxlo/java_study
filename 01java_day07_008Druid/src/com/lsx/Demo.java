package com.lsx;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        // 阿里巴巴德鲁伊连接池示例
        Properties prop = new Properties();
        try {
            prop.load(Demo.class.getClassLoader().getResourceAsStream("druid.cfg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataSource ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
