package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询所有教材信息（分页）
     */
    PageInfo<Book> queryBookAll(Book book,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addBookSubmit(Book book);

    /**
     * 根据id查询（修改）
     */
    Book queryBookById(Integer id);

    /**
     * 修改提交
     */
    void updateBookSubmit(Book book);

    /**
     * 删除
     */
    void deleteBookByIds(List<String> ids);

}