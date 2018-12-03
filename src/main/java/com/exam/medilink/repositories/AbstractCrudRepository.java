package com.exam.medilink.repositories;

import com.exam.medilink.repositories.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

abstract class AbstractCrudRepository<T> implements CrudRepository<T>{
    //minimum time that should have passed since the last refresh
    //2 minutes interval
    private static final int REFRESH_THRESHOLD = 1000*60*2;
    //time since last connection refresh took place
    private static long lastConnRefresh;
    //the Connection used to execute the sql statements
    static Connection connection;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    public abstract int create(T item);
    public abstract ArrayList<T> readAll();
    public abstract T read(int id);
    public abstract boolean update(T item);
    public abstract boolean delete(int id);

    //It's called each time the application is accessing the database.
    //On the first call, the method creates the connection and stores the time when created in "lastConnRefresh".
    //Every time the method is called, if the time since the last refresh was more than two minute, it rebuilds the
    //connection.
    protected static void refreshConnection(){
        long currentTime = System.currentTimeMillis();
        //If the time since the last refresh is more than the threshold
        if( currentTime - lastConnRefresh > REFRESH_THRESHOLD){
            lastConnRefresh = currentTime;
            connection = DBConnection.getConnection();
        }
    }
}
