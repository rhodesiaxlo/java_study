package com.lsx.service.factory;

import com.lsx.dao.IUserDao;
import com.lsx.service.IAccountService;
import com.lsx.service.impl.IAccountServivceImpl;
import com.lsx.service.impl.IAccountServivceImpl2;
import com.lsx.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceFactory {

    //private IAccountService seervice = null;
    private TransactionManager tx = null;
    private IUserDao dao = null;

    public void setTx(TransactionManager tx) {
        this.tx = tx;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    public IAccountService getService()
    {
        final IAccountService servcie = new IAccountServivceImpl2(dao);

        /**
         * 因为实力哈的方式只有三种，构造方法  工厂 和 setter
         * 使用了工厂后，徐亚
         */

        IAccountService serv = (IAccountService)Proxy.newProxyInstance(IAccountServivceImpl2.class.getClassLoader(), IAccountServivceImpl2.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                System.out.println("动态代理....");
                try {
                    // 开启事务
                    tx.beginTransaction();

                    // 完成操作
                    rtValue = method.invoke(servcie, args);

                    tx.commit();
                }catch(Exception e) {
                    e.printStackTrace();
                    tx.roolback();
                }finally {
                    tx.release();
                }


                return rtValue;

            }
        });

        return serv;
    }
}
