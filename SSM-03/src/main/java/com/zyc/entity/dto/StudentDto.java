package com.zyc.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String sex;
    private Integer cid;
    private String cname;
    private String addr;
}
