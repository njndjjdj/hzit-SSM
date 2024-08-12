package com.zyc.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zyc.entity.dto.StudentDto;
import com.zyc.entity.po.Classes;
import com.zyc.entity.po.Students;
import com.zyc.entity.query.StudentsExample;
import com.zyc.entity.vo.SearchVO;
import com.zyc.mapper.ClassesMapper;
import com.zyc.mapper.StudentsMapper;
import com.zyc.service.StudentService;
import com.zyc.utils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 作者:ZYC
 * DATE:2024/8/12
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {


    @Resource
    private StudentsMapper studentsMapper;
    @Resource
    private ClassesMapper classesMapper;

    /**
     * 查询所有学生
     *
     * @return
     */
    @Override
    public List<StudentDto> findAllStudent() {
        List<Students> studentsList = studentsMapper.findAllStudent();

        List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
        // 属性拷贝
        for (Students students : studentsList) {
            StudentDto studentDto = new StudentDto();
            BeanUtil.copyProperties(students, studentDto);
            studentDtoList.add(studentDto);
        }
        // 存入班级名字
        List<Classes> classesList = classesMapper.findAllClasses();
        getCname(studentDtoList, classesList);
        return studentDtoList;
    }

    private static void getCname(List<StudentDto> studentDtoList, List<Classes> classesList) {
        for (StudentDto studentDto : studentDtoList) {
            for (Classes classes : classesList) {
                if (studentDto.getCid().equals(classes.getClassId())) {
                    studentDto.setCname(classes.getClassName());
                }
            }
            String sex = studentDto.getSex().equals("M") ? "男" : "女";
            studentDto.setSex(sex);
        }
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @param vo
     * @return
     */
    @Override
    public ResultPage<StudentDto> search(Integer page, Integer pageSize, SearchVO vo) {
        PageHelper.startPage(page, pageSize);
        // 开始条件查询
        StudentsExample example = new StudentsExample();
        StudentsExample.Criteria criteria = example.createCriteria();
        // 2.3 封装查询条件并开始查询
        if (vo != null) {
            if (StrUtil.isNotBlank(vo.getStudentName())) {
                criteria.andStudentNameLike("%" + vo.getStudentName() + "%");
            }
            if (vo.getStudentId() != null && vo.getStudentId() != 0) {
                criteria.andStudentIdEqualTo(vo.getStudentId());
            }
            if (vo.getCid() != null && vo.getCid() != 0) {
                criteria.andCidEqualTo(vo.getCid());
            }
        }
        List<Students> students = studentsMapper.selectByExample(example);
        Page<Students> studentPage = (Page<Students>) students;
        List<StudentDto> collect = studentPage.getResult().stream().map(m -> {
            StudentDto dto = new StudentDto();
            // 将m（Student）对象根据属性名（忽略大小写）复制到vo对象中
            BeanUtil.copyProperties(m, dto);
            return dto;
        }).collect(Collectors.toList());
        List<Classes> classesList = classesMapper.findAllClasses();
        getCname(collect, classesList);
        return new ResultPage<>(studentPage.getTotal(), collect);
    }
}
