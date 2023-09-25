package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.pojo.OfficerInfo;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "base-provider",contextId="Login")
public interface LoginService2 {
    //管理员登录
    @GetMapping("/loginAdmin")
    Admin queryUserByNameAndPassword1(@RequestParam("username") String username,@RequestParam("password") String password);
    //教务处登录
    @GetMapping("/loginOfficerInfo")
    OfficerInfo queryUserByNameAndPassword2(@RequestParam("username") String username,@RequestParam("password") String password);
    //教师登录
    @GetMapping("/loginTeacherInfo")
    TeacherInfo queryUserByNameAndPassword3(@RequestParam("username") String username,@RequestParam("password") String password);
    //学生登录
    @GetMapping("/loginStudentInfo")
    StudentInfo queryUserByNameAndPassword4(@RequestParam("username") String username,@RequestParam("password") String password);

}
