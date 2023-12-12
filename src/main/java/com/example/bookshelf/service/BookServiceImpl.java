package com.example.bookshelf.service;

import com.example.bookshelf.data.BookDTO;
import com.example.bookshelf.dao.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookDao bookDao;

    @Override
    public List<BookDTO> getBooksByAuthorAndGenre(String author, String genre) {
        return bookDao.findByAuthorAndGenre(author, genre);
    }
}
