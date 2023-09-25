package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class AuditTea implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer courseId;

    private String courseName;

    private Integer teaId;

    private String teaName;

    private Integer number;

    private Float price;

    private Float sum;

    private Date date;

    private Integer type;

    public AuditTea(Integer id,Integer bookId, String bookName, Integer courseId, String courseName, Integer teaId, String teaName,Integer number,Float price, Float sum, Date date, Integer type) {
        this.id=id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teaId = teaId;
        this.teaName = teaName;
        this.number=number;
        this.price=price;
        this.sum = sum;
        this.date = date;
        this.type = type;
    }
    public AuditTea() {
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

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum ;
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



    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}