package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.service.StudentInfoService2;
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
public class StudentInfoController2 {
    @Autowired
    private StudentInfoService2 studentInfoService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/studentIndex")
    public String studentIndex(){
        return "student/studentIndex";
    }

    @RequestMapping("/studentAll")
    @ResponseBody
    public DataInfo queryStudentAll(StudentInfo studentInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<StudentInfo> pageInfo = queryService.queryStudentInfoAll(studentInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/studentAdd")
    public String studentAdd(){
        return "student/studentAdd";
    }

    @RequestMapping("/addStudentSubmit")
    @ResponseBody
    public DataInfo addStudentSubmit(@RequestBody  StudentInfo studentInfo){
        return studentInfoService2.addStudentSubmit(studentInfo);
    }

    @GetMapping("/queryStudentInfoById")
    public String queryStudentInfoById(@RequestParam("stuId") Integer stuId, Model model){
        StudentInfo studentInfo = studentInfoService2.queryStudentInfoById(stuId);
        model.addAttribute("info",studentInfo);
        return "student/updateStudent";
    }

    @RequestMapping("/updateStudentSubmit")
    @ResponseBody
    public DataInfo updateStudentSubmit(@RequestBody  StudentInfo studentInfo){
        return studentInfoService2.updateStudentSubmit(studentInfo);
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public DataInfo deleteStudent(@RequestParam("stuIds") String stuIds){
        return studentInfoService2.deleteStudent(stuIds);
    }

    @RequestMapping("/stuInfo")
    public String findStu(HttpServletRequest request, Map<String, Object> map){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="student"){
            StudentInfo studentInfo =(StudentInfo) session.getAttribute("user");
            map.put("stuId",studentInfo.getStuId());
            map.put("stuName",studentInfo.getStuName());
            map.put("stuSex",studentInfo.getStuSex());
            map.put("stuFaculty",studentInfo.getStuFaculty());
            map.put("stuMajor",studentInfo.getStuMajor());
            map.put("stuClass",studentInfo.getStuClass());
            map.put("stuPhone",studentInfo.getStuPhone());
        }
        return "student/stuInfo";
    }


}
