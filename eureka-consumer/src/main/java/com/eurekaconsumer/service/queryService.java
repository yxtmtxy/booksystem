package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.*;
import com.github.pagehelper.PageInfo;

public interface queryService {
    //所有数据显示，包含数据查找筛选操作
    PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit);
    PageInfo<ApplyStu> queryApplyStuAll(Integer stuId, ApplyStu applyStu, Integer pageNum, Integer limit , Integer bookId, Integer type);
    PageInfo<ApplyTea> queryApplyTeaAll(Integer teaId, ApplyTea applyTea, Integer pageNum, Integer limit, Integer bookId, Integer type);
    PageInfo<AuditStu> queryAuditStuAll(AuditStu auditStu, Integer pageNum, Integer limit);
    PageInfo<AuditTea> queryAuditTeaAll(AuditTea auditTea,Integer pageNum,Integer limit);
    PageInfo<Book> queryBookAll(Book book,Integer pageNum,Integer limit);
    PageInfo<Course> queryCourseAll(Course course,Integer pageNum,Integer limit);
    PageInfo<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo,Integer pageNum,Integer limit);
    PageInfo<Inventory> queryInventoryAll(Inventory inventory,Integer pageNum,Integer limit);
    PageInfo<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo,Integer pageNum,Integer limit);
    PageInfo<Order> queryOrderAll(Order order,Integer pageNum,Integer limit);
    PageInfo<Prepare> queryPrepareAll(Prepare prepare, Integer pageNum, Integer limit);
    PageInfo<ReceiveStu> queryReceiveStuAll(Integer stuId,ReceiveStu receiveStu,Integer pageNum,Integer limit,Integer bookId, Integer type);
    PageInfo<ReceiveTea> queryReceiveTeaAll(Integer teaId,ReceiveTea receiveTea,Integer pageNum,Integer limit,Integer bookId, Integer type);
    PageInfo<Storage> queryStorageAll(Storage storage,Integer pageNum,Integer limit);
    PageInfo<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo, Integer pageNum, Integer limit);
    PageInfo<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo, Integer pageNum, Integer limit);
    PageInfo<Vendor> queryVendorAll(Vendor vendor,Integer pageNum,Integer limit);
}
