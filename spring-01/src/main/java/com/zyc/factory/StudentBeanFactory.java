package com.zyc.factory;

import com.zyc.entity.Student;

/**
 * 作者:ZYC
 * DATE:2024/8/9
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
public class StudentBeanFactory {

    public Student getStudent() {
        return new Student();
    }

    public static Student getStu() {
        return new Student();
    }
}
