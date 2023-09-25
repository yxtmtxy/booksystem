package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Book;
import com.eurekaconsumer.service.BookService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController2 {

    @Autowired
    private BookService2 bookService2;

    @Autowired
    private queryService queryService;

    /**
     * 跳转教材信息管理页面
     */
    @GetMapping("/bookIndex")
    public String bookIndex(){
        return "book/bookIndex";
    }
    /**
     *
     * 跳转到教材信息一览界面
     */
    @GetMapping("/bookInfo")
    public String bookInfo(){
        return "book/bookInfo";
    }

    /**
     * 添加教材信息添加
     */
    @RequestMapping("/bookAdd")
    public String bookAdd(){
        return "book/bookAdd";
    }

    @RequestMapping("/bookAll")
    @ResponseBody
    public DataInfo queryBookAll(Book book, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Book> pageInfo = queryService.queryBookAll(book,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/addBookSubmit")
    @ResponseBody
    public DataInfo addBookSubmit(@RequestBody  Book book){
        return bookService2.addBookSubmit(book);
    }

    @GetMapping("/queryBookById")
    public String queryBookById(@RequestParam("bookId") Integer bookId, Model model)
    {
        Book book = bookService2.queryBookById(bookId);
        model.addAttribute("info",book);
        return "book/updateBook";
    }

    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public DataInfo updateBookSubmit(@RequestBody  Book book){
        return bookService2.updateBookSubmit(book);
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public DataInfo deleteBook(@RequestParam("bookIds") String bookIds){
        return bookService2.deleteBook(bookIds);
    }


}
