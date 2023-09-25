package com.yx.controller;

import com.yx.pojo.Admin;
import com.yx.pojo.OfficerInfo;
import com.yx.pojo.StudentInfo;
import com.yx.pojo.TeacherInfo;
import com.yx.service.AdminService;
import com.yx.service.StudentInfoService;
import com.yx.service.OfficerInfoService;
import com.yx.service.TeacherInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//登录验证
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private OfficerInfoService officerService;
    @Autowired
    private TeacherInfoService teacherService;
    @Autowired
    private StudentInfoService studentService;



    @GetMapping("/loginAdmin")
    @ResponseBody
    public Admin queryUserByNameAndPassword1(@RequestParam("username") String username,@RequestParam("password") String password) {
        return adminService.queryUserByNameAndPassword(username,password);
    }

    @GetMapping("/loginOfficerInfo")
    @ResponseBody
    public OfficerInfo queryUserByNameAndPassword2(@RequestParam("username") String username,@RequestParam("password") String password) {
        return officerService.queryUserByNameAndPassword(username,password);
    }

    @GetMapping("/loginTeacherInfo")
    @ResponseBody
    public TeacherInfo queryUserByNameAndPassword3(@RequestParam("username") String username,@RequestParam("password") String password) {
        return teacherService.queryUserByNameAndPassword(username,password);
    }

    @GetMapping("/loginStudentInfo")
    @ResponseBody
    public StudentInfo queryUserByNameAndPassword4(@RequestParam("username") String username,@RequestParam("password") String password) {
        return studentService.queryUserByNameAndPassword(username,password);
    }








}
