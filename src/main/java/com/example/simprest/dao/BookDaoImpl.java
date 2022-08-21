package com.example.simprest.dao;

import com.example.simprest.db.dbHelper;
import com.example.simprest.model.Author;
import com.example.simprest.model.Book;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDaoImpl extends dbHelper implements BookDao {

    private final AuthorDao authorDao=new AuthorDaoImpl();
    @Override
    public List<Book> getAllBook() {
        List<Book> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("SELECT b.*,a.author FROM book b inner join author a where b.author_id=a.id");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int page = rs.getInt("page_count");
                String authorId = rs.getString("author_id");
                String authorName = rs.getString("author");
                Author author = new Author(authorId, authorName);

                Book book = new Book(id, name, type, page, author);
                result.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return result;
    }

    @Override
    public Book add(Book book) {

        String id=UUID.randomUUID().toString();
        Author savedAuthor=authorDao.save(book.getAuthor());
        String sql="INSERT INTO book (id,name,type,page_count,author_id) values(?,?,?,?,?)";
        try (Connection cn = connect()) {
            PreparedStatement p = cn.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, book.getName());
            p.setString(3, book.getType());
            p.setInt(4, book.getPage());
            p.setString(5, savedAuthor.getId());
            p.execute();
            //cn.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return getBookById(id);
    }
@Override
    public Book getBookById(String id) {
    Book res=null;

    try (Connection c = connect()) {
        PreparedStatement p = c.prepareStatement("SELECT book.*,author.author FROM book inner join author where book.id=? and book.author_id=author.id");
        p.setString(1,id);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            String bookId = rs.getString("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            int page=rs.getInt("page_count");
            String authorId=rs.getString("author_id");
            String authorName=rs.getString("author");

            Author author1=new Author(authorId,authorName);
            Book book=new Book(bookId,name,type,page,author1);
            res=book;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return res;
    }

    @Override
    public Boolean deleteBook(String id) {
        String sql="delete from book where id=?";
        try(Connection c=connect()){
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,id);
            p.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book updateBook(String id, Book book) {
        String sql="Update book set name=?,type=?,page_count=?,author_id=? where id=?";
        try (Connection cn = connect()) {
            PreparedStatement p = cn.prepareStatement(sql);
            Author updatedAuthor=authorDao.update(book.getAuthor().getId(),book.getAuthor());
            p.setString(1,book.getName());
            p.setString(2,book.getType());
            p.setInt(3,book.getPage());
            p.setString(4, updatedAuthor.getId());
            p.setString(5,id);
            p.execute();
            return getBookById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
