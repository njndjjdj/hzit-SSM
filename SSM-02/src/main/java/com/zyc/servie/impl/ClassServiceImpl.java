package com.zyc.servie.impl;

import com.zyc.entity.Class;
import com.zyc.mapper.ClassMapper;
import com.zyc.servie.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List<Class> findAllClass() {
        List<Class> classList = classMapper.findAllClass();
        return classList;
    }
}
