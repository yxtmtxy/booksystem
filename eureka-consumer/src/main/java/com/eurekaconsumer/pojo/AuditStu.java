package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class AuditStu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer courseId;

    private String courseName;

    private String grade;

    private Integer stuId;

    private String stuName;

    private Float price;

    private Float sum;

    private Integer number;

    private Date date;

    private Integer type;

    public AuditStu(Integer id, Integer bookId, String bookName, Integer courseId, String courseName, String grade, Integer stuId, String stuName, Float price, Float sum, Integer number, Date date, Integer type) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.grade = grade;
        this.stuId = stuId;
        this.stuName = stuName;
        this.price = price;
        this.sum = sum;
        this.number = number;
        this.date = date;
        this.type = type;
    }
    public AuditStu() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}