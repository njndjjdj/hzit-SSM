package com.zyc.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 作者:ZYC
 * DATE:2024/8/9
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:演示复杂属性进行赋值
 */
@Data
public class CollectionBean {

    private String[] msg;
    private List<Student> students;
    private Map<Integer, Student> map;
    private Properties properties;


}
