package com.eurekaconsumer.dao;


import com.eurekaconsumer.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface queryMapper {

    List<Admin> queryAdminInfoAll(Admin admin);

    List<ApplyStu> queryApplyStuAll(ApplyStu applyStu, Integer stuId, Integer bookId, Integer type);

    List<ApplyTea> queryApplyTeaAll(ApplyTea applyTea, Integer teaId, Integer bookId, Integer type);

    List<AuditStu> queryAuditStuAll(AuditStu auditStu);

    List<AuditTea> queryAuditTeaAll(AuditTea auditTea);

    List<Book> queryBookAll(Book book);

    List<Course> queryCourseAll(Course course);

    List<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo);

    List<Inventory> queryInventoryAll(Inventory book);

    List<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo);

    List<Order> queryOrderAll(Order order);

    List<Prepare> queryPrepareAll(Prepare prepare);

    List<ReceiveStu> queryReceiveStuAll(ReceiveStu receiveStu,Integer stuId,Integer bookId, Integer type);

    List<ReceiveTea> queryReceiveTeaAll(ReceiveTea receiveTea,Integer teaId,Integer bookId, Integer type);

    List<Storage> queryStorageAll(Storage storage);

    List<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo);

    List<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo);

    List<Vendor> queryVendorAll(Vendor vendor);

}
