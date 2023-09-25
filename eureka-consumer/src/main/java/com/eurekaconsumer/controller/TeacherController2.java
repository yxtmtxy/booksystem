package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.service.TeacherInfoService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class TeacherController2 {

    @Autowired
    private TeacherInfoService2 teacherInfoService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/teacherIndex")
    public String teacherIndex(){
        return "teacher/teacherIndex";
    }

    @RequestMapping("/teacherAll")
    @ResponseBody
    public DataInfo queryTeacherAll(TeacherInfo teacherInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<TeacherInfo> pageInfo = queryService.queryTeacherInfoAll(teacherInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping("/teacherAdd")
    public String teacherAdd(){
        return "teacher/teacherAdd";
    }

    @RequestMapping("/addTeacherSubmit")
    @ResponseBody
    public DataInfo addTeacherSubmit(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService2.addTeacherSubmit(teacherInfo);
    }

    @GetMapping("/queryTeacherInfoById")
    public String queryTeacherInfoById(@RequestParam("teaId") Integer teaId, Model model){
        TeacherInfo teacherInfo = teacherInfoService2.queryTeacherInfoById(teaId);
        model.addAttribute("info",teacherInfo);
        return "teacher/updateTeacher";
    }

    @RequestMapping("/updateTeacherSubmit")
    @ResponseBody
    public DataInfo updateTeacherSubmit(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService2.updateTeacherSubmit(teacherInfo);
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public DataInfo deleteTeacher(@RequestParam("teaIds") String teaIds){
        return teacherInfoService2.deleteTeacher(teaIds);
    }

    //登录后显示个人信息
    @RequestMapping("/teaInfo")
    public String findTea(HttpServletRequest request, Map<String, Object> map){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="teacher"){
            TeacherInfo teacherInfo =(TeacherInfo) session.getAttribute("user");
            map.put("teaId",teacherInfo.getTeaId());
            map.put("teaName",teacherInfo.getTeaName());
            map.put("teaSex",teacherInfo.getTeaSex());
            map.put("teaFaculty",teacherInfo.getTeaFaculty());
            map.put("teaPhone",teacherInfo.getTeaPhone());
        }
        return "teacher/teaInfo";
    }









}
