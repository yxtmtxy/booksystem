package com.yx.dao;

import com.yx.pojo.Vendor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorMapper {
    int deleteByPrimaryKey(Integer vendorId);

    int insert(Vendor record);

    Vendor selectByPrimaryKey(Integer vendorId);

    int updateByPrimaryKey(Vendor record);

    List<Vendor> queryVendorAll(Vendor vendor);
}