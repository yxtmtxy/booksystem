package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Vendor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "base-provider",contextId="Vendor")
public interface VendorService2 {
    //供应商信息添加
    @RequestMapping("/addVendorSubmit")
    DataInfo addVendorSubmit(@RequestBody Vendor vendor);
    //修改界面跳转
    @GetMapping("/queryVendorById")
    Vendor queryVendorById(@RequestParam("vendorId") Integer vendorId);
    //修改信息提交
    @RequestMapping("/updateVendorSubmit")
    DataInfo updateVendorSubmit(@RequestBody Vendor vendor);
    //供应商删除
    @RequestMapping("/deleteVendor")
    DataInfo deleteVendor(@RequestParam("vendorIds") String vendorIds);
}
