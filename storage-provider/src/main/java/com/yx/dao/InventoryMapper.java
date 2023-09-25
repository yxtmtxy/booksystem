package com.yx.dao;

import com.yx.pojo.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Inventory record);

    Inventory selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKey(Inventory record);

    List<Inventory> queryInventoryAll(Inventory book);
}