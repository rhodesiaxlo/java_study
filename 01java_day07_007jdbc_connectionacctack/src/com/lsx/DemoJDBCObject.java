package com.lsx;


import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class DemoJDBCObject {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

        Properties prop = new Properties();
        // connection 输入稀缺资源
        try {
            prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("ou.prop"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try-- catch 出现异常后会直接跳转 exception 执行，所以多个 exception 需要分开执行
        try {
            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Connection> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            long l = System.currentTimeMillis();
            list.add( DriverManager.getConnection(prop.getProperty("connectionstring"), prop.getProperty("user"), prop.getProperty("password")));
            System.out.println("time consumeing = " + (System.currentTimeMillis() -l)+ "  size = " + list.size());
        }
        System.out.println(list);

        // 连接到300个连接的时候

        /*
        * xception in thread "main" java.sql.SQLNonTransientConnectionException: Data source rejected establishment of connection,  message from server: "Too many connections"
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:110)
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
        at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:827)
        at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:447)
        at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:237)
        at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:199)
        at java.sql.DriverManager.getConnection(DriverManager.java:664)
        at java.sql.DriverManager.getConnection(DriverManager.java:247)
        at com.lsx.DemoJDBCObject.main(DemoJDBCObject.java:35)
	*
	*
	* */
        System.out.println("完成");



    }





}
