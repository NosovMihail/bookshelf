package com.example.bookshelf.dao;

import com.example.bookshelf.model.Author;
import com.example.bookshelf.utils.HibernateSessionFactoryUtil;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao{


    @Override
    public List<Author> findByAuthorName(String author) {
        val session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        val query = session.createQuery("SELECT a.id FROM Author a \n" +
                "WHERE LOWER(a.name) LIKE CONCAT('%', LOWER(:authorParam), '%') ");
        query.setParameter("authorParam", author);
        return query.getResultList();
    }
}
