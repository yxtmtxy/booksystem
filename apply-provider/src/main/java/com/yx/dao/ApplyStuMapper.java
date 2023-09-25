package com.yx.dao;

import com.yx.pojo.ApplyStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyStuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyStu applyStu);

    ApplyStu selectByPrimaryKey(Integer id);

     int updateByPrimaryKey(ApplyStu applyStu);

     List<ApplyStu> queryApplyStuAll(ApplyStu applyStu,Integer stuId,Integer bookId, Integer type);

}