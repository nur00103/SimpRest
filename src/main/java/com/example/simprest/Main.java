package com.example.simprest;

import com.example.simprest.dao.BookDao;
import com.example.simprest.dao.BookDaoImpl;
import com.example.simprest.model.Book;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao=new BookDaoImpl();
        Book book=bookDao.getBookById("1");
        System.out.println(book.getName());
    }
}
