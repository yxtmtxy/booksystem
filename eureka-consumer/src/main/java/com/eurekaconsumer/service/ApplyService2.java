package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.ApplyStu;
import com.eurekaconsumer.pojo.ApplyTea;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "apply-provider",contextId="Apply")
public interface ApplyService2 {
    //添加新的教材申请教师端
    @RequestMapping("/addApplyTeaSubmit")
    DataInfo addApplyTeaSubmit(@RequestBody ApplyTea applyTea);
    //添加新的教材申请学生端
    @RequestMapping("/addApplyStuSubmit")
    DataInfo addApplyStuSubmit(@RequestBody ApplyStu applyStu);
    //根据id跳转到修改界面教师端
    @GetMapping("/queryApplyTeaById")
    ApplyTea queryApplyTeaById(@RequestParam("id") Integer id);
    //根据id跳转到修改界面学生端
    @GetMapping("/queryApplyStuById")
    ApplyStu queryApplyStuById(@RequestParam("id") Integer id);
    //更改申请信息教师端
    @RequestMapping("/updateApplyTeaSubmit")
    DataInfo updateApplyTeaSubmit(@RequestBody ApplyTea applyTea);
    //更改申请信息学生端
    @RequestMapping("/updateApplyStuSubmit")
    DataInfo updateApplyStuSubmit(@RequestBody ApplyStu applyStu);
    //删除申请信息教师端
    @RequestMapping("/deleteApplyTea")
    DataInfo deleteApplyTea(@RequestParam("ids") String ids);
    //删除申请信息学生端
    @RequestMapping("/deleteApplyStu")
    DataInfo deleteApplyStu(@RequestParam("ids") String ids);








}
