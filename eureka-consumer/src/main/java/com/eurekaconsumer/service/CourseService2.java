package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.eurekaconsumer.utils.DataInfo;


@Component
@FeignClient(value = "base-provider",contextId="Course")
public interface CourseService2 {
    //课程添加
    @RequestMapping("/addCourseSubmit")
    DataInfo addCourseSubmit(@RequestBody Course course);
    //修改界面跳转
    @GetMapping("/queryCourseById")
    Course queryCourseById(@RequestParam("courseId") Integer courseId);
    //课程修改
    @RequestMapping("/updateCourseSubmit")
    DataInfo updateCourseSubmit(@RequestBody Course course);
    //课程删除
    @RequestMapping("/deleteCourse")
    DataInfo deleteCourse(@RequestParam("courseIds") String courseIds);
}
