package com.example.bookshelf.dao;

import com.example.bookshelf.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao {

    List<Author> findByAuthorName(String author);

}
