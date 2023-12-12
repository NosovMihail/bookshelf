package com.example.bookshelf.controller;

import com.example.bookshelf.data.BookDTO;
import com.example.bookshelf.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getBooksByAuthorAndGenre(@RequestParam(required = false) String author, @RequestParam(required = false) String genre) {
        return bookService.getBooksByAuthorAndGenre(author, genre);
    }
}