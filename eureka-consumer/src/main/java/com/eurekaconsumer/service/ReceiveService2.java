package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.ReceiveStu;
import com.eurekaconsumer.pojo.ReceiveTea;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "storage-provider",contextId="Receive")
public interface ReceiveService2 {
    //学生端确认收货
    @RequestMapping("/updateReceiveStuSubmit")
    DataInfo updateReceiveStuSubmit(@RequestBody ReceiveStu receiveStu);
    //教师端确认收货
    @RequestMapping("/updateReceiveTeaSubmit")
    DataInfo updateReceiveTeaSubmit(@RequestBody ReceiveTea receiveTea);
}
