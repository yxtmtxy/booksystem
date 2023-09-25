package com.yx.dao;


import com.yx.pojo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentInfoMapper {

    int deleteByPrimaryKey(Integer stuId);

    int insert(StudentInfo studentInfo);

    StudentInfo selectByPrimaryKey(Integer stuId);

    StudentInfo selectByUsername(String username);

    int updateByPrimaryKey(StudentInfo studentInfo);

    List<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo);

    StudentInfo queryUserByNameAndPassword(@Param("username") String username,@Param("password") String password);


}