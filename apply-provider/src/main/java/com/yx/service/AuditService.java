package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.AuditStu;
import com.yx.pojo.AuditTea;

import java.util.List;

public interface AuditService {

    /**
     * 查询所有信息（学生）
     */
    PageInfo<AuditStu> queryAuditStuAll(AuditStu auditStu,Integer pageNum,Integer limit);
    /**
     * 查询所有信息（教师）
     */
    PageInfo<AuditTea> queryAuditTeaAll(AuditTea auditTea,Integer pageNum,Integer limit);


    /**
     * 根据id查询
     */
    AuditStu queryAuditStuById(Integer id);

    /**
     * 根据id查询
     */
    AuditTea queryAuditTeaById(Integer id);

    /**
     * 修改提交
     */
    void updateAuditTeaSubmit(AuditTea auditTea);
    /**
     * 修改提交
     */
    void updateAuditStuSubmit(AuditStu auditStu);

    void deleteAuditTeaByIds(List<String> ids);
    void deleteAuditStuByIds(List<String> ids);



}