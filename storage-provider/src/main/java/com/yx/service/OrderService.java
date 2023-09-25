package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Order;

import java.util.List;

public interface OrderService {

    /**
     * 查询所有信息（分页）
     */
    PageInfo<Order> queryOrderAll(Order order,Integer pageNum,Integer limit);


    /**
     * 根据id查询（修改）
     */
    Order queryOrderById(Integer id);


    Order queryOrder(Integer id,Integer type);
    /**
     * 修改提交
     */
    void updateOrderSubmit(Order order);

    /**
     * 删除
     */
    void deleteOrderByIds(List<String> ids);

}