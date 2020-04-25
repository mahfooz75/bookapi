package com.mahfooz.bookapi.service.impl;

import com.mahfooz.bookapi.model.Book;
import com.mahfooz.bookapi.repository.BookRepo;
import com.mahfooz.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book save(Book book) {
       return bookRepo.save(book);
    }

    @Override
    public List<Book> listOfBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book get(Long id) {
        Book book = null;
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isPresent()){
            book=bookOptional.get();
        }
        return book;
    }

    /*@Override
    public void update(Long id, Book book) {

    }*/

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
