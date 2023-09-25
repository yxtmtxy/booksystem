package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.yx.dao.OfficerInfoMapper;
import com.yx.pojo.OfficerInfo;
import com.yx.service.OfficerInfoService;

@Service("OfficerInfoService")
public class OfficerInfoServiceImpl implements OfficerInfoService {

    @Autowired
    private OfficerInfoMapper OfficerInfoMapper;

    @Override
    public PageInfo<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<OfficerInfo> OfficerInfoList = OfficerInfoMapper.queryOfficerInfoAll(OfficerInfo);
        return new PageInfo<>(OfficerInfoList) ;
    }

    @Override
    public void addOfficerInfoSubmit(OfficerInfo OfficerInfo) {
        OfficerInfoMapper.insert(OfficerInfo);
    }

    @Override
    public OfficerInfo queryOfficerInfoById(Integer offId) {
        return OfficerInfoMapper.selectByPrimaryKey(offId);
    }

    @Override
    public OfficerInfo queryOfficerInfoByUsername(String username) {
        return OfficerInfoMapper.selectByUsername(username);
    }


    @Override
    public void updateOfficerInfoSubmit(OfficerInfo OfficerInfo) {
        OfficerInfoMapper.updateByPrimaryKey(OfficerInfo);
    }

    @Override
    public void deleteOfficerInfoByIds(List<String> offIds) {
        for (String offId : offIds){
            OfficerInfoMapper.deleteByPrimaryKey(Integer.parseInt(offId));
        }
    }

    @Override
    public OfficerInfo queryUserByNameAndPassword(String username, String password) {
        return OfficerInfoMapper.queryUserByNameAndPassword(username,password);
    }
}
