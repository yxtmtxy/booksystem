package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.yx.dao.StudentInfoMapper;
import com.yx.pojo.StudentInfo;
import com.yx.service.StudentInfoService;

@Service("StudentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper StudentInfoMapper;

    @Override
    public PageInfo<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<StudentInfo> StudentInfoList = StudentInfoMapper.queryStudentInfoAll(StudentInfo);
        return new PageInfo<>(StudentInfoList) ;
    }

    @Override
    public void addStudentInfoSubmit(StudentInfo StudentInfo) {
        StudentInfoMapper.insert(StudentInfo);
    }

    @Override
    public StudentInfo queryStudentInfoById(Integer stuId) {
        return StudentInfoMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public StudentInfo queryStudentInfoByUsername(String username) {
        return StudentInfoMapper.selectByUsername(username);
    }

    @Override
    public void updateStudentInfoSubmit(StudentInfo StudentInfo) {
        StudentInfoMapper.updateByPrimaryKey(StudentInfo);
    }

    @Override
    public void deleteStudentInfoByIds(List<String> stuIds) {
        for (String stuId : stuIds){
            StudentInfoMapper.deleteByPrimaryKey(Integer.parseInt(stuId));
        }
    }

    @Override
    public StudentInfo queryUserByNameAndPassword(String username, String password) {
        return StudentInfoMapper.queryUserByNameAndPassword(username,password);
    }
}
