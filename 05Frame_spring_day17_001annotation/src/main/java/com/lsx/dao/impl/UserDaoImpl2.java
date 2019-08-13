package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "dao22")
public class UserDaoImpl2 implements IUserDao {

    @Value("dao2 msg")
    String msg = null;

    public void findAll() {
        System.out.println("dao2 执行了查询" + msg);
    }
}
