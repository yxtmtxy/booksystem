package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.StudentInfo;
import com.yx.service.StudentInfoService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//学生信息管理
@Controller
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/studentAll")
    @ResponseBody
    public DataInfo queryStudentAll( StudentInfo studentInfo, @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<StudentInfo> pageInfo = studentInfoService.queryStudentInfoAll(studentInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addStudentSubmit")
    @ResponseBody
    public DataInfo addStudentSubmit(@RequestBody  StudentInfo studentInfo){
        studentInfo.setPassword("123456");//设置默认密码
        studentInfoService.addStudentInfoSubmit(studentInfo);
        return DataInfo.ok();
    }
    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryStudentInfoById")
    @ResponseBody
    public StudentInfo queryStudentInfoById(@RequestParam("stuId") Integer stuId){
        return studentInfoService.queryStudentInfoById(stuId);
    }
    /**
     * 修改提交
     */
    @RequestMapping("/updateStudentSubmit")
    @ResponseBody
    public DataInfo updateStudentSubmit(@RequestBody  StudentInfo studentInfo){
        studentInfoService.updateStudentInfoSubmit(studentInfo);
        return DataInfo.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteStudent")
    @ResponseBody
    public DataInfo deleteStudent(@RequestParam("stuIds") String stuIds){
        List<String> list= Arrays.asList(stuIds.split(","));
        studentInfoService.deleteStudentInfoByIds(list);
        return DataInfo.ok();
    }


}
