package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "base-provider",contextId="Teacher")
public interface TeacherInfoService2 {
    //教师信息添加
    @RequestMapping("/addTeacherSubmit")
    DataInfo addTeacherSubmit(@RequestBody  TeacherInfo teacherInfo);
    //修改界面跳转
    @GetMapping("/queryTeacherInfoById")
    TeacherInfo queryTeacherInfoById(@RequestParam("teaId") Integer teaId);
    //教师信息更新
    @RequestMapping("/updateTeacherSubmit")
    DataInfo updateTeacherSubmit(@RequestBody TeacherInfo teacherInfo);
    //教师信息删除
    @RequestMapping("/deleteTeacher")
    DataInfo deleteTeacher(@RequestParam("teaIds") String teaIds);


}
