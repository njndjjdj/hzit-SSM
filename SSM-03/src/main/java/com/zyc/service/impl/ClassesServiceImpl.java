package com.zyc.service.impl;

import com.zyc.entity.po.Classes;
import com.zyc.mapper.ClassesMapper;
import com.zyc.service.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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
@Service("classesServiceImpl")
public class ClassesServiceImpl implements ClassesService {

    @Resource
    private ClassesMapper classesMapper;

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List<Classes> findAllClasses() {
        return classesMapper.findAllClasses();
    }
}
