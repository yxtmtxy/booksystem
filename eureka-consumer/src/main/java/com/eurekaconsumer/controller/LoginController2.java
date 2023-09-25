package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Admin;
import com.eurekaconsumer.pojo.OfficerInfo;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.service.LoginService2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController2 {
    @Autowired
    private LoginService2 loginService2;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//注销
        return "/login";
    }

    @HystrixCommand(
            fallbackMethod = "Fallback",
            commandProperties={
            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="4"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="3000")
            }
    )
    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model) {
        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        //判断用户名和密码
        if (type.equals("0")) {//管理员信息
            //用户名和密码是否正确
            Admin admin = loginService2.queryUserByNameAndPassword1(username, password);
            if (admin == null) {//该用户不存在
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
            session.setAttribute("user", admin);
            session.setAttribute("type", "admin");
        }
        else if (type.equals("1")) {//教务处信息
            OfficerInfo officerInfo = loginService2.queryUserByNameAndPassword2(username, password);
            if (officerInfo == null) {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
            session.setAttribute("user", officerInfo);
            session.setAttribute("type", "officer");
        }
        else if (type.equals("2")) {//教师信息表
            TeacherInfo teacherInfo = loginService2.queryUserByNameAndPassword3(username, password);
            if (teacherInfo == null) {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
            session.setAttribute("user", teacherInfo);
            session.setAttribute("type", "teacher");
            session.setAttribute("username", username);
        }
        else if (type.equals("3")) {//学生信息表
            StudentInfo studentInfo = loginService2.queryUserByNameAndPassword4(username, password);
            if (studentInfo == null) {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
            session.setAttribute("user", studentInfo);
            session.setAttribute("type", "student");
            session.setAttribute("username", username);
        }
        return "index";
    }


    @GetMapping("/Fallback")
    public String Fallback(HttpServletRequest request,Model model) {
        model.addAttribute("msg", "Hystrix:There is an error");
        return "login";
    }



}
