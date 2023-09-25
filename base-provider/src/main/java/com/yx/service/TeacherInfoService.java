package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.TeacherInfo;

import java.util.List;
public interface TeacherInfoService {
    /**
     * 查询所有教师（分页）
     */
    PageInfo<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addTeacherInfoSubmit(TeacherInfo TeacherInfo);

    /**
     * 根据id查询（修改）
     */
    TeacherInfo queryTeacherInfoById(Integer teaId);

    /**
     * 根据username查询（修改）
     */
    TeacherInfo queryTeacherInfoByUsername(String username);

    /**
     * 修改提交
     */
    void updateTeacherInfoSubmit(TeacherInfo TeacherInfo);

    /**
     * 删除
     */
    void deleteTeacherInfoByIds(List<String> teaIds);

    /**
     * 根据用户名和密码查询用户信息
     */
    TeacherInfo queryUserByNameAndPassword(String username,String password);
}
