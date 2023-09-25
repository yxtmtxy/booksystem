package com.yx.service.impl;
import com.yx.dao.VendorMapper;
import com.yx.pojo.Vendor;
import com.yx.service.VendorService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VendorService")
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorMapper VendorMapper;

    @Override
    public PageInfo<Vendor> queryVendorAll(Vendor vendor, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Vendor> VendorList = VendorMapper.queryVendorAll(vendor);
        return new PageInfo<>(VendorList) ;
    }

    @Override
    public void addVendorSubmit(Vendor vendor) {
        VendorMapper.insert(vendor);
    }

    @Override
    public Vendor queryVendorById(Integer id) {
        return VendorMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateVendorSubmit(Vendor Vendor) {
        VendorMapper.updateByPrimaryKey(Vendor);
    }

    @Override
    public void deleteVendorByIds(List<String> ids) {
        for (String id : ids){
            VendorMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
