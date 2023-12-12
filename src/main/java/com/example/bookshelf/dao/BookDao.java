package com.example.bookshelf.dao;

import com.example.bookshelf.data.BookDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    List<BookDTO> findByAuthorAndGenre(String author, String genre);

}
