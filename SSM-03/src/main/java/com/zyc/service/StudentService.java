package com.zyc.service;

import com.zyc.entity.dto.StudentDto;
import com.zyc.entity.po.Classes;
import com.zyc.entity.vo.SearchVO;
import com.zyc.utils.ResultPage;

import java.util.List;

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
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<StudentDto> findAllStudent();

    ResultPage<StudentDto> search(Integer page, Integer pageSize, SearchVO vo);
}
