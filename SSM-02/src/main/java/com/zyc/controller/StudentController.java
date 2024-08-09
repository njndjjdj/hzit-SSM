package com.zyc.controller;

import com.zyc.servie.StudentService;
import com.zyc.utils.R;
import com.zyc.utils.ResultPage;
import com.zyc.vo.StudentVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@RestController("studentController")
@RequestMapping("/student")
public class StudentController {
    @Resource
    public StudentService studentService;

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findAllStudent/{page}/{pageSize}")
    public R findAllStudent(
            @PathVariable("page") Integer page,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody StudentVO studentVO
    ) {
        ResultPage student = studentService.findStudentByPage(page, pageSize, studentVO);
        return R.ok().data("students", student);
    }
}
