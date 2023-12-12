package com.example.bookshelf.service;

import com.example.bookshelf.dao.AuthorDao;
import com.example.bookshelf.dao.GenreDao;
import com.example.bookshelf.data.BookDTO;
import com.example.bookshelf.dao.BookDao;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookDao bookDao;

    @Autowired
    private final AuthorDao authorDao;

    @Autowired
    private final GenreDao genreDao;

    @Override
    public ResponseEntity<?> getBooksByAuthorAndGenre(String author, String genre) {
        val books = bookDao.findByAuthorAndGenre(author, genre);
        if(books.isEmpty()){
            if(authorDao.findByAuthorName(author).isEmpty() || genreDao.findByGenreName(genre).isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найден автор или жанр"); //Ошибку можно уточнить разделением условий
            }
        }
        return ResponseEntity.ok(books);
    }
}
