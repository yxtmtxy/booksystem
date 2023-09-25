package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.ApplyStu;
import com.eurekaconsumer.pojo.ApplyTea;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.service.ApplyService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ApplyController2 {
    @Autowired
    private ApplyService2 applyService2;

    @Autowired
    private queryService queryService;

    @GetMapping("/applyTeaIndex")
    public String applyTeaIndex(){
        return "apply/tea/applyTeaIndex";
    }

    @GetMapping("/applyStuIndex")
    public String applyStuIndex(){
        return "apply/stu/applyStuIndex";
    }

    @RequestMapping("/applyTeaAll")
    @ResponseBody
    public DataInfo queryApplyTeaAll(Integer bookId, Integer type, HttpServletRequest request, ApplyTea applyTea, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="teacher") {
            TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
            PageInfo<ApplyTea> pageInfo = queryService.queryApplyTeaAll(teacherInfo.getTeaId(), applyTea, pageNum, limit,bookId,type);
            return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
        }
        return DataInfo.ok();
    }

    @RequestMapping("/applyStuAll")
    @ResponseBody
    public DataInfo queryApplyStuAll(Integer bookId, Integer type,HttpServletRequest request,ApplyStu applyStu, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="student") {
            StudentInfo studentInfo=(StudentInfo)session.getAttribute("user");
            PageInfo<ApplyStu> pageInfo = queryService.queryApplyStuAll(studentInfo.getStuId(),applyStu,pageNum,limit,bookId,type);
            return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
        }
        return DataInfo.ok();
    }

    @RequestMapping("/applyTeaAdd")
    public String applyTeaAdd(){
        return "apply/tea/applyTeaAdd";
    }

    @RequestMapping("/applyStuAdd")
    public String applyStuAdd(){
        return "apply/stu/applyStuAdd";
    }

    @RequestMapping("/addApplyTeaSubmit")
    @ResponseBody
    public DataInfo addApplyTeaSubmit(@RequestBody ApplyTea applyTea, HttpServletRequest request){
        HttpSession session = request.getSession();
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
        Integer id=teacherInfo.getTeaId();
        applyTea.setTeaId(id);
        applyTea.setType(0);
        return applyService2.addApplyTeaSubmit(applyTea);
    }

    @RequestMapping("/addApplyStuSubmit")
    @ResponseBody
    public DataInfo addApplyStuSubmit(@RequestBody ApplyStu applyStu,HttpServletRequest request){
        HttpSession session = request.getSession();
        StudentInfo studentInfo = (StudentInfo)  session.getAttribute("user");
        Integer id=studentInfo.getStuId();
        applyStu.setStuId(id);
        applyStu.setType(0);
        return applyService2.addApplyStuSubmit(applyStu);
    }

    @GetMapping("/queryApplyTeaById")
    public String queryApplyTeaById(@RequestParam("id") Integer id, Model model){
        ApplyTea applyTea = applyService2.queryApplyTeaById(id);
        model.addAttribute("info",applyTea);
        return "apply/tea/updateApplyTea";
    }

    @GetMapping("/queryApplyStuById")
    public String queryApplyStuById(@RequestParam("id") Integer id, Model model){
        ApplyStu applyStu = applyService2.queryApplyStuById(id);
        model.addAttribute("info",applyStu);
        return "apply/stu/updateApplyStu";
    }

    @RequestMapping("/updateApplyTeaSubmit")
    @ResponseBody
    public DataInfo updateApplyTeaSubmit(@RequestBody ApplyTea applyTea,HttpServletRequest request){
        HttpSession session = request.getSession();
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
        Integer id=teacherInfo.getTeaId();
        applyTea.setTeaId(id);
        applyTea.setType(0);
        return applyService2.updateApplyTeaSubmit(applyTea);
    }

    @RequestMapping("/updateApplyStuSubmit")
    @ResponseBody
    public DataInfo updateApplyStuSubmit(@RequestBody ApplyStu applyStu,HttpServletRequest request){
        HttpSession session = request.getSession();
        StudentInfo studentInfo = (StudentInfo)  session.getAttribute("user");
        Integer id=studentInfo.getStuId();
        applyStu.setStuId(id);
        applyStu.setType(0);
        return applyService2.updateApplyStuSubmit(applyStu);
    }

    @RequestMapping("/deleteApplyTea")
    @ResponseBody
    public DataInfo deleteApplyTea(@RequestParam("ids") String ids){
        return applyService2.deleteApplyTea(ids);
    }

    @RequestMapping("/deleteApplyStu")
    @ResponseBody
    public DataInfo deleteApplyStu(@RequestParam("ids") String ids){
        return applyService2.deleteApplyStu(ids);
    }







}
