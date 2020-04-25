package com.mahfooz.bookapi.service;

import com.mahfooz.bookapi.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

    Book save(Book book);

    List<Book> listOfBooks();

    Book get(Long id);

    void update(Long id,Book book);

    void delete(Long id);

}
