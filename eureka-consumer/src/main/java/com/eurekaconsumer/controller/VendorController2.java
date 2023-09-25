package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Vendor;
import com.github.pagehelper.PageInfo;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.service.VendorService2;
import com.eurekaconsumer.service.queryService;
@Controller

public class VendorController2 {
    @Autowired
    private VendorService2 vendorService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/vendorIndex")
    public String vendorIndex(){
        return "vendor/vendorIndex";
    }

    @RequestMapping("/vendorAdd")
    public String vendorAdd(){
        return "vendor/vendorAdd";
    }

    @RequestMapping("/vendorAll")
    @ResponseBody
    public DataInfo queryVendorAll(Vendor vendor, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Vendor> pageInfo = queryService.queryVendorAll(vendor,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/addVendorSubmit")
    @ResponseBody
    public DataInfo addVendorSubmit(@RequestBody Vendor vendor){
        return vendorService2.addVendorSubmit(vendor);
    }

    @GetMapping("/queryVendorById")
    public String queryVendorById(@RequestParam("vendorId") Integer vendorId, Model model){
        Vendor vendor = vendorService2.queryVendorById(vendorId);
        model.addAttribute("info",vendor);
        return "vendor/updateVendor";
    }

    @RequestMapping("/updateVendorSubmit")
    @ResponseBody
    public DataInfo updateVendorSubmit(@RequestBody Vendor vendor){
        return vendorService2.updateVendorSubmit(vendor);
    }

    @RequestMapping("/deleteVendor")
    @ResponseBody
    public DataInfo deleteVendor(@RequestParam("vendorIds") String vendorIds){
        return vendorService2.deleteVendor(vendorIds);
    }

}
