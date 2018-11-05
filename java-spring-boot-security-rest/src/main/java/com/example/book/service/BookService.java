package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listTasks() {

        return this.bookRepository.findAll();
    }

    public Book saveTask(Book t) {
        return this.bookRepository.save(t);
    }
}
