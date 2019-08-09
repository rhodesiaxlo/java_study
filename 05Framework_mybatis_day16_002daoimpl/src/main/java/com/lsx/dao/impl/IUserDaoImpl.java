package com.lsx.dao.impl;

import com.lsx.dao.IUserDao;
import com.lsx.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public IUserDaoImpl(SqlSessionFactory fac) {
        this.factory = fac;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.lsx.dao.IUserDao.findAll");

        return users;
    }
}
