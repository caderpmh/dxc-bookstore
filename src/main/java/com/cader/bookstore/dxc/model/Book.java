
package com.cader.bookstore.dxc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String title;
    @Column(name = "publish_year")
    private String year;
    private Double price;
    private String genre;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

}
