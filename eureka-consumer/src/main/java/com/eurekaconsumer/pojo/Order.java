package com.eurekaconsumer.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookId;

    private String bookName;

    private Integer type;

    private Integer reId;

    private Integer store;

    private Integer number;

    private Integer state;

    private Date startDate;

    public Order(Integer id, Integer bookId, String bookName, Integer type, Integer reId, Integer store,Integer number,Integer state, Date startDate) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.type = type;
        this.reId = reId;
        this.store = store;
        this.number=number;
        this.state = state;
        this.startDate = startDate;

    }

    public Order() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type ;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state ;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}