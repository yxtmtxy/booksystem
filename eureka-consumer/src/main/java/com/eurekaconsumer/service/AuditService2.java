package com.eurekaconsumer.service;


import com.eurekaconsumer.pojo.AuditStu;
import com.eurekaconsumer.pojo.AuditTea;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "apply-provider",contextId="Audit")
public interface AuditService2 {
    //教务处审核申请信息通过学生端
    @RequestMapping("/updateAuditStuSubmit1")
    DataInfo updateAuditStuSubmit1(@RequestBody AuditStu auditStu);
    //教务处审核申请信息驳回学生端
    @RequestMapping("/updateAuditStuSubmit2")
    DataInfo updateAuditStuSubmit2(@RequestBody AuditStu auditStu);
    //教务处审核申请信息通过教师端
    @RequestMapping("/updateAuditTeaSubmit1")
    DataInfo updateAuditTeaSubmit(@RequestBody AuditTea auditTea);
    //教务处审核申请信息驳回教师端
    @RequestMapping("/updateAuditTeaSubmit2")
    DataInfo updateAuditTeaSubmit2(@RequestBody AuditTea auditTea);




}
