package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.StudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;

@Component
@FeignClient(value = "base-provider",contextId="Student")
public interface StudentInfoService2 {
    //添加学生信息
    @RequestMapping("/addStudentSubmit")
    DataInfo addStudentSubmit(@RequestBody StudentInfo studentInfo);
    //修改界面跳转
    @GetMapping("/queryStudentInfoById")
    StudentInfo queryStudentInfoById(@RequestParam("stuId") Integer stuId);
    //修改学生信息
    @RequestMapping("/updateStudentSubmit")
    DataInfo updateStudentSubmit(@RequestBody StudentInfo studentInfo);
    //删除学生信息
    @RequestMapping("/deleteStudent")
    DataInfo deleteStudent(@RequestParam("stuIds") String stuIds);

}
