package com.example.bookshelf.dao;

import com.example.bookshelf.data.BookDTO;
import com.example.bookshelf.utils.HibernateSessionFactoryUtil;
import lombok.val;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public List<BookDTO> findByAuthorAndGenre(String author, String genre) {
        val session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        val query = session.createQuery(
                "SELECT b.id AS id, b.title AS title, g.genre AS genre, cast(LISTAGG(a.name, ', ') as java.lang.String) AS name\n" +
                "FROM Book b\n" +
                "LEFT JOIN b.author a\n" +
                "LEFT JOIN b.genre g\n" +
                "WHERE b.id IN (SELECT book.id\n" +
                "FROM Book book\n" +
                "JOIN b.author a\n" +
                "JOIN b.genre g\n" +
                "WHERE (:authorParam IS NULL OR LOWER(a.name) LIKE CONCAT('%', LOWER(:authorParam), '%'))\n" +
                "AND (:genreParam IS NULL OR LOWER(g.genre) LIKE CONCAT('%', LOWER(:genreParam), '%')))\n" +
                "OR (:authorParam IS NULL and b.id IN (SELECT book.id\n" +
                "FROM Book book\n" +
                "JOIN b.genre g\n" +
                "WHERE (:genreParam IS NULL OR LOWER(g.genre) LIKE CONCAT('%', LOWER(:genreParam), '%'))))\n" +
                "OR (:genreParam IS NULL and b.id IN (SELECT book.id\n" +
                "FROM Book book\n" +
                "JOIN b.author a\n" +
                "WHERE (:authorParam IS NULL OR LOWER(a.name) LIKE CONCAT('%', LOWER(:authorParam), '%'))))\n" +
                "OR (:genreParam IS NULL and :authorParam IS NULL)\n" +
                "GROUP BY b.id, b.title, g.genre");
        query.setParameter("authorParam", author);
        query.setParameter("genreParam", genre);
        return query.setResultTransformer(Transformers.aliasToBean(BookDTO.class)).getResultList();
    }
}
