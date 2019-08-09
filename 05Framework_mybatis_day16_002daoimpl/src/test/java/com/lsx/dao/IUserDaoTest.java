package com.lsx.dao;

import com.lsx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoTest {

    @Test
    public void getAllTest() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);
        List<User> all = userdao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        session.close();
        is.close();
    }



    @Test
    public void saveUserTest() throws IOException {
        User u = new User();
        u.setName("saveuser-name");
        u.setPassword("123456");
        u.setAddress("saveuser-address");
        u.setAge(20);
        u.setSex(1);
        u.setBirthday("2019-12-12");


        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);

        userdao.saveUser(u);

        session.commit();;

        session.close();
        is.close();

        System.out.println("保存成功");


    }

    @Test
    public void updateUserTest() throws IOException {
        User u = new User();
        u.setId(5);
        u.setName("updateuser-name");
        u.setPassword("updateuser-password");
        u.setAge(20);
        u.setBirthday("2020-12-12");
        u.setAddress("updateuser-address");
        u.setSex(1);


        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);

        userdao.updateUser(u);

        session.commit();

        session.close();
        is.close();

        System.out.println("保存成功");

    }

    @Test
    public void delUserTest() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);

        userdao.delUser(17);

        session.commit();

        session.close();
        is.close();

        System.out.println("保存成功");
    }

    @Test
    public void findOneTest() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);

        User one = userdao.findOne(2);
        System.out.println(one);


        session.commit();

        session.close();
        is.close();

    }

    @Test
    /**
     * 模糊查询
     */
    public void findByNameTest() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMysqlConfig.xml");
        SqlSessionFactoryBuilder bld = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bld.build(is);
        SqlSession session = factory.openSession();
        IUserDao userdao = session.getMapper(IUserDao.class);

        List<User> list = userdao.findByName("%张%");
        for (User user : list) {
            System.out.println(user);
        }


        session.commit();

        session.close();
        is.close();

    }

}
