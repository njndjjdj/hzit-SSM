package com.zyc.service.impl;

import com.zyc.service.UserServiceDao;
import org.springframework.stereotype.Service;

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
@Service
public class UserDaoServiceImpl implements UserServiceDao {
    @Override
    public void add() {
        System.out.println("add....");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}
