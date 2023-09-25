package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Order;
import com.eurekaconsumer.pojo.Prepare;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "storage-provider",contextId="Order")
public interface OrderService2 {
    //教材发放
    @RequestMapping("/updateOrderSubmit")
    DataInfo updateOrderSubmit(@RequestBody Order order);
    //教材订购推荐
    @RequestMapping("/queryPrepareByNum")
    DataInfo queryPrepareByNum(@RequestParam("num") Integer num);
    //教材订购推荐修改
    @RequestMapping("/updatePrepare")
    DataInfo updatePrepareSubmit(@RequestBody Prepare prepare);

}
