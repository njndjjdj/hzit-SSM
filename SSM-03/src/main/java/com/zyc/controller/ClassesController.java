package com.zyc.controller;

import com.zyc.entity.po.Classes;
import com.zyc.service.ClassesService;
import com.zyc.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController("classesController")
@RequestMapping("/classes")
public class ClassesController {

    @Resource
    private ClassesService classesService;

    /**
     * 查询所有班级
     * @return
     */
    @RequestMapping("/findAllClasses")
    public R findAllClasses() {
        List<Classes> classList = classesService.findAllClasses();
        return R.ok().data("classList", classList);
    }
}
