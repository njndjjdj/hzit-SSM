package com.zyc.test;

import com.zyc.service.UserServiceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springCon/spring-aop2.xml")
public class TestAopByAnnotation {
    @Autowired
    private UserServiceDao userServiceDao;

    @Test
    public void test() {
        userServiceDao.add();
        userServiceDao.query();
    }
}
