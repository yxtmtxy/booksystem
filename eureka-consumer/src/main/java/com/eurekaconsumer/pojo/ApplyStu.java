package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class ApplyStu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer courseId;

    private String courseName;

    private Integer number;

    private Date date;

    private Integer type;

    private Integer stuId;

    public ApplyStu(Integer id, Integer bookId, String bookName, Integer courseId, String courseName, Integer number, Date date, Integer type,Integer stuId) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.number = number;
        this.date = date;
        this.type = type;
        this.stuId = stuId;
    }

    public ApplyStu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}