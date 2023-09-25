package com.yx.controller;

import com.yx.pojo.Order;
import com.yx.pojo.ReceiveStu;
import com.yx.pojo.ReceiveTea;
import com.yx.service.OrderService;
import com.yx.service.ReceiveService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ReceiveController {

    @Autowired
    private ReceiveService receiveService;
    @Autowired
    private OrderService orderService;

    /**
     * 修改提交
     */
    @RequestMapping("/updateReceiveStuSubmit")
    @ResponseBody
    public DataInfo updateReceiveStuSubmit(@RequestBody ReceiveStu receiveStu){
        Order order = orderService.queryOrder(receiveStu.getId(),1);
        order.setState(2);
        receiveStu.setType(2);
        orderService.updateOrderSubmit(order);
        receiveService.updateReceiveStuSubmit(receiveStu);
        return DataInfo.ok();
    }
    /**
     * 修改提交
     */
    @RequestMapping("/updateReceiveTeaSubmit")
    @ResponseBody
    public DataInfo updateReceiveTeaSubmit(@RequestBody ReceiveTea receiveTea){
        Order order = orderService.queryOrder(receiveTea.getId(),0);
        order.setState(2);
        receiveTea.setType(2);
        orderService.updateOrderSubmit(order);
        receiveService.updateReceiveTeaSubmit(receiveTea);
        return DataInfo.ok();
    }


}
