package com.zyc.servier.impl;

import com.zyc.entity.Student;
import com.zyc.mapper.StudentMapper;
import com.zyc.servier.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 查询所有学神
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }
}
