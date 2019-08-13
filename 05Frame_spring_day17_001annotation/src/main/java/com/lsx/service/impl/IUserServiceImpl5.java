package com.lsx.service.impl;

import com.lsx.dao.IUserDao;
import com.lsx.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Component(value = "userservice5")
@Scope(value = "singleton")
public class IUserServiceImpl5 implements IUserService {

    String[] strArr = null;
    List<String> list = null;
    Set<String> set = null;
    Map<String, String> hashmap = null;

    // 复杂类型
    List<IUserDao> list2 = null;
    Map<String, IUserDao> map2 = null;

    @Resource(name="dao22")
    IUserDao dao2 = null;

    public void findAllUser() {
        System.out.println(" service2 执行了查询");
        dao2.findAll();
    }

}