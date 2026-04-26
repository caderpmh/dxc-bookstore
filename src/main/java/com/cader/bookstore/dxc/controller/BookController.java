package com.cader.bookstore.dxc.controller;

import com.cader.bookstore.dxc.model.Book;
import com.cader.bookstore.dxc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book add(@RequestBody Book book){
        return bookService.add(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.search();
    }



}
