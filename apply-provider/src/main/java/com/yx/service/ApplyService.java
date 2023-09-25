package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.ApplyStu;
import com.yx.pojo.ApplyTea;

import java.util.List;

public interface ApplyService {

    /**
     * 查询所有教材申请信息（教师）
     */
    PageInfo<ApplyTea> queryApplyTeaAll(Integer teaId,ApplyTea applyTea,Integer pageNum,Integer limit,Integer bookId, Integer type);
    /**
     * 查询所有教材申请信息（学生）
     */
    PageInfo<ApplyStu> queryApplyStuAll(Integer stuId,ApplyStu applyStu,Integer pageNum,Integer limit ,Integer bookId, Integer type);

    /**
     * 添加提交
     */
    void addApplyTeaSubmit(ApplyTea applyTea);
    /**
     * 添加提交
     */
    void addApplyStuSubmit(ApplyStu applyStu);

    /**
     * 根据id查询（修改）
     */
    ApplyTea queryApplyTeaById(Integer id);
    /**
     * 根据id查询（修改）
     */
    ApplyStu queryApplyStuById(Integer id);

    /**
     * 修改提交
     */
    void updateApplyTeaSubmit(ApplyTea applyTea);
    /**
     * 修改提交
     */
    void updateApplyStuSubmit(ApplyStu applyStu);

    /**
     * 删除
     */
    void deleteApplyTeaByIds(List<String> ids);
    /**
     * 删除
     */
    void deleteApplyStuByIds(List<String> ids);

}