package com.zyc.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"失败"),
    USERNAME_PASSWORD_ERROR(3,"用户名或密码错误！"),
    USERNAME_ERROR(4,"用户名输入有误！"),
    PASSWORD_ERROR(5,"密码输入有误！"),
    ;

    private Integer code;
    private String message;
}

