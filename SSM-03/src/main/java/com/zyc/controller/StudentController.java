package com.zyc.controller;

import com.zyc.entity.dto.StudentDto;
import com.zyc.entity.po.Classes;
import com.zyc.entity.vo.SearchVO;
import com.zyc.service.StudentService;
import com.zyc.utils.R;
import com.zyc.utils.ResultPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
@RestController("studentController")
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 查询所有学生
     *
     * @return
     */
    @GetMapping("/findAllStudent")
    public R findAllStudent() {
        List<StudentDto> studentDtoList = studentService.findAllStudent();
        return R.ok().data("studentList", studentDtoList);
    }

    @RequestMapping("/search/{page}/{pageSize}")
    public R search(
            @PathVariable Integer page,
            @PathVariable Integer pageSize,
            @RequestBody SearchVO vo
    ) {
        ResultPage<StudentDto> studentList = studentService.search(page, pageSize, vo);
        return R.ok().data("studentList", studentList);
    }

    /**
     * 根据id查询学生
     *
     * @param id
     * @return
     */
    @RequestMapping("/findStudentById/{id}")
    public R findStudentById(@PathVariable("id") Integer id) {
        StudentDto studentDto = studentService.findStudentById(id);
        return R.ok().data("student", studentDto);
    }

    @RequestMapping("/insertOrUpdateStudent")
    public R addStudent(@RequestBody StudentDto studentDto) {
        String msg = studentService.insertOrUpdateStudent(studentDto);
        return R.ok().message(msg);
    }

    @RequestMapping("/deleteStudentById/{id}")
    public R deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return R.ok();
    }

    @RequestMapping("/deleteAllStudent/{ids}")
    public R deleteAllStudent(@PathVariable("ids") String ids) {
        studentService.deleteAllStudent(ids);
        return R.ok();
    }
}
