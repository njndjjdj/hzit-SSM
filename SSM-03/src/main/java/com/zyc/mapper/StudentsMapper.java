package com.zyc.mapper;

import com.zyc.entity.po.Students;
import com.zyc.entity.query.StudentsExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentsMapper {
    long countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(Students row);

    int insertSelective(Students row);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("row") Students row, @Param("example") StudentsExample example);

    int updateByExample(@Param("row") Students row, @Param("example") StudentsExample example);

    int updateByPrimaryKeySelective(Students row);

    int updateByPrimaryKey(Students row);

    /**
     * 查询所有班级
     * @return
     */
    List<Students> findAllStudent();

    void deleteAllStudent(@Param("studentIds") ArrayList<Integer> studentIds);
}