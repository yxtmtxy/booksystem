package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReceiveStu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer courseId;

    private String courseName;

    private Integer sum;

    private Date date;

    private Integer type;

    public ReceiveStu(Integer id, Integer bookId, String bookName, Integer courseId, String courseName, Integer sum, Date date, Integer type) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.sum = sum;
        this.date = date;
        this.type = type;
    }

    public ReceiveStu() {
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
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
        this.type = type ;
    }
}