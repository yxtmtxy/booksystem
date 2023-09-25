package com.yx.dao;


import com.yx.pojo.OfficerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OfficerInfoMapper {
    int deleteByPrimaryKey(Integer offId);

    int insert(OfficerInfo officerInfo);

    OfficerInfo selectByPrimaryKey(Integer offId);

    OfficerInfo selectByUsername(String username);

    int updateByPrimaryKey(OfficerInfo officerInfo);

    List<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo);

    OfficerInfo queryUserByNameAndPassword(@Param("username") String username,@Param("password") String password);


}