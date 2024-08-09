package com.zyc.servie.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zyc.entity.Student;
import com.zyc.mapper.StudentMapper;
import com.zyc.servie.StudentService;
import com.zyc.utils.ResultPage;
import com.zyc.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 查询学生分页查询带参数
     *
     * @param page
     * @param pageSize
     * @param studentVO
     * @return
     */
    @Override
    public ResultPage findStudentByPage(Integer page, Integer pageSize, StudentVO studentVO) {
        // 开始分页
        PageHelper.startPage(page, pageSize);
        // 查询所有学生
        List<Student> list = studentMapper.selectAllStudent(studentVO);
        // 风转为page对象
        Page<Student> studentPage = (Page<Student>) list;
        return new ResultPage<>(studentPage.getTotal(), studentPage.getResult());
    }
}
