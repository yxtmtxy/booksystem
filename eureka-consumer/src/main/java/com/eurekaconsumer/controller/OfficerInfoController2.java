package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.OfficerInfo;
import com.github.pagehelper.PageInfo;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.service.OfficerInfoService2;
import com.eurekaconsumer.service.queryService;
@Controller
public class OfficerInfoController2 {

    @Autowired
    private OfficerInfoService2 officerInfoService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/officerIndex")
    public String officerIndex(){
        return "officer/officerIndex";
    }

    @RequestMapping("/officerAll")
    @ResponseBody
    public DataInfo queryOfficerAll(OfficerInfo officerInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<OfficerInfo> pageInfo = queryService.queryOfficerInfoAll(officerInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/officerAdd")
    public String officerAdd(){
        return "officer/officerAdd";
    }

    @RequestMapping("/addOfficerSubmit")
    @ResponseBody
    public DataInfo addOfficerSubmit(@RequestBody OfficerInfo officerInfo){
        return officerInfoService2.addOfficerSubmit(officerInfo);
    }

    @GetMapping("/queryOfficerInfoById")
    public String queryOfficerInfoById(@RequestParam("offId") Integer offId, Model model)
    {
        OfficerInfo officerInfo = officerInfoService2.queryOfficerInfoById(offId);
        model.addAttribute("info",officerInfo);
        return "officer/updateOfficer";
    }

    @RequestMapping("/updateOfficerSubmit")
    @ResponseBody
    public DataInfo updateOfficerSubmit(@RequestBody OfficerInfo officerInfo){
        return officerInfoService2.updateOfficerSubmit(officerInfo);
    }

    @RequestMapping("/deleteOfficer")
    @ResponseBody
    public DataInfo deleteOfficer(@RequestParam("offIds") String offIds){
        return officerInfoService2.deleteOfficer(offIds);
    }


}
