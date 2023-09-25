package com.yx.pojo;

import java.io.Serializable;

public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookId;

    private String bookName;

    private Integer number;

    private Float price;

    private Float sum;

    public Inventory(Integer bookId, String bookName, Integer number, Float price, Float sum) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.number = number;
        this.price = price;
        this.sum = sum;
    }

    public Inventory() {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number ;
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
}