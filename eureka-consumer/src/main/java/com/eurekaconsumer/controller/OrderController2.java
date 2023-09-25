package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Order;
import com.eurekaconsumer.pojo.Prepare;
import com.eurekaconsumer.service.OrderService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class OrderController2 {


    @Autowired
    private OrderService2 orderService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/orderIndex")
    public String orderIndex(){
        return "order/orderIndex";
    }

    @GetMapping("/prepareIndex")
    public String prepareIndex(){
        return "order/prepareIndex";
    }

    @RequestMapping("/orderAll")
    @ResponseBody
    public DataInfo queryOrderAll(Order order, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Order> pageInfo = queryService.queryOrderAll(order,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/updateOrderSubmit")
    @ResponseBody
    public DataInfo updateOrderSubmit(@RequestBody Order order){
        return orderService2.updateOrderSubmit(order);
    }

    @RequestMapping("/prepareAll")
    @ResponseBody
    public DataInfo queryPrepareAll(Prepare prepare, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Prepare> pageInfo = queryService.queryPrepareAll(prepare,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping("/queryPrepareByNum")
    @ResponseBody
    public DataInfo queryPrepareByNum(@RequestParam("num") Integer num){
        return orderService2.queryPrepareByNum(num);
    }

    @RequestMapping("/updatePrepare")
    @ResponseBody
    public DataInfo updatePrepareSubmit(@RequestBody Prepare prepare){
        return orderService2.updatePrepareSubmit(prepare);
    }
}

