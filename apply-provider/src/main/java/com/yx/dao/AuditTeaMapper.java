package com.yx.dao;

import com.yx.pojo.AuditTea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditTeaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditTea record);

    AuditTea selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AuditTea record);

    List<AuditTea> queryAuditTeaAll(AuditTea auditTea);
}