package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.dao.impl.UserDaoImpl;
import com.lsx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component(value = "userservice1")
public class IUserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("dao22")
    IUserDao dao2 = null;
    public void findAllUser() {
        System.out.println(" service 执行了查询");
        dao2.findAll();
    }
}
