package com.yx.service.impl;
import com.yx.dao.BookMapper;
import com.yx.pojo.Book;
import com.yx.service.BookService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper BookMapper;

    @Override
    public PageInfo<Book> queryBookAll(Book book, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Book> BookList = BookMapper.queryBookAll(book);
        return new PageInfo<>(BookList) ;
    }

    @Override
    public void addBookSubmit(Book book) {
        BookMapper.insert(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return BookMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBookSubmit(Book Book) {
        BookMapper.updateByPrimaryKey(Book);
    }

    @Override
    public void deleteBookByIds(List<String> ids) {
        for (String id : ids){
            BookMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
