package com.yx.dao;

import com.yx.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order order);
    Order selectByPrimaryKey(Integer id);

    Order select(Integer id,Integer type);

    int updateByPrimaryKey(Order order);

    List<Order> queryOrderAll(Order order);
}