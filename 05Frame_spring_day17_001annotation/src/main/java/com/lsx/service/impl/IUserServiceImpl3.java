package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.dao.impl.UserDaoImpl;
import com.lsx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component(value = "userservice3")
public class IUserServiceImpl3 implements IUserService {


    @Resource(name="dao22")
    IUserDao dao2 = null;
    public void findAllUser() {
        System.out.println(" service2 执行了查询");
        dao2.findAll();
    }
}