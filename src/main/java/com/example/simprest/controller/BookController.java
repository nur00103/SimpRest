package com.example.simprest.controller;

import com.example.simprest.dto.request.BookRequest;
import com.example.simprest.dto.response.BookResponse;
import com.example.simprest.dto.response.ResponseModel;
import com.example.simprest.model.Book;
import com.example.simprest.service.BookService;
import com.example.simprest.service.BookServiceImpl;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.*;

@Path("/book-shop")
public class BookController {

    private BookService bookService=new BookServiceImpl();


    @GET
    @Path("/bookList")
    @Produces("application/json")
    public ResponseModel<List<BookResponse>> bookList(){
        return bookService.list();
    }

    @POST
    @Path("/bookSave")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseModel<BookResponse> bookSave(BookRequest bookRequest){
        return bookService.save(bookRequest);
    }
}
