package com.yx.dao;

import com.yx.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course course);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKey(Course course);

    List<Course> queryCourseAll(Course course);
}