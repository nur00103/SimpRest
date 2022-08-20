package com.example.simprest.service;

import com.example.simprest.dao.BookDao;
import com.example.simprest.dao.BookDaoImpl;
import com.example.simprest.dto.request.BookRequest;
import com.example.simprest.dto.response.AuthorResponse;
import com.example.simprest.dto.response.BookResponse;
import com.example.simprest.dto.response.ResponseModel;
import com.example.simprest.model.Author;
import com.example.simprest.model.Book;
import com.example.simprest.model.Status;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{

    private final BookDao bookDao=new BookDaoImpl();

    @Override
    public ResponseModel<List<BookResponse>> list() {
        List<Book> bookList=bookDao.getAllBook();
        List<BookResponse> bookResponseList=new ArrayList<>();
        for (Book book: bookList){
            BookResponse bookResponse=new BookResponse();
            bookResponse.setId(book.getId());
            bookResponse.setName(book.getName());
            bookResponse.setType(book.getType());
            bookResponse.setType(book.getType());
            AuthorResponse authorResponse=new AuthorResponse();
            authorResponse.setId(book.getAuthor().getId());
            authorResponse.setAuthor(book.getAuthor().getAuthor());
            bookResponse.setAuthorResponse(authorResponse);
            bookResponseList.add(bookResponse);
        }
            return ResponseModel.<List<BookResponse>>builder().result(bookResponseList)
                    .status(Status.getSuccess()).build();

    }

    @Override
    public ResponseModel<BookResponse> save(BookRequest bookRequest) {
        Book book=new Book();
        book.setId(bookRequest.getId());
        book.setName(bookRequest.getName());
        book.setType(bookRequest.getType());
        book.setPage(bookRequest.getPage());
        Author author=new Author();
        author.setId(bookRequest.getAuthorRequest().getId());
        author.setAuthor(bookRequest.getAuthorRequest().getAuthor());
        book.setAuthor(author);
        Book savedBook= bookDao.add(book);
        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(savedBook.getId());
        bookResponse.setName(savedBook.getName());
        bookResponse.setType(savedBook.getType());
        bookResponse.setPage(savedBook.getPage());
        AuthorResponse authorResponse=new AuthorResponse();
        authorResponse.setId(savedBook.getAuthor().getId());
        authorResponse.setAuthor(savedBook.getAuthor().getAuthor());
        bookResponse.setAuthorResponse(authorResponse);
        return ResponseModel.<BookResponse>builder().result(bookResponse)
                .status(Status.getSuccess()).build();
    }
}
