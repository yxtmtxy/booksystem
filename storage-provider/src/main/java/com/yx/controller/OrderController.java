package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.*;
import com.yx.service.InventoryService;
import com.yx.service.OrderService;
import com.yx.service.PrepareService;
import com.yx.service.ReceiveService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ReceiveService receiveService;
    @Autowired
    private InventoryService inventoryService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/orderAll")
    @ResponseBody
    public DataInfo queryOrderAll(Order order, @RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Order> pageInfo = orderService.queryOrderAll(order,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateOrderSubmit")
    @ResponseBody
    public DataInfo updateOrderSubmit(@RequestBody Order order){
        LocalDateTime date = LocalDateTime.now();
        Date now = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        Integer id = order.getId();
        if(order.getType()==0){
            ReceiveTea receiveTea=receiveService.queryReceiveTeaById(id);
            receiveTea.setType(1);
            receiveService.updateReceiveTeaSubmit(receiveTea);
        }
        if(order.getType()==1){
            ReceiveStu receiveStu=receiveService.queryReceiveStuById(id);
            receiveStu.setType(1);
            receiveService.updateReceiveStuSubmit(receiveStu);
        }
        Prepare prepare=prepareService.queryPrepareById(order.getBookId());
        prepare.setNeedNum(prepare.getNeedNum()-order.getNumber());
        prepareService.updatePrepareSubmit(prepare);

        Inventory inventory = inventoryService.queryInventoryById(order.getBookId());
        Integer number1=order.getStore()-order.getNumber();
        inventory.setNumber(number1);
        inventory.setSum(number1*inventory.getPrice());

        inventoryService.updateInventorySubmit(inventory);
        
        order.setStore(order.getStore()-order.getNumber());
        order.setState(1);
        order.setStartDate(now);
        orderService.updateOrderSubmit(order);
        return DataInfo.ok();
    }

    @Autowired
    private PrepareService prepareService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/prepareAll")
    @ResponseBody
    public DataInfo queryPrepareAll(Prepare prepare, @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Prepare> pageInfo = prepareService.queryPrepareAll(prepare,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/queryPrepareByNum")
    @ResponseBody
    public DataInfo queryPrepareByNum(@RequestParam("num") Integer num){
        prepareService.updateNum(num);
        return DataInfo.ok();
    }

    @RequestMapping("/updatePrepare")
    @ResponseBody
    public DataInfo updatePrepareSubmit(@RequestBody Prepare prepare){
        prepareService.updatePrepareSubmit(prepare);
        return DataInfo.ok();
    }




}
