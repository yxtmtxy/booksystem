package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.OfficerInfo;

import java.util.List;

public interface OfficerInfoService {

    /**
     * 查询所有教务处员工（分页）
     */
    PageInfo<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addOfficerInfoSubmit(OfficerInfo OfficerInfo);

    /**
     * 根据id查询（修改）
     */
    OfficerInfo queryOfficerInfoById(Integer offId);

    /**
     * 根据username查询（修改）
     */
    OfficerInfo queryOfficerInfoByUsername(String username);


    /**
     * 修改提交
     */
    void updateOfficerInfoSubmit(OfficerInfo OfficerInfo);

    /**
     * 删除
     */
    void deleteOfficerInfoByIds(List<String> offIds);

    /**
     * 根据用户名和密码查询用户信息
     */
    OfficerInfo queryUserByNameAndPassword(String username,String password);
}