package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.AuditStu;
import com.eurekaconsumer.pojo.AuditTea;
import com.eurekaconsumer.service.AuditService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class AuditController2 {

    @Autowired
    private AuditService2 auditService2;
    @Autowired
    private queryService queryService;

    /**
     * 跳转读者管理页面
     */
    @GetMapping("/auditStuIndex")
    public String auditStuIndex(){
        return "audit/auditStuIndex";
    }
    /**
     * 跳转读者管理页面
     */
    @GetMapping("/auditTeaIndex")
    public String auditTeaIndex(){
        return "audit/auditTeaIndex";
    }

    @RequestMapping("/auditStuAll")
    @ResponseBody
    public DataInfo queryAuditStuAll(AuditStu auditStu, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<AuditStu> pageInfo = queryService.queryAuditStuAll(auditStu,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping("/auditTeaAll")
    @ResponseBody
    public DataInfo queryAuditTeaAll(AuditTea auditTea, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<AuditTea> pageInfo = queryService.queryAuditTeaAll(auditTea,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/updateAuditStuSubmit1")
    @ResponseBody
    public DataInfo updateAuditStuSubmit1(@RequestBody AuditStu auditStu){
        return auditService2.updateAuditStuSubmit1(auditStu);
    }

    @RequestMapping("/updateAuditStuSubmit2")
    @ResponseBody
    public DataInfo updateAuditStuSubmit2(@RequestBody AuditStu auditStu){
        return auditService2.updateAuditStuSubmit2(auditStu);
    }

    @RequestMapping("/updateAuditTeaSubmit1")
    @ResponseBody
    public DataInfo updateAuditTeaSubmit(@RequestBody AuditTea auditTea){
        return auditService2.updateAuditTeaSubmit(auditTea);
    }

    @RequestMapping("/updateAuditTeaSubmit2")
    @ResponseBody
    public DataInfo updateAuditTeaSubmit2(@RequestBody AuditTea auditTea){
        return auditService2.updateAuditTeaSubmit2(auditTea);
    }
}
