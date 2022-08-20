package com.example.simprest.dao;

import com.example.simprest.db.dbHelper;
import com.example.simprest.model.Author;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl extends dbHelper implements AuthorDao {
    @Override
    public Author save(Author author) {

        try (Connection cn = connect()) {
            PreparedStatement p = cn.prepareStatement("INSERT INTO author(id,author)values (?,?)");
            p.setString(1,author.getId());
            p.setString(2, author.getAuthor());
            p.execute();
            return getAuthorById(author.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
@Override
    public Author getAuthorById(String id) {
        Author res=null;

    try (Connection c = connect()) {
        PreparedStatement p = c.prepareStatement("SELECT * FROM author where id=?");
        p.setString(1,id);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            String AuthorId = rs.getString("id");
            String author = rs.getString("author");

            Author author1=new Author(AuthorId,author);
            res= author1;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return res;
    }

    @Override
    public List<Address> getAllAddress() {

        return null;
    }
}
