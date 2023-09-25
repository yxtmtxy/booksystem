package com.yx.controller;

import com.yx.pojo.Admin;
import com.yx.pojo.OfficerInfo;
import com.yx.pojo.StudentInfo;
import com.yx.pojo.TeacherInfo;
import com.yx.service.AdminService;
import com.yx.service.OfficerInfoService;
import com.yx.service.StudentInfoService;
import com.yx.service.TeacherInfoService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//登陆后修改密码
@Controller
public class BaseController {
    @Autowired
    private OfficerInfoService officerInfoService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private StudentInfoService studentInfoService;

    /**
     * 修改提交（右上角修改密码）
     */

    @RequestMapping("/updatePwdSubmitAdmin")
    @ResponseBody
    public DataInfo updatePwdSubmitAdmin(@RequestBody Admin admin,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
        Admin admin1 = adminService.queryAdminById(admin.getId());
        if (!oldPwd.equals(admin1.getPassword())){
            return DataInfo.fail("输入的旧密码错误");
        }else{
            admin1.setPassword(newPwd);
            adminService.updateAdminSubmit(admin1);//数据库修改
        }
        return DataInfo.ok();
    }

    @RequestMapping("/updatePwdSubmitOfficer")
    @ResponseBody
    public DataInfo updatePwdSubmitOfficer(@RequestBody OfficerInfo officerInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
        OfficerInfo officerInfo1 = officerInfoService.queryOfficerInfoById(officerInfo.getOffId());//根据id查询对象
        Admin admin11 = adminService.queryAdminByUsername(officerInfo1.getUsername());
        if (!oldPwd.equals(officerInfo1.getPassword())){
            return DataInfo.fail("输入的旧密码错误");
        }else{
            admin11.setPassword(newPwd);
            adminService.updateAdminSubmit(admin11);
            officerInfo1.setPassword(newPwd);
            officerInfoService.updateOfficerInfoSubmit(officerInfo1);//数据库修改
        }
        return DataInfo.ok();

    }

    @RequestMapping("/updatePwdSubmitTeacher")
    @ResponseBody
    public DataInfo updatePwdSubmitTeacher(@RequestBody TeacherInfo teacherInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd) {
        TeacherInfo teacherInfo1 = teacherInfoService.queryTeacherInfoById(teacherInfo.getTeaId());//根据id查询对象
        Admin admin12 = adminService.queryAdminByUsername(teacherInfo1.getUsername());
        if (!oldPwd.equals(teacherInfo1.getPassword())){
            return DataInfo.fail("输入的旧密码错误");
        }else{
            admin12.setPassword(newPwd);
            adminService.updateAdminSubmit(admin12);
            teacherInfo1.setPassword(newPwd);
            teacherInfoService.updateTeacherInfoSubmit(teacherInfo1);//数据库修改
        }
        return DataInfo.ok();
    }

    @RequestMapping("/updatePwdSubmitStudent")
    @ResponseBody
    public DataInfo updatePwdSubmitStudent(@RequestBody StudentInfo studentInfo,
                                         @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
        StudentInfo studentInfo1 = studentInfoService.queryStudentInfoById(studentInfo.getStuId());//根据id查询对象
        Admin admin13 = adminService.queryAdminByUsername(studentInfo1.getUsername());
        if (!oldPwd.equals(studentInfo1.getPassword())){
            return DataInfo.fail("输入的旧密码错误");
        }else{
            admin13.setPassword(newPwd);
            adminService.updateAdminSubmit(admin13);
            studentInfo1.setPassword(newPwd);
            studentInfoService.updateStudentInfoSubmit(studentInfo1);//数据库修改
        }
        return DataInfo.ok();
    }

    @RequestMapping("/updatePwdSubmit2")
    @ResponseBody
    public DataInfo updatePwdSubmit(@RequestBody HttpServletRequest request, @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
        HttpSession session = request.getSession();
        if(session.getAttribute("type")=="admin"){
            //管理员
            Admin admin = (Admin)session.getAttribute("user");
            Admin admin1 = adminService.queryAdminById(admin.getId());
            if (!oldPwd.equals(admin1.getPassword())){
                return DataInfo.fail("输入的旧密码错误");
            }else{
                admin1.setPassword(newPwd);
                adminService.updateAdminSubmit(admin1);//数据库修改
            }
        }
        else if (session.getAttribute("type")=="officer"){
            //教务处
            OfficerInfo officerInfo = (OfficerInfo) session.getAttribute("user");
            OfficerInfo officerInfo1 = officerInfoService.queryOfficerInfoById(officerInfo.getOffId());//根据id查询对象
            Admin admin11 = adminService.queryAdminByUsername(officerInfo1.getUsername());
            if (!oldPwd.equals(officerInfo1.getPassword())){
                return DataInfo.fail("输入的旧密码错误");
            }else{
                admin11.setPassword(newPwd);
                adminService.updateAdminSubmit(admin11);
                officerInfo1.setPassword(newPwd);
                officerInfoService.updateOfficerInfoSubmit(officerInfo1);//数据库修改
            }
        }
        else if (session.getAttribute("type")=="teacher"){
            //教师
            TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("user");
            TeacherInfo teacherInfo1 = teacherInfoService.queryTeacherInfoById(teacherInfo.getTeaId());//根据id查询对象
            Admin admin12 = adminService.queryAdminByUsername(teacherInfo1.getUsername());
            if (!oldPwd.equals(teacherInfo1.getPassword())){
                return DataInfo.fail("输入的旧密码错误");
            }else{
                admin12.setPassword(newPwd);
                adminService.updateAdminSubmit(admin12);
                teacherInfo1.setPassword(newPwd);
                teacherInfoService.updateTeacherInfoSubmit(teacherInfo1);//数据库修改
            }
        }
        else if (session.getAttribute("type")=="student"){
            //学生
            StudentInfo studentInfo = (StudentInfo) session.getAttribute("user");
            StudentInfo studentInfo1 = studentInfoService.queryStudentInfoById(studentInfo.getStuId());//根据id查询对象
            Admin admin13 = adminService.queryAdminByUsername(studentInfo1.getUsername());
            if (!oldPwd.equals(studentInfo1.getPassword())){
                return DataInfo.fail("输入的旧密码错误");
            }else{
                admin13.setPassword(newPwd);
                adminService.updateAdminSubmit(admin13);
                studentInfo1.setPassword(newPwd);
                studentInfoService.updateStudentInfoSubmit(studentInfo1);//数据库修改
            }
        }
        return DataInfo.ok();
    }





}
