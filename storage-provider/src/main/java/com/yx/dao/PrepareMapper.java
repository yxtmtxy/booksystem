package com.yx.dao;

import com.yx.pojo.Prepare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrepareMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Prepare record);

    Prepare selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKey(Prepare record);

    int updateNum(@Param("num") Integer num);

    List<Prepare> queryPrepareAll(Prepare prepare);

    List<Prepare> showView(Prepare prepare);
}