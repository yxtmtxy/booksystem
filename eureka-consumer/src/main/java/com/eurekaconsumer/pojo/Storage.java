package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class Storage implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer number;

    private Float price;

    private Float sum;

    private Integer vendorId;

    private Date date;

    public Storage(Integer id, Integer bookId, String bookName, Integer number, Float price, Float sum, Integer vendorId, Date date) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.number = number;
        this.price = price;
        this.sum = sum;
        this.vendorId = vendorId;
        this.date = date;
    }

    public Storage() {
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

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum ;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}