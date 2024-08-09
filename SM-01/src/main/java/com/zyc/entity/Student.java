package com.zyc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer stuno;
    private String stuname;
    private String classno;
    private Integer age;
    private String sex;
    private String cname;
}
