package com.example.bookshelf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="book_author",
            joinColumns=  @JoinColumn(name="book_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="author_id", referencedColumnName="id") )
    private Set<Author> author = new HashSet<>();

    @ManyToOne
    private Genre genre;

}