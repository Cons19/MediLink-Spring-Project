package com.exam.medilink.repositories;

import java.util.ArrayList;

public interface CrudRepository<T> {

    //Adds a new element in the table
    //and return its database id
    int create(T item);

    //Reads all the elements of the table
    ArrayList<T> readAll();

    //Reads a specific element from the table
    T read(int id);

    //Updates an existing element in the table
    void update(T item);

    //Deletes an element from the table
    void delete(int id);
}
