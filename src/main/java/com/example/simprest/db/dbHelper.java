package com.example.simprest.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class dbHelper {
    public static Connection connect(){
        Connection connection = null;
        try {
            Context ctx = new InitialContext();

            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
