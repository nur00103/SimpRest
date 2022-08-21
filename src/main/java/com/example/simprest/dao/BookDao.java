package com.example.simprest.dao;

import com.example.simprest.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getAllBook();

    public Book add(Book book);

    public Book getBookById(String id);

    Boolean deleteBook(String id);

    public Book updateBook(String id, Book book);
}
