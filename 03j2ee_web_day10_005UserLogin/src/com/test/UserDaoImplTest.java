package com.test;

import com.Dao.UserDao;
import com.Dao.impl.UserDaoImpl;
import com.Domain.User;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void userLoginTest() {
        UserDaoImpl userdao = new UserDaoImpl();

        User trueObj = userdao.userLogin("张三", "123456");
        User falseObj = userdao.userLogin("张三", "888888");

        System.out.println(trueObj);
        Assert.assertNull(falseObj);
        Assert.assertNotNull(trueObj);

    }
}
