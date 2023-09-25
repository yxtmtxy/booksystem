package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.GradeInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "base-provider",contextId="Grade")
public interface GradeInfoService2 {
    //班级添加
    @RequestMapping("/addGradeSubmit")
    DataInfo addGradeSubmit(@RequestBody GradeInfo gradeInfo);
    //修改界面跳转
    @GetMapping("/queryGradeInfoById")
    GradeInfo queryGradeInfoById(@RequestParam("id") Integer id);
    //班级修改
    @RequestMapping("/updateGradeSubmit")
    DataInfo updateGradeSubmit(@RequestBody GradeInfo gradeInfo);
    //班级删除
    @RequestMapping("/deleteGrade")
    DataInfo deleteGrade(@RequestParam("ids") String ids);
}
