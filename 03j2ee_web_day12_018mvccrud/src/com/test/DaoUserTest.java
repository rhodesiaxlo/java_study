package com.test;

import com.com.dao.DaoUser;
import com.com.dao.impl.DaoUserImpl;
import com.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DaoUserTest {

    @Test
    public void userLoginTest() {
        User u = new User("张三", "123456", 10, new Date());
        User u2 = new User("张三", "123457", 10, new Date());

        DaoUser dao = new DaoUserImpl();
        User trueuser = dao.userLogin(u);

        User falseuser = dao.userLogin(u2);

        Assert.assertNull(falseuser);
        Assert.assertNotNull(trueuser);
    }

    @Test
    public void usersTest() {
        DaoUser dao = new DaoUserImpl();

        List<User> list = dao.getUsers();
        if(null!=list) {
            Assert.assertTrue(list.size()>0);
        }
    }
}
