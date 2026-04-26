package com.cader.bookstore.dxc.controller;

import com.cader.bookstore.dxc.model.Book;
import com.cader.bookstore.dxc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.add(book), HttpStatus.CREATED) ;
    }

    @GetMapping
    public List<Book> findByTitleOrAuthorName(@RequestParam(required = false) String title, @RequestParam(required = false) String authorName) {
        return bookService.search(title, authorName);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(isbn,book));

    }
    @DeleteMapping
    public ResponseEntity<?> deleteBookById(@PathVariable String isbn){
        bookService.deleteBookById(isbn);
        return ResponseEntity.ok(isbn + "deleted successfully");
    }

}
