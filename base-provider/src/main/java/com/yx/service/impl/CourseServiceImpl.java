package com.yx.service.impl;
import com.yx.dao.CourseMapper;
import com.yx.pojo.Course;
import com.yx.service.CourseService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper CourseMapper;

    @Override
    public PageInfo<Course> queryCourseAll(Course course, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Course> CourseList = CourseMapper.queryCourseAll(course);
        return new PageInfo<>(CourseList) ;
    }

    @Override
    public void addCourseSubmit(Course course) {
        CourseMapper.insert(course);
    }

    @Override
    public Course queryCourseById(Integer courseId) {
        return CourseMapper.selectByPrimaryKey(courseId);
    }

    @Override
    public void updateCourseSubmit(Course Course) {
        CourseMapper.updateByPrimaryKey(Course);
    }

    @Override
    public void deleteCourseByIds(List<String> courseIds) {
        for (String id : courseIds){
            CourseMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
