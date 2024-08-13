package com.zyc.test;

import com.zyc.porxy.staticProxy.UserDaoServiceImplProxy;
import com.zyc.service.UserServiceDao;
import com.zyc.service.impl.UserDaoServiceImpl;
import org.junit.Before;
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
public class TestUserDaoServiceImplStaticProxy {

    private UserServiceDao userServiceDao;

    @Before
    public void init() {
        userServiceDao = new UserDaoServiceImpl();
    }

    @Test
    public void test() {
        // 构造代理对象
        UserDaoServiceImplProxy proxy = new UserDaoServiceImplProxy(userServiceDao);
        proxy.add();
        proxy.query();
    }
}
