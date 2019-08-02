package com.lsx;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        // 阿里巴巴德鲁伊连接池示例

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Connection conn = DruidUtil.getConnection();
                        //System.out.println("connn" +conn);
                        //System.out.println(Thread.currentThread().getName() + " sleep 100ms");
                        //Thread.sleep(100);
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();



        }


    }
}
