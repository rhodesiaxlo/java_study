package com.lsx.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 连接工具类，主要获取 local_thread 连接
 */
public class ConnUtil {

    private   ThreadLocal<Connection>  conn = new ThreadLocal<Connection>();
    private   DataSource  ds;


    public   DataSource getDs() {
        return ds;
    }

    /**
     * 注入数据源
     * @param ds
     */
    public  void setDs(DataSource ds) {
        this.ds = ds;
    }

    static {
        // 注册驱动

        // 获得 ds

        // 获得 connection
    }

    /**
     * 获取一个local_thread 的连接
     * 如果已经创建，取之前那个
     * 没有，则重新创建一个
     * @return
     */
    public  Connection getConn() {

        try {
            if(null != conn.get()) {
                    return conn.get();
            } else {
                // 空，创建一个新的连接对象，
                conn.set(ds.getConnection());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn.get();
    }

    public Connection getConn2() {
        try {
            Connection co = conn.get();

            if( null == co) {
                co = ds.getConnection();
                conn.set(co);
            }

            return co;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void removeConnection() {
        conn.remove();
    }
}
