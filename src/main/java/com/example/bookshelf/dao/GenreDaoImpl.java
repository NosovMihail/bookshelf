package com.example.bookshelf.dao;

import com.example.bookshelf.model.Genre;
import com.example.bookshelf.utils.HibernateSessionFactoryUtil;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao{

    @Override
    public List<Genre> findByGenreName(String genre) {
        val session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        val query = session.createQuery("SELECT a.id FROM Author a \n" +
                "WHERE LOWER(a.name) LIKE CONCAT('%', LOWER(:genreParam), '%') ");
        query.setParameter("genreParam", genre);
        return query.getResultList();
    }

}
