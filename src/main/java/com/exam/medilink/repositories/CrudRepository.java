package com.exam.medilink.repositories;

import java.util.List;

public interface CrudRepository<T> {

    //Adds a new element in the table
    //and returns its database id
    int create(T item);

    //Reads all the elements of the table
    List<T> readAll();

    //Reads a specific element from the table
    T read(int id);

    //Updates an existing element in the table
    //returns true upon success, false otherwise
    boolean update(T item);

    //Deletes an element from the table
    //returns true upon success, false otherwise
    boolean delete(int id);
}
