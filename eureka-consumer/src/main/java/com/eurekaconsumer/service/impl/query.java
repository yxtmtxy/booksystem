package com.eurekaconsumer.service.impl;

import com.eurekaconsumer.dao.queryMapper;
import com.eurekaconsumer.pojo.*;
import com.eurekaconsumer.service.queryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queryService")
public class query implements queryService{

    @Autowired
    private queryMapper queryMapper;

    @Override
    public PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Admin> adminList = queryMapper.queryAdminInfoAll(admin);
        return new PageInfo<>(adminList) ;
    }

    @Override
    public PageInfo<ApplyTea> queryApplyTeaAll(Integer teaId, ApplyTea applyTea, Integer pageNum, Integer limit, Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ApplyTea> ApplyTeaList = queryMapper.queryApplyTeaAll(applyTea,teaId,bookId,type);
        return new PageInfo<>(ApplyTeaList) ;
    }
    @Override
    public PageInfo<ApplyStu> queryApplyStuAll(Integer stuId, ApplyStu applyStu, Integer pageNum, Integer limit, Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ApplyStu> ApplyStuList = queryMapper.queryApplyStuAll(applyStu,stuId,bookId,type);
        return new PageInfo<>(ApplyStuList) ;
    }

    @Override
    public PageInfo<AuditTea> queryAuditTeaAll(AuditTea auditTea, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<AuditTea> AuditTeaList = queryMapper.queryAuditTeaAll(auditTea);
        return new PageInfo<>(AuditTeaList) ;
    }
    @Override
    public PageInfo<AuditStu> queryAuditStuAll(AuditStu auditStu, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<AuditStu> AuditStuList = queryMapper.queryAuditStuAll(auditStu);
        return new PageInfo<>(AuditStuList) ;
    }

    @Override
    public PageInfo<Book> queryBookAll(Book book, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Book> BookList = queryMapper.queryBookAll(book);
        return new PageInfo<>(BookList) ;
    }

    @Override
    public PageInfo<Course> queryCourseAll(Course course, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Course> CourseList = queryMapper.queryCourseAll(course);
        return new PageInfo<>(CourseList) ;
    }

    @Override
    public PageInfo<GradeInfo> queryGradeInfoAll(GradeInfo GradeInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<GradeInfo> GradeInfoList = queryMapper.queryGradeInfoAll(GradeInfo);
        return new PageInfo<>(GradeInfoList) ;
    }

    @Override
    public PageInfo<Inventory> queryInventoryAll(Inventory inventory, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Inventory> InventoryList = queryMapper.queryInventoryAll(inventory);
        return new PageInfo<>(InventoryList) ;
    }

    @Override
    public PageInfo<OfficerInfo> queryOfficerInfoAll(OfficerInfo OfficerInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<OfficerInfo> OfficerInfoList = queryMapper.queryOfficerInfoAll(OfficerInfo);
        return new PageInfo<>(OfficerInfoList) ;
    }

    @Override
    public PageInfo<Order> queryOrderAll(Order order, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Order> OrderList = queryMapper.queryOrderAll(order);
        return new PageInfo<>(OrderList) ;
    }

    @Override
    public PageInfo<Prepare> queryPrepareAll(Prepare prepare, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Prepare> PrepareList = queryMapper.queryPrepareAll(prepare);
        return new PageInfo<>(PrepareList) ;
    }

    @Override
    public PageInfo<ReceiveStu> queryReceiveStuAll(Integer stuId,ReceiveStu receiveStu, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ReceiveStu> ReceiveStuList = queryMapper.queryReceiveStuAll(receiveStu,stuId,bookId,type);
        return new PageInfo<>(ReceiveStuList) ;
    }
    @Override
    public PageInfo<ReceiveTea> queryReceiveTeaAll(Integer teaId,ReceiveTea receiveTea, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ReceiveTea> ReceiveTeaList = queryMapper.queryReceiveTeaAll(receiveTea,teaId,bookId,type);
        return new PageInfo<>(ReceiveTeaList) ;
    }

    @Override
    public PageInfo<Storage> queryStorageAll(Storage storage, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Storage> StorageList = queryMapper.queryStorageAll(storage);
        return new PageInfo<>(StorageList) ;
    }

    @Override
    public PageInfo<StudentInfo> queryStudentInfoAll(StudentInfo StudentInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<StudentInfo> StudentInfoList = queryMapper.queryStudentInfoAll(StudentInfo);
        return new PageInfo<>(StudentInfoList) ;
    }

    @Override
    public PageInfo<TeacherInfo> queryTeacherInfoAll(TeacherInfo TeacherInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<TeacherInfo> TeacherInfoList = queryMapper.queryTeacherInfoAll(TeacherInfo);
        return new PageInfo<>(TeacherInfoList) ;
    }

    @Override
    public PageInfo<Vendor> queryVendorAll(Vendor vendor, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Vendor> VendorList = queryMapper.queryVendorAll(vendor);
        return new PageInfo<>(VendorList) ;
    }





}
