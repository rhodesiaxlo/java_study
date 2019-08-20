package com.lsx;

import com.lsx.dao.IDaoUser;
import com.lsx.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatiss {

    /**
     * 测试mybatis 项目搭建
     */
    @Test
    public void abcTest() {
        InputStream is = MyBatiss.class.getClassLoader().getResourceAsStream("MySqlConfig.xml");
        // sqlssessionfactroybuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // factory
        SqlSessionFactory fac = builder.build(is);

        // session
        SqlSession session = fac.openSession();

        // 获取代理对象
        IDaoUser mapper = session.getMapper(IDaoUser.class);

        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
        }

        session.close();
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void findByIdTest() {
        InputStream is = MyBatiss.class.getClassLoader().getResourceAsStream("MySqlConfig.xml");
        // sqlssessionfactroybuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // factory
        SqlSessionFactory fac = builder.build(is);

        // session
        SqlSession session = fac.openSession();

        // 获取代理对象
        IDaoUser mapper = session.getMapper(IDaoUser.class);

        User user= mapper.findById(4);

        System.out.println(user);

        session.close();
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
