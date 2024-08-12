package com.zyc.mapper;

import com.zyc.entity.po.Classes;
import com.zyc.entity.query.ClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(Classes row);

    int insertSelective(Classes row);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("row") Classes row, @Param("example") ClassesExample example);

    int updateByExample(@Param("row") Classes row, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes row);

    int updateByPrimaryKey(Classes row);

    /**
     * 查询所有班级
     * @return
     */
    List<Classes> findAllClasses();
}