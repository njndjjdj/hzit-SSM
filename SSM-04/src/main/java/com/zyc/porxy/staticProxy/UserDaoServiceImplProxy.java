package com.zyc.porxy.staticProxy;

import com.zyc.service.UserServiceDao;

/**
 * 作者:ZYC
 * DATE:2024/8/13
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:静态代理演示
 */
public class UserDaoServiceImplProxy implements UserServiceDao {

    // 目标对象
    private UserServiceDao userServiceDao;

    public UserDaoServiceImplProxy(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;
    }

    @Override
    public void add() {
        userServiceDao.add();
    }

    @Override
    public void query() {
        checkSecurity();
        userServiceDao.query();
    }
    public void checkSecurity(){
        System.out.println("正在进行安全性检查。。。");
    }

}
