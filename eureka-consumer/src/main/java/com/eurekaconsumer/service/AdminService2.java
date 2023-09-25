package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "base-provider",contextId="Admin")
//value服务消费端名称base-provider
public interface AdminService2 {
    //添加新用户
    @PostMapping("/addAdminSubmit")
    DataInfo addAdminSubmit(@RequestBody Admin admin);
    //更改用户密码
    @RequestMapping("/updatePwdSubmit")
    DataInfo updatePwdSubmit(@RequestParam("id") Integer id, @RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd);
    //删除指定用户
    @RequestMapping("/deleteAdminByIds")
    DataInfo deleteAdminByIds(@RequestParam("ids") String ids);
}
