package com.cader.bookstore.dxc.service;

import com.cader.bookstore.dxc.model.Book;
import com.cader.bookstore.dxc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Book> search(String title, String authorName) {
        return bookRepo.findByTitleOrAuthorName(title, authorName);
    }

    public Book updateBook(String isbn, Book updatedBook){
        Book existing = bookRepo.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found."));
        existing.setTitle(updatedBook.getTitle());
        existing.setYear(updatedBook.getYear());
        existing.setPrice(updatedBook.getPrice());
        existing.setGenre(updatedBook.getGenre());
        existing.setAuthors(updatedBook.getAuthors());

        return  bookRepo.save(existing);
    }

    public void deleteBookById(String isbn){
        bookRepo.deleteById(isbn);
    }
}
