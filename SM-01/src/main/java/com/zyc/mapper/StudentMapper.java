package com.zyc.mapper;

import com.zyc.entity.Student;

import java.util.List;

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
public interface StudentMapper {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAllStudent();
}
