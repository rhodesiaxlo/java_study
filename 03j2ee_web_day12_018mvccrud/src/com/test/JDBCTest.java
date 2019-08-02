package com.test;

import com.lsx.DruidUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest {

    @Test
    public void dsTest() {
        DataSource ds = DruidUtil.getDatasource();
        Assert.assertNotNull(ds);

    }

    @Test
    public void connTest() {
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(conn);
    }
}
