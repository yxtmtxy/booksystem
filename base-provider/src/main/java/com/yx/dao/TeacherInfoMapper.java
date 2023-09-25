package com.yx.dao;


import com.yx.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherInfoMapper {

    int deleteByPrimaryKey(Integer teaId);

    int insert(TeacherInfo teacherInfo);

    TeacherInfo selectByPrimaryKey(Integer teaId);

    TeacherInfo selectByUsername(String username);

    int updateByPrimaryKey(TeacherInfo teacherInfo);

    List<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo);

    TeacherInfo queryUserByNameAndPassword(@Param("username") String username,@Param("password") String password);


}