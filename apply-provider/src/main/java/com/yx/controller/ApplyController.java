package com.yx.controller;

import com.yx.pojo.ApplyStu;
import com.yx.pojo.ApplyTea;
import com.yx.service.ApplyService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//教师。学生提交申请信息
@Controller
public class ApplyController {

    @Autowired
    private ApplyService ApplyService;

    /**
     * 添加页面提交1
     */
    @RequestMapping("/addApplyTeaSubmit")
    @ResponseBody
    public DataInfo addApplyTeaSubmit(@RequestBody ApplyTea applyTea){
        ApplyService.addApplyTeaSubmit(applyTea);
        return DataInfo.ok();
    }

    /**
     * 添加页面提交2
     */
    @RequestMapping("/addApplyStuSubmit")
    @ResponseBody
    public DataInfo addApplyStuSubmit(@RequestBody ApplyStu applyStu){
        ApplyService.addApplyStuSubmit(applyStu);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面1
     */
    @GetMapping("/queryApplyTeaById")
    @ResponseBody
    public ApplyTea queryApplyTeaById(@RequestParam("id") Integer id){
        return ApplyService.queryApplyTeaById(id);
    }

    /**
     * 根据id查询数据再跳转到修改页面2
     */
    @GetMapping("/queryApplyStuById")
    @ResponseBody
    public ApplyStu queryApplyStuById(@RequestParam("id") Integer id){
        return ApplyService.queryApplyStuById(id);
    }

    /**
     * 修改提交1
     */
    @RequestMapping("/updateApplyTeaSubmit")
    @ResponseBody
    public DataInfo updateApplyTeaSubmit(@RequestBody ApplyTea applyTea){
        ApplyService.updateApplyTeaSubmit(applyTea);
        return DataInfo.ok();
    }
    /**
     * 修改提交2
     */
    @RequestMapping("/updateApplyStuSubmit")
    @ResponseBody
    public DataInfo updateApplyStuSubmit(@RequestBody ApplyStu applyStu){
        ApplyService.updateApplyStuSubmit(applyStu);
        return DataInfo.ok();
    }
    /**
     * 删除1
     */
    @RequestMapping("/deleteApplyTea")
    @ResponseBody
    public DataInfo deleteApplyTea(@RequestParam("ids") String ids){
        List<String> list= Arrays.asList(ids.split(","));
        ApplyService.deleteApplyTeaByIds(list);
        return DataInfo.ok();
    }
    /**
     * 删除2
     */
    @RequestMapping("/deleteApplyStu")
    @ResponseBody
    public DataInfo deleteApplyStu(@RequestParam("ids") String ids){
        List<String> list= Arrays.asList(ids.split(","));
        ApplyService.deleteApplyStuByIds(list);
        return DataInfo.ok();
    }

}
