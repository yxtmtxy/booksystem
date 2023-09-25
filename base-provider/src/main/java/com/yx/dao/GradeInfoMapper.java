package com.yx.dao;

import com.yx.pojo.GradeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeInfoMapper {

    int insert(GradeInfo gradeInfo);

    int deleteById(Integer id);

    GradeInfo selectById(Integer id);

    int updateById(GradeInfo gradeInfo);

    List<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo);

}