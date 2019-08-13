package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value = "userdaoimpl")
public class UserDaoImpl implements IUserDao {

    @Value("dao msg")
    String msg = null;

    public void findAll() {
        System.out.println(" dao 执行了查询" + msg);
    }
}
