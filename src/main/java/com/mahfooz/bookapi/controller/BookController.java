package com.mahfooz.bookapi.controller;

import com.mahfooz.bookapi.model.Book;
import com.mahfooz.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    // Get all the books
    @GetMapping
    public ResponseEntity<?> list(){
        return new ResponseEntity<List<Book>>(bookService.listOfBooks(),HttpStatus.OK);
        //return bookService.listOfBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book=bookService.get(id);
        if(book==null){
            return new ResponseEntity<String>("Book with id:"+id+" not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book){
        Book savedBook=bookService.save(book);
        return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        bookService.delete(id);
        return new ResponseEntity<String>("Book with id:"+id+" deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Book book){
        Book oldBook=bookService.get(id);
        bookService.save(book);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
}
