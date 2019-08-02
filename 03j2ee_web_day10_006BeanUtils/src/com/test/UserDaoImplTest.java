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

        User zhangsan = new User("张三", "123456");
        User zhangsan2 = new User("张三", "1234567");
        User trueObj = userdao.userLogin(zhangsan);
        User falseObj = userdao.userLogin(zhangsan2);

        System.out.println(trueObj);
        Assert.assertNull(falseObj);
        Assert.assertNotNull(trueObj);

    }
}
