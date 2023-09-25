package com.yx.dao;

import com.yx.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Admin record);
    /**
     * 管理员查询
     */
    List<Admin> queryAdminInfoAll(Admin admin);

    Admin queryAdminByUsername(String username);
    /**
     * 根据用户名和密码查询用户信息
     */
    Admin queryUserByNameAndPassword(@Param("username") String username,@Param("password") String password);
}