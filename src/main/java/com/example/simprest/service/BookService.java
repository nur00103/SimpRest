package com.example.simprest.service;

import com.example.simprest.dto.request.BookRequest;
import com.example.simprest.dto.response.BookResponse;
import com.example.simprest.dto.response.ResponseModel;

import java.util.List;

public interface BookService {
    public ResponseModel<List<BookResponse>> list();

    public ResponseModel<BookResponse> save(BookRequest bookRequest);
}
