package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.AccountService;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> listBooks() {

        return ResponseEntity.ok(this.bookService.listTasks());
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book t) {
        return ResponseEntity.ok(this.bookService.saveTask(t));
    }
}
