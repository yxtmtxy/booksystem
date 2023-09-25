package com.yx.service.impl;
import com.yx.dao.AuditTeaMapper;
import com.yx.dao.AuditStuMapper;
import com.yx.pojo.AuditStu;
import com.yx.pojo.AuditTea;
import com.yx.service.AuditService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AuditService")
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditTeaMapper AuditTeaMapper;
    @Autowired
    private AuditStuMapper AuditStuMapper;

    @Override
    public PageInfo<AuditTea> queryAuditTeaAll(AuditTea auditTea, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<AuditTea> AuditTeaList = AuditTeaMapper.queryAuditTeaAll(auditTea);
        return new PageInfo<>(AuditTeaList) ;
    }
    @Override
    public PageInfo<AuditStu> queryAuditStuAll(AuditStu auditStu, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<AuditStu> AuditStuList = AuditStuMapper.queryAuditStuAll(auditStu);
        return new PageInfo<>(AuditStuList) ;
    }

    @Override
    public void updateAuditTeaSubmit(AuditTea AuditTea) {
        AuditTeaMapper.updateByPrimaryKey(AuditTea);
    }
    @Override
    public void updateAuditStuSubmit(AuditStu AuditStu) {
        AuditStuMapper.updateByPrimaryKey(AuditStu);
    }


    @Override
    public AuditTea queryAuditTeaById(Integer id) {
        return AuditTeaMapper.selectByPrimaryKey(id);
    }
    @Override
    public AuditStu queryAuditStuById(Integer id) {
        return AuditStuMapper.selectByPrimaryKey(id);
    }


    @Override
    public void deleteAuditTeaByIds(List<String> ids) {
        for (String id : ids){
            AuditTeaMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
    @Override
    public void deleteAuditStuByIds(List<String> ids) {
        for (String id : ids){
            AuditStuMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
