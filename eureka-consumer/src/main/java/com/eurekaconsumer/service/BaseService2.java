package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.pojo.OfficerInfo;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "base-provider",contextId="Base")
public interface BaseService2 {
    //右上角用户登录后修改密码管理员端
    @RequestMapping("/updatePwdSubmitAdmin")
    DataInfo updatePwdSubmitAdmin(@RequestBody Admin admin,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd);
    //右上角用户登录后修改密码教务处端
    @RequestMapping("/updatePwdSubmitOfficer")
    DataInfo updatePwdSubmitOfficer(@RequestBody OfficerInfo officerInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd);
    //右上角用户登录后修改密码教师端
    @RequestMapping("/updatePwdSubmitTeacher")
    DataInfo updatePwdSubmitTeacher(@RequestBody TeacherInfo teacherInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd);
    //右上角用户登录后修改密码学生端
    @RequestMapping("/updatePwdSubmitStudent")
    DataInfo updatePwdSubmitStudent(@RequestBody StudentInfo studentInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd);
}
