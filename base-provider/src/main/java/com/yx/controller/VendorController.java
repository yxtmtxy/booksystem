package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Vendor;
import com.yx.service.VendorService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//供应商信息管理
@Controller
public class VendorController {

    @Autowired
    private VendorService vendorService;


    /**
     * 查询所有数据
     */
    @RequestMapping("/vendorAll")
    @ResponseBody
    public DataInfo queryVendorAll(Vendor vendor, @RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Vendor> pageInfo = vendorService.queryVendorAll(vendor,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加页面提交
     */
    @RequestMapping("/addVendorSubmit")
    @ResponseBody
    public DataInfo addVendorSubmit(@RequestBody Vendor vendor){
        vendorService.addVendorSubmit(vendor);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryVendorById")
    @ResponseBody
    public Vendor queryVendorById(@RequestParam("vendorId") Integer vendorId){
        return vendorService.queryVendorById(vendorId);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateVendorSubmit")
    @ResponseBody
    public DataInfo updateVendorSubmit(@RequestBody Vendor vendor){
        vendorService.updateVendorSubmit(vendor);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteVendor")
    @ResponseBody
    public DataInfo deleteVendor(@RequestParam("vendorIds") String vendorIds){
        List<String> list= Arrays.asList(vendorIds.split(","));
        vendorService.deleteVendorByIds(list);
        return DataInfo.ok();
    }

}
