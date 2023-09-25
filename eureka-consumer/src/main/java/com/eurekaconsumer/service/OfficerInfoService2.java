package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.OfficerInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "base-provider",contextId="Officer")
public interface OfficerInfoService2 {
    //教务处添加
    @RequestMapping("/addOfficerSubmit")
    DataInfo addOfficerSubmit(@RequestBody OfficerInfo officerInfo);
    //修改界面跳转
    @GetMapping("/queryOfficerInfoById")
    OfficerInfo queryOfficerInfoById(@RequestParam("offId") Integer offId);
    //教务处信息修改
    @RequestMapping("/updateOfficerSubmit")
    DataInfo updateOfficerSubmit(@RequestBody OfficerInfo officerInfo);
    //教务处信息删除
    @RequestMapping("/deleteOfficer")
    DataInfo deleteOfficer(@RequestParam("offIds") String offIds);




}
