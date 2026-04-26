package com.cader.bookstore.dxc.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthday;
}
