package com.lsx;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        // jdbctemplet = new JdbcTemplate(ds);
        // queryformap
        // queryforlist
        // query
        // queryforobject

        /*DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        String sql = "update account set money=200 where id = ?";
        int update = tpl.update(sql, 2);
        System.out.println(update);
        */

        // CRUD
        // 修改记录
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);



        // 修改记录

        // 查询id=1 封装为对象

        // 查询所有记录，封装为list

        // 查询所有记录，封装为对象的集合

        // 查询总记录条数


    }

    @Test
    public void delTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String delSql= "delete from account where id=?";
        int count = tpl.update(delSql, 11);
        System.out.println("删除条数");
    }

    @Test
    public void updateTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String delSql= "update account set money = 1000 where id = ?";
        int count = tpl.update(delSql, 1);
        System.out.println("更新条数" +count);
    }

    @Test
    public void insertTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String delSql= "insert into account values (null, ?, ?, ?)";
        int count = tpl.update(delSql, "郭靖", 20,1000);
        System.out.println("插入条数" +count);
    }

    @Test
    public void queryForObjectTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String selectsql= "select * from account where id = ?";
        Map<String, Object> map = tpl.queryForMap(selectsql, 2);
        System.out.println("插入条数" + map);
    }

    @Test
    public void queryForListTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String selectsql= "select * from account where id <> ?";
        List<Map<String, Object>> maps = tpl.queryForList(selectsql, 1);
        System.out.println("插入条数" + maps);
    }

    @Test
    public void query() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String selectsql= "select * from account where 1 ";

        List<Account> query = tpl.query(selectsql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account acount = new Account();

                acount.setId(resultSet.getInt("id"));
                acount.setName(resultSet.getString("name"));
                acount.setAge(resultSet.getInt("money"));

                return acount;
            }
        });

        System.out.println(query);
    }

    @Test
    public void query2Test() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String selectsql= "select * from account where 1 ";

        List<Account> list = tpl.query(selectsql, new BeanPropertyRowMapper<Account>(Account.class));

        System.out.println(list);


    }

    @Test
    public void queryForNumTest() {
        DataSource ds = DruidUtil.getDatasource();
        JdbcTemplate tpl = new JdbcTemplate(ds);
        // 删除记录
        String selectsql= "select count(*) from account where 1 ";

        Long aLong = tpl.queryForObject(selectsql, Long.class);

        System.out.println("long = " + aLong);

    }




}
