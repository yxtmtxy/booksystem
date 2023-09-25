package com.yx.dao;

import com.yx.pojo.ReceiveTea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiveTeaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveTea record);

    ReceiveTea selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ReceiveTea record);

    List<ReceiveTea> queryReceiveTeaAll(ReceiveTea receiveTea,Integer teaId,Integer bookId, Integer type);
}