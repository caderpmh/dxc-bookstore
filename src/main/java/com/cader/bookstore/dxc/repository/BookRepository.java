package com.cader.bookstore.dxc.repository;

import com.cader.bookstore.dxc.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("""
            SELECT DISTINCT b FROM Book b JOIN b.authors a
            WHERE (:title IS NULL OR b.title = :title)
            AND (:authorName IS NULL OR a.name = :authorName)
            """)
    List<Book> findByTitleOrAuthorName(String title, String authorName);
}
