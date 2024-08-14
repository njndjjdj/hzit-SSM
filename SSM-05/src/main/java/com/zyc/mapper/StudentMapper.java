package com.zyc.mapper;

import org.apache.ibatis.annotations.Param;

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
public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(Student row);

    int insertSelective(Student row);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("row") Student row, @Param("example") StudentExample example);

    int updateByExample(@Param("row") Student row, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student row);

    int updateByPrimaryKey(Student row);
}
