package com.zyc.test;

import com.zyc.porxy.dynamic.UserDaoDynamicProxyDemo1;
import com.zyc.porxy.dynamic.UserDaoDynamicProxyDemo2;
import com.zyc.service.UserServiceDao;
import com.zyc.service.impl.UserDaoServiceImpl;
import org.junit.Test;

/**
 * 作者:ZYC
 * DATE:2024/8/13
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
public class TestUserDaoServiceImplDynamicProxy {

    /**
     * jdk动态代理测试
     */
    @Test
    public void test01() {
        UserDaoServiceImpl userDaoService = new UserDaoServiceImpl();
        UserDaoDynamicProxyDemo1 proxyDemo1 = new UserDaoDynamicProxyDemo1(userDaoService);
        UserServiceDao serviceDao = proxyDemo1.createUserServiceDao();
        serviceDao.add();
        serviceDao.query();
    }

    /**
     * CGLIB动态代理测试
     */
    @Test
    public void test02() {
        UserDaoDynamicProxyDemo2 proxyDemo2 = new UserDaoDynamicProxyDemo2();
        UserDaoServiceImpl userServiceDao = proxyDemo2.createUserServiceDao();
        userServiceDao.add();
        userServiceDao.query();
    }
}
