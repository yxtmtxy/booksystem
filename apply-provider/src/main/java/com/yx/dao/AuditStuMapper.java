package com.yx.dao;

import com.yx.pojo.AuditStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditStuMapper {
    
    
    int deleteByPrimaryKey(Integer id);

    int insert(AuditStu record);

    AuditStu selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AuditStu record);

    List<AuditStu> queryAuditStuAll(AuditStu auditStu);
}