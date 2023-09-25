package com.yx.service.impl;
import com.yx.dao.GradeInfoMapper;
import com.yx.pojo.GradeInfo;
import com.yx.service.GradeInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GradeInfoService")
public class GradeInfoServiceImpl implements GradeInfoService {

    @Autowired
    private GradeInfoMapper GradeInfoMapper;

    @Override
    public PageInfo<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<GradeInfo> GradeInfoList = GradeInfoMapper.queryGradeInfoAll(GradeInfo);
        return new PageInfo<>(GradeInfoList) ;
    }

    @Override
    public void addGradeInfoSubmit(GradeInfo GradeInfo) {
        GradeInfoMapper.insert(GradeInfo);
    }

    @Override
    public GradeInfo queryGradeInfoById(Integer id) {
        return GradeInfoMapper.selectById(id);
    }

    @Override
    public void updateGradeInfoSubmit(GradeInfo GradeInfo) {
        GradeInfoMapper.updateById(GradeInfo);
    }

    @Override
    public void deleteGradeInfoByIds(List<String> ids) {
        for (String id : ids){
            GradeInfoMapper.deleteById(Integer.parseInt(id));
        }
    }
}
