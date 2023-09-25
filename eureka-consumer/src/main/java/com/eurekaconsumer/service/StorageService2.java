package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Storage;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "storage-provider",contextId="Storage")
public interface StorageService2 {
    //入库登记
    @RequestMapping("/addStorageSubmit")
    DataInfo addStorageSubmit(@RequestBody Storage storage);
    //跳转修改界面
    @GetMapping("/queryStorageById")
    Storage queryStorageById(@RequestParam("id") Integer id);
    //入库修改
    @RequestMapping("/updateStorageSubmit")
    DataInfo updateStorageSubmit(@RequestBody Storage storage);
    //删除入库记录
    @RequestMapping("/deleteStorage")
    DataInfo deleteStorage(@RequestParam("ids") String ids);
}
