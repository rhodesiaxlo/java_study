package com.test;

import com.lsx.DruidUtil;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DruidTest {

    @Test
    public void connectionTest() {
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(conn);


    }
}
