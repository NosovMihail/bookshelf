INSERT INTO GENRE (id, genre) VALUES (1, 'horror'), (2, 'detective');
INSERT INTO AUTHOR (id, name) VALUES (1, 'Mark'), (2, 'Jorge');
INSERT INTO BOOK  VALUES (1, 'Small book', 2);
INSERT INTO BOOK  VALUES (2, 'Big book', 2);
INSERT INTO BOOK  VALUES (3, 'Medium book', null);
INSERT INTO BOOK  VALUES (4, 'Strange book', null);
INSERT INTO BOOK  VALUES (5, 'Horror book', 1);
INSERT INTO book_author (book_id, author_id) VALUES (1, 1), (2, 1), (2, 2), (3, 2);