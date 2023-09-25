package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.pojo.OfficerInfo;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.service.BaseService2;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController2 {
    @Autowired
    private BaseService2 baseService2;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/updatePassword")
    public String updatePwd(){
        return "updatePwd";
    }

    @RequestMapping("/updatePwdSubmit2")
    @ResponseBody
    public DataInfo updatePwdSubmit(HttpServletRequest request, @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="admin"){
            //管理员
            Admin admin = (Admin)session.getAttribute("user");
            baseService2.updatePwdSubmitAdmin(admin,oldPwd,newPwd);
        }
        else if (session.getAttribute("type")=="officer"){
            //教务处
            OfficerInfo officerInfo = (OfficerInfo) session.getAttribute("user");
            baseService2.updatePwdSubmitOfficer(officerInfo,oldPwd,newPwd);
        }
        else if (session.getAttribute("type")=="teacher"){
            //教师
            TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
            baseService2.updatePwdSubmitTeacher(teacherInfo,oldPwd,newPwd);
        }
        else if (session.getAttribute("type")=="student"){
            //学生
            StudentInfo studentInfo = (StudentInfo) session.getAttribute("user");
            baseService2.updatePwdSubmitStudent(studentInfo,oldPwd,newPwd);
        }
        return DataInfo.ok();
    }
}
