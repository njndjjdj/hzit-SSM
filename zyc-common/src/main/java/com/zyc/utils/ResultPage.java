package com.zyc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/5
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
public class ResultPage<T> {
    // 总记录数
    private Long total;
    // 结果集
    private List<T> result;
}
