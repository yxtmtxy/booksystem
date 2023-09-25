package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.yx.dao.TeacherInfoMapper;
import com.yx.pojo.TeacherInfo;
import com.yx.service.TeacherInfoService;

@Service("TeacherInfoService")
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoMapper TeacherInfoMapper;

    @Override
    public PageInfo<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<TeacherInfo> TeacherInfoList = TeacherInfoMapper.queryTeacherInfoAll(TeacherInfo);
        return new PageInfo<>(TeacherInfoList) ;
    }

    @Override
    public void addTeacherInfoSubmit(TeacherInfo TeacherInfo) {
        TeacherInfoMapper.insert(TeacherInfo);
    }

    @Override
    public TeacherInfo queryTeacherInfoById(Integer teaId) {
        return TeacherInfoMapper.selectByPrimaryKey(teaId);
    }

    @Override
    public TeacherInfo queryTeacherInfoByUsername(String username) {
        return TeacherInfoMapper.selectByUsername(username);
    }

    @Override
    public void updateTeacherInfoSubmit(TeacherInfo TeacherInfo) {
        TeacherInfoMapper.updateByPrimaryKey(TeacherInfo);
    }

    @Override
    public void deleteTeacherInfoByIds(List<String> teaIds) {
        for (String teaId : teaIds){
            TeacherInfoMapper.deleteByPrimaryKey(Integer.parseInt(teaId));
        }
    }

    @Override
    public TeacherInfo queryUserByNameAndPassword(String username, String password) {
        return TeacherInfoMapper.queryUserByNameAndPassword(username,password);
    }
}
