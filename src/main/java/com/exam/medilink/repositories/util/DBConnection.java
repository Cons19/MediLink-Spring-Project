package com.exam.medilink.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//#Razvan
public class DBConnection {

    //Credentials and strings
    private static final String USERNAME = null;
    private static final String PASSWORD = null;
    private static final String CONNSTRING = null;

    //Creates a connection and returns it
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}