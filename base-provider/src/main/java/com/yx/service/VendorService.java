package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Vendor;

import java.util.List;

public interface VendorService {

    /**
     * 查询所有课程信息（分页）
     */
    PageInfo<Vendor> queryVendorAll(Vendor vendor,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addVendorSubmit(Vendor vendor);

    /**
     * 根据id查询（修改）
     */
    Vendor queryVendorById(Integer id);

    /**
     * 修改提交
     */
    void updateVendorSubmit(Vendor vendor);

    /**
     * 删除
     */
    void deleteVendorByIds(List<String> ids);

}