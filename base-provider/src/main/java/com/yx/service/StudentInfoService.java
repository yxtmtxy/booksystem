package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.StudentInfo;

import java.util.List;
public interface StudentInfoService {

    /**
     * 查询所有学生（分页）
     */
    PageInfo<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addStudentInfoSubmit(StudentInfo StudentInfo);

    /**
     * 根据id查询（修改）
     */
    StudentInfo queryStudentInfoById(Integer stuId);

    /**
     * 根据username查询（修改）
     */
    StudentInfo queryStudentInfoByUsername(String username);

    /**
     * 修改提交
     */
    void updateStudentInfoSubmit(StudentInfo StudentInfo);

    /**
     * 删除
     */
    void deleteStudentInfoByIds(List<String> stuIds);

    /**
     * 根据用户名和密码查询用户信息
     */
    StudentInfo queryUserByNameAndPassword(String username,String password);
}
