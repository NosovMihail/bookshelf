package com.example.bookshelf.service;

import com.example.bookshelf.data.BookDTO;
import java.util.List;

public interface BookService {
    List<BookDTO> getBooksByAuthorAndGenre(String author, String genre);
}
