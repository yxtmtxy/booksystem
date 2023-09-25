package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.ReceiveStu;
import com.eurekaconsumer.pojo.ReceiveTea;
import com.eurekaconsumer.pojo.StudentInfo;
import com.eurekaconsumer.pojo.TeacherInfo;
import com.eurekaconsumer.service.ReceiveService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReceiveController2 {
    @Autowired
    private ReceiveService2 receiveService2;
    @Autowired
    private queryService queryService;


    @GetMapping("/receiveStu")
    public String receiveStuIndex(){
        return "receive/receiveStu";
    }

    @GetMapping("/receiveTea")
    public String receiveTeaIndex(){
        return "receive/receiveTea";
    }

    @RequestMapping("/receiveStuAll")
    @ResponseBody
    public DataInfo queryReceiveStuAll(Integer bookId, Integer type, HttpServletRequest request, ReceiveStu receiveStu, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="student") {
            StudentInfo studentInfo = (StudentInfo) session.getAttribute("user");
            PageInfo<ReceiveStu> pageInfo = queryService.queryReceiveStuAll(studentInfo.getStuId(),receiveStu,pageNum,limit,bookId,type);
            return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
        }
        return DataInfo.ok();
    }

    @RequestMapping("/receiveTeaAll")
    @ResponseBody
    public DataInfo queryReceiveTeaAll(Integer bookId, Integer type,HttpServletRequest request,ReceiveTea receiveTea, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="teacher") {
            TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
            PageInfo<ReceiveTea> pageInfo = queryService.queryReceiveTeaAll(teacherInfo.getTeaId(),receiveTea,pageNum,limit,bookId,type);
            return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
        }
        return DataInfo.ok();
    }

    @RequestMapping("/updateReceiveStuSubmit")
    @ResponseBody
    public DataInfo updateReceiveStuSubmit(@RequestBody ReceiveStu receiveStu){
        return receiveService2.updateReceiveStuSubmit(receiveStu);
    }

    @RequestMapping("/updateReceiveTeaSubmit")
    @ResponseBody
    public DataInfo updateReceiveTeaSubmit(@RequestBody ReceiveTea receiveTea){
        return receiveService2.updateReceiveTeaSubmit(receiveTea);
    }

}
