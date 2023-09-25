package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.GradeInfo;

import java.util.List;

public interface GradeInfoService {

    /**
     * 查询所有班级信息（分页）
     */
    PageInfo<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addGradeInfoSubmit(GradeInfo GradeInfo);

    /**
     * 根据id查询（修改）
     */
    GradeInfo queryGradeInfoById(Integer id);

    /**
     * 修改提交
     */
    void updateGradeInfoSubmit(GradeInfo GradeInfo);

    /**
     * 删除
     */
    void deleteGradeInfoByIds(List<String> ids);

}