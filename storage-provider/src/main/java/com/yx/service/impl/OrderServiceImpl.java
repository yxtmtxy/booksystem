package com.yx.service.impl;
import com.yx.dao.OrderMapper;
import com.yx.pojo.Order;
import com.yx.service.OrderService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper OrderMapper;

    @Override
    public PageInfo<Order> queryOrderAll(Order order, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Order> OrderList = OrderMapper.queryOrderAll(order);
        return new PageInfo<>(OrderList) ;
    }

    @Override
    public Order queryOrderById(Integer id) {
        return OrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Order queryOrder(Integer id,Integer type){
        return OrderMapper.select(id,type);
    }

    @Override
    public void updateOrderSubmit(Order Order) {
        OrderMapper.updateByPrimaryKey(Order);
    }

    @Override
    public void deleteOrderByIds(List<String> ids) {
        for (String id : ids){
            OrderMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
