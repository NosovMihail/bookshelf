package com.example.bookshelf.dao;


import com.example.bookshelf.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreDao {

    List<Genre> findByGenreName(String genre);

}
