package com.example.bookshelf.service;

import com.example.bookshelf.data.BookDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<?> getBooksByAuthorAndGenre(String author, String genre);
}
