package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.GradeInfo;
import com.eurekaconsumer.service.GradeInfoService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class GradeInfoController2 {

    @Autowired
    private GradeInfoService2 gradeInfoService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/gradeIndex")
    public String gradeIndex(){
        return "grade/gradeIndex";
    }

    @RequestMapping("/gradeAdd")
    public String gradeAdd(){
        return "grade/gradeAdd";
    }

    @RequestMapping("/gradeAll")
    @ResponseBody
    public DataInfo queryGradeAll(GradeInfo gradeInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<GradeInfo> pageInfo = queryService.queryGradeInfoAll(gradeInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/addGradeSubmit")
    @ResponseBody
    public DataInfo addGradeSubmit(@RequestBody GradeInfo gradeInfo){
        return gradeInfoService2.addGradeSubmit(gradeInfo);
    }

    @GetMapping("/queryGradeInfoById")
    public String queryGradeInfoById(@RequestParam("id") Integer id, Model model){
        GradeInfo gradeInfo = gradeInfoService2.queryGradeInfoById(id);
        model.addAttribute("info",gradeInfo);
        return "grade/updateGrade";
    }

    @RequestMapping("/updateGradeSubmit")
    @ResponseBody
    public DataInfo updateGradeSubmit(@RequestBody GradeInfo gradeInfo){
        return gradeInfoService2.updateGradeSubmit(gradeInfo);
    }

    @RequestMapping("/deleteGrade")
    @ResponseBody
    public DataInfo deleteGrade(@RequestParam("ids") String ids){
        return gradeInfoService2.deleteGrade(ids);
    }

}
