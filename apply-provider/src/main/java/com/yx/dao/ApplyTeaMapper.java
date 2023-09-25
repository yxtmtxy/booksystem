package com.yx.dao;

import com.yx.pojo.ApplyTea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyTeaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyTea applyTea);

    ApplyTea selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ApplyTea applyTea);

    List<ApplyTea> queryApplyTeaAll(ApplyTea applyTea,Integer teaId,Integer bookId, Integer type);
}