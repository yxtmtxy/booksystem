package com.yx.controller;

import com.yx.pojo.Admin;
import com.yx.service.AdminService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//用户帐号密码
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 显示所有用户信息

    @RequestMapping("/adminAll")
    @ResponseBody
    public DataInfo queryAdminAll(Admin admin, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Admin> pageInfo = adminService.queryAdminAll(admin,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }
    */


    /**
     * 添加提交
     */
    @PostMapping("/addAdminSubmit")
    @ResponseBody
    public DataInfo addAdminSubmit(@RequestBody Admin admin){
        adminService.addAdminSubmit(admin);
        return DataInfo.ok();
    }
    /**
     * 修改提交    （待改，改为重置密码）
     */
    @RequestMapping("/updatePwdSubmit")
    @ResponseBody
    public DataInfo updatePwdSubmit(@RequestParam("id") Integer id,@RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd)
    {
        Admin admin = adminService.queryAdminById(id);//根据id查询对象
        if (!oldPwd.equals(admin.getPassword())){
            return DataInfo.fail("输入的旧密码错误");
        }else{
            admin.setPassword(newPwd);
            adminService.updateAdminSubmit(admin);//数据库修改
            return DataInfo.ok();
        }
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public DataInfo deleteAdminByIds(@RequestParam("ids") String ids){
        List<String> list = Arrays.asList(ids.split(","));
        adminService.deleteAdminByIds(list);
        return DataInfo.ok();
    }

}
