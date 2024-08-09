package com.zyc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
@Component
public class Student {
    private int id;
    private String name;
    private int age;

    public void hello() {
        System.out.println("你好呀，我刚被创建");
    }

    public void bye() {
        System.out.println("再见啦，我呀被销毁了");
    }
}
