package com.zyc.controller;

import com.zyc.entity.Class;
import com.zyc.servie.ClassService;
import com.zyc.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RestController("classController")
@RequestMapping("/class")
public class ClassController {

    @Resource
    private ClassService classService;

    @RequestMapping("/findAllClass")
    public R findAllClass() {
        List<Class> classList = classService.findAllClass();
        return R.ok().data("class",classList);
    }
}
