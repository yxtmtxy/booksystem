package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.GradeInfo;
import com.yx.service.GradeInfoService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//班级管理
@Controller
public class GradeInfoController {

    @Autowired
    private GradeInfoService gradeInfoService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/gradeAll")
    @ResponseBody
    public DataInfo queryGradeAll(GradeInfo gradeInfo, @RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<GradeInfo> pageInfo = gradeInfoService.queryGradeInfoAll(gradeInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加页面提交
     */
    @RequestMapping("/addGradeSubmit")
    @ResponseBody
    public DataInfo addGradeSubmit(@RequestBody GradeInfo gradeInfo){
        gradeInfoService.addGradeInfoSubmit(gradeInfo);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryGradeInfoById")
    @ResponseBody
    public GradeInfo queryGradeInfoById(@RequestParam("id") Integer id){
        return gradeInfoService.queryGradeInfoById(id);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateGradeSubmit")
    @ResponseBody
    public DataInfo updateGradeSubmit(@RequestBody GradeInfo gradeInfo){
        gradeInfoService.updateGradeInfoSubmit(gradeInfo);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteGrade")
    @ResponseBody
    public DataInfo deleteGrade(@RequestParam("ids") String ids){
        List<String> list= Arrays.asList(ids.split(","));
        gradeInfoService.deleteGradeInfoByIds(list);
        return DataInfo.ok();
    }

}
