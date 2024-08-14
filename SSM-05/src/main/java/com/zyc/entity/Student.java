package com.zyc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 作者:ZYC
 * DATE:2024/8/14
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    private Long sid;

    private String sname;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    private Integer deleted;

    private Date createTime;

    private Date updateTime;


}