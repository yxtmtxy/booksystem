package com.yx.service.impl;

import com.yx.dao.ApplyTeaMapper;
import com.yx.pojo.ApplyTea;
import com.yx.pojo.ApplyStu;
import com.yx.dao.ApplyStuMapper;
import com.yx.service.ApplyService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyTeaMapper ApplyTeaMapper;
    @Autowired
    private ApplyStuMapper ApplyStuMapper;

    @Override
    public PageInfo<ApplyTea> queryApplyTeaAll(Integer teaId,ApplyTea applyTea, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ApplyTea> ApplyTeaList = ApplyTeaMapper.queryApplyTeaAll(applyTea,teaId,bookId,type);
        return new PageInfo<>(ApplyTeaList) ;
    }
    @Override
    public PageInfo<ApplyStu> queryApplyStuAll(Integer stuId,ApplyStu applyStu, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ApplyStu> ApplyStuList = ApplyStuMapper.queryApplyStuAll(applyStu,stuId,bookId,type);
        return new PageInfo<>(ApplyStuList) ;
    }

    @Override
    public void addApplyTeaSubmit(ApplyTea applyTea) {
        ApplyTeaMapper.insert(applyTea);
    }
    @Override
    public void addApplyStuSubmit(ApplyStu applyStu) {
        ApplyStuMapper.insert(applyStu);
    }

    @Override
    public ApplyTea queryApplyTeaById(Integer id) {
        return ApplyTeaMapper.selectByPrimaryKey(id);
    }
    @Override
    public ApplyStu queryApplyStuById(Integer id) {
        return ApplyStuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateApplyTeaSubmit(ApplyTea ApplyTea) {
        ApplyTeaMapper.updateByPrimaryKey(ApplyTea);
    }
    @Override
    public void updateApplyStuSubmit(ApplyStu ApplyStu) {
        ApplyStuMapper.updateByPrimaryKey(ApplyStu);
    }

    @Override
    public void deleteApplyTeaByIds(List<String> ids) {
        for (String id : ids){
            ApplyTeaMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
    @Override
    public void deleteApplyStuByIds(List<String> ids) {
        for (String id : ids){
            ApplyStuMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
