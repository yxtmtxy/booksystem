package com.yx.dao;

import com.yx.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookAll(Book book);
}