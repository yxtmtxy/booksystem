package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Course;

import java.util.List;

public interface CourseService {

    /**
     * 查询所有课程信息（分页）
     */
    PageInfo<Course> queryCourseAll(Course course,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addCourseSubmit(Course course);

    /**
     * 根据id查询（修改）
     */
    Course queryCourseById(Integer courseId);

    /**
     * 修改提交
     */
    void updateCourseSubmit(Course course);

    /**
     * 删除
     */
    void deleteCourseByIds(List<String> courseIds);

}