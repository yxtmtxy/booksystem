package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.service.AdminService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController2 {
    @Autowired
    private AdminService2 adminService2;

    @Autowired
    private queryService queryService;

    //用户帐号密码管理界面跳转
    @GetMapping("/adminIndex")
    public String adminIndex(){
        return "admin/adminIndex";
    }

    //用户帐号信息添加
    @GetMapping("/adminAdd")
    public String adminAdd(){
        return "admin/adminAdd";
    }

    //用户账户信息显示
    @RequestMapping("/adminAll")
    @ResponseBody
    public DataInfo queryAdminAll(Admin admin, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Admin> pageInfo = queryService.queryAdminAll(admin,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    //添加信息提交
    @PostMapping("/addAdminSubmit")
    @ResponseBody
    public DataInfo addAdminSubmit(@RequestBody Admin admin){
        return adminService2.addAdminSubmit(admin);
    }

    //根据用户名更改用户信息
    @GetMapping("/queryAdminById")
    public String queryAdminById(@RequestParam("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "admin/updateAdmin";
    }

    //更改信息提交
    @RequestMapping("/updatePwdSubmit")
    @ResponseBody
    public DataInfo updatePwdSubmit(@RequestParam("id") Integer id,@RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd) {
        return adminService2.updatePwdSubmit(id,oldPwd,newPwd);
    }

    //删除某一条数据
    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public DataInfo deleteAdminByIds(@RequestParam("ids") String ids){
        return adminService2.deleteAdminByIds(ids);
    }

}
