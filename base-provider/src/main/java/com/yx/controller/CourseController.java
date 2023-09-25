package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Course;
import com.yx.service.CourseService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//课程管理
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/courseAll")
    @ResponseBody
    public DataInfo queryCourseAll(Course course, @RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Course> pageInfo = courseService.queryCourseAll(course,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addCourseSubmit")
    @ResponseBody
    public DataInfo addCourseSubmit(@RequestBody Course course){
        courseService.addCourseSubmit(course);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryCourseById")
    @ResponseBody
    public Course queryCourseById(@RequestParam("courseId") Integer courseId){
        return courseService.queryCourseById(courseId);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateCourseSubmit")
    @ResponseBody
    public DataInfo updateCourseSubmit(@RequestBody Course course){
        courseService.updateCourseSubmit(course);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteCourse")
    @ResponseBody
    public DataInfo deleteCourse(@RequestParam("courseIds") String courseIds){
        List<String> list= Arrays.asList(courseIds.split(","));
        courseService.deleteCourseByIds(list);
        return DataInfo.ok();
    }

}
