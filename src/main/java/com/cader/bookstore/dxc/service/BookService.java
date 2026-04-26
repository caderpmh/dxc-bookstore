package com.cader.bookstore.dxc.service;

import com.cader.bookstore.dxc.model.Book;
import com.cader.bookstore.dxc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

//
    public Book add(Book b) {
        if (bookRepo.existsById(b.getIsbn())) {
            throw new RuntimeException("Book exists");
        }
        return bookRepo.save(b);
    }

    public List<Book> search() {
        return bookRepo.findAll();
    }

}
