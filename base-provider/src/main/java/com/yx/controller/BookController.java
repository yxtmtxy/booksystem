package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Book;
import com.yx.service.BookService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//教材管理
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    /**
     * 查询所有数据
     */
    @RequestMapping("/bookAll")
    @ResponseBody
    public DataInfo queryBookAll( Book book, @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Book> pageInfo = bookService.queryBookAll(book,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addBookSubmit")
    @ResponseBody
    public DataInfo addBookSubmit(@RequestBody Book book){
        bookService.addBookSubmit(book);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryBook")
    @ResponseBody
    public Book queryBookById(@RequestParam("bookId") Integer bookId){
        return bookService.queryBookById(bookId);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public DataInfo updateBookSubmit(@RequestBody  Book book){
        bookService.updateBookSubmit(book);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteBook")
    @ResponseBody
    public DataInfo deleteBook(@RequestParam("bookIds") String bookIds){
        List<String> list= Arrays.asList(bookIds.split(","));
        bookService.deleteBookByIds(list);
        return DataInfo.ok();
    }

}
