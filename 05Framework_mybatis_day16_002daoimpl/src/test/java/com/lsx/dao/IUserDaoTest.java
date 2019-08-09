package com.lsx.dao;

import com.lsx.dao.impl.IUserDaoImpl;
import com.lsx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class IUserDaoTest {

    @Test
    public void getAllTest() throws IOException {
//
//        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
//        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = bld.build(is);
//        SqlSession session = factory.openSession();
//        IUserDao userdao = session.getMapper(IUserDao.class);
//        List<User> all = userdao.findAll();
//        for (User user : all) {
//            System.out.println(user);
//        }
//        session.close();
//        is.close();
    }

    @Test
    public void getAllTest2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);

        IUserDao userdao = new IUserDaoImpl(factory);
        List<User> all = userdao.findAll();
        System.out.println("test-------------");
        for (User user : all) {
            System.out.println(user);
        }
    }

}
