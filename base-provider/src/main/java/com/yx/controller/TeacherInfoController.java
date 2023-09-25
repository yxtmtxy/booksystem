package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.TeacherInfo;
import com.yx.service.TeacherInfoService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//教师信息管理
@Controller
public class TeacherInfoController {

    @Autowired
    private TeacherInfoService teacherInfoService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/teacherAll")
    @ResponseBody
    public DataInfo queryTeacherAll(TeacherInfo teacherInfo, @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<TeacherInfo> pageInfo = teacherInfoService.queryTeacherInfoAll(teacherInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addTeacherSubmit")
    @ResponseBody
    public DataInfo addTeacherSubmit(@RequestBody  TeacherInfo teacherInfo){
        teacherInfo.setPassword("123456");//设置默认密码
        teacherInfoService.addTeacherInfoSubmit(teacherInfo);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryTeacherInfoById")
    @ResponseBody
    public TeacherInfo queryTeacherInfoById(@RequestParam("teaId") Integer teaId){
        return teacherInfoService.queryTeacherInfoById(teaId);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateTeacherSubmit")
    @ResponseBody
    public DataInfo updateTeacherSubmit(@RequestBody TeacherInfo teacherInfo){
        teacherInfoService.updateTeacherInfoSubmit(teacherInfo);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public DataInfo deleteTeacher(@RequestParam("teaIds") String teaIds){
        List<String> list= Arrays.asList(teaIds.split(","));
        teacherInfoService.deleteTeacherInfoByIds(list);
        return DataInfo.ok();
    }

}
