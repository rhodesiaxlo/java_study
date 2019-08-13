package com.lsx.util;

import java.sql.SQLException;

public class TransactionManager {

    private  ConnUtil conutil = null;

    public void setConutil(ConnUtil conutil) {
        this.conutil = conutil;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() throws SQLException {
        conutil.getConn().setAutoCommit(false);
    }

    /**
     * 提交事务
     */
    public void commit() throws SQLException {
        conutil.getConn().commit();
    }


    /**
     * 回滚事务
     */
    public  void roolback() {

        try {
            conutil.getConn().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放连接
     */
    public void release() {
        conutil.removeConnection();
    }

}
