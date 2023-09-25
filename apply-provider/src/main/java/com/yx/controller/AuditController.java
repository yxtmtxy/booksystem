package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.AuditStu;
import com.yx.pojo.ApplyStu;
import com.yx.pojo.ApplyTea;
import com.yx.pojo.AuditTea;
import com.yx.service.AuditService;
import com.yx.service.ApplyService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//教务处审核教师和学生申请信息
@Controller
public class AuditController {

    @Autowired
    private AuditService auditService;
    @Autowired
    private ApplyService applyService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/auditStuAll")
    @ResponseBody
    public DataInfo queryAuditStuAll(AuditStu auditStu, @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<AuditStu> pageInfo = auditService.queryAuditStuAll(auditStu,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }
    /**
     * 查询所有数据
     */
    @RequestMapping("/auditTeaAll")
    @ResponseBody
    public DataInfo queryAuditTeaAll(AuditTea auditTea, @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<AuditTea> pageInfo = auditService.queryAuditTeaAll(auditTea,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 修改提交学生
     */
    @RequestMapping("/updateAuditStuSubmit1")
    @ResponseBody
    public DataInfo updateAuditStuSubmit1(@RequestBody AuditStu auditStu){
        ApplyStu applyStu =  applyService.queryApplyStuById(auditStu.getId());
        applyStu.setType(1);
        applyService.updateApplyStuSubmit(applyStu);
        return DataInfo.ok();
    }
    @RequestMapping("/updateAuditStuSubmit2")
    @ResponseBody
    public DataInfo updateAuditStuSubmit2(@RequestBody AuditStu auditStu){
        ApplyStu applyStu =  applyService.queryApplyStuById(auditStu.getId());
        applyStu.setType(2);
        applyService.updateApplyStuSubmit(applyStu);
        return DataInfo.ok();
    }
    /**
     * 修改提交教师
     */
    @RequestMapping("/updateAuditTeaSubmit1")
    @ResponseBody
    public DataInfo updateAuditTeaSubmit(@RequestBody AuditTea auditTea){
        Integer id1=auditTea.getId();
        ApplyTea applyTea = applyService.queryApplyTeaById(id1);
        applyTea.setType(1);
        applyService.updateApplyTeaSubmit(applyTea);
        return DataInfo.ok();
    }

    @RequestMapping("/updateAuditTeaSubmit2")
    @ResponseBody
    public DataInfo updateAuditTeaSubmit2(@RequestBody AuditTea auditTea){
        Integer id2=auditTea.getId();
        ApplyTea applyTea = applyService.queryApplyTeaById(id2);
        applyTea.setType(2);
        applyService.updateApplyTeaSubmit(applyTea);
        return DataInfo.ok();
    }


}
