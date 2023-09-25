package com.yx.dao;


import com.yx.pojo.ReceiveStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiveStuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveStu record);

    ReceiveStu selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ReceiveStu record);

    List<ReceiveStu> queryReceiveStuAll(ReceiveStu receiveStu,Integer stuId,Integer bookId, Integer type);
}