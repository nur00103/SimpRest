package com.example.simprest.dao;

import com.example.simprest.model.Author;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.util.List;

public interface AuthorDao {
    public Author save(Author author);

    public Author getAuthorById(String id);
    public List<Address> getAllAddress();
}
