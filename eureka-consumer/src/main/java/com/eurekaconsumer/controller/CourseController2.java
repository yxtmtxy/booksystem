package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Course;
import com.eurekaconsumer.service.CourseService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class CourseController2 {
    @Autowired
    private CourseService2 courseService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/courseIndex")
    public String courseIndex(){
        return "course/courseIndex";
    }

    @GetMapping("/courseInfo")
    public String courseInfo(){
        return "course/courseInfo";
    }

    @RequestMapping("/courseAdd")
    public String courseAdd(){
        return "course/courseAdd";
    }

    @RequestMapping("/courseAll")
    @ResponseBody
    public DataInfo queryCourseAll(Course course, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Course> pageInfo = queryService.queryCourseAll(course,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/addCourseSubmit")
    @ResponseBody
    public DataInfo addCourseSubmit(@RequestBody Course course){
        return courseService2.addCourseSubmit(course);
    }

    @GetMapping("/queryCourseById")
    public String queryCourseById(Integer courseId, Model model){
        Course course = courseService2.queryCourseById(courseId);
        model.addAttribute("info",course);
        return "course/updateCourse";
    }

    @RequestMapping("/updateCourseSubmit")
    @ResponseBody
    public DataInfo updateCourseSubmit(@RequestBody Course course){
        return courseService2.updateCourseSubmit(course);
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public DataInfo deleteCourse(@RequestParam("courseIds") String courseIds){
        return courseService2.deleteCourse(courseIds);
    }


}
