package com.eurekaconsumer.service;

import com.eurekaconsumer.pojo.Book;
import com.eurekaconsumer.utils.DataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "base-provider",contextId="Book")
public interface BookService2 {
    //教材添加
    @RequestMapping("/addBookSubmit")
    DataInfo addBookSubmit(@RequestBody Book book);
    //修改界面跳转
    @GetMapping("/queryBook")
    Book queryBookById(@RequestParam("bookId") Integer bookId);
    //教材修改
    @RequestMapping("/updateBookSubmit")
    DataInfo updateBookSubmit(@RequestBody Book book);
    //删除教材
    @RequestMapping("/deleteBook")
    DataInfo deleteBook(@RequestParam("bookIds") String bookIds);
    



}
