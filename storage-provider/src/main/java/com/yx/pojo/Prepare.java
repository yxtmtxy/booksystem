package com.yx.pojo;

import java.io.Serializable;

public class Prepare implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookId;

    private String bookName;

    private Integer storage;

    private Integer needNum;

    private Integer suggestNum;

    public Prepare(Integer bookId, String bookName, Integer storage, Integer needNum, Integer suggestNum) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.storage = storage;
        this.needNum = needNum;
        this.suggestNum = suggestNum;
    }

    public Prepare() {
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

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage ;
    }

    public Integer getNeedNum() {
        return needNum;
    }

    public void setNeedNum(Integer needNum) {
        this.needNum = needNum;
    }

    public Integer getSuggestNum() {
        return suggestNum;
    }

    public void setSuggestNum(Integer suggestNum) {
        this.suggestNum = suggestNum;
    }
}