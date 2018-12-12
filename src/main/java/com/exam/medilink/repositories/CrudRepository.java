package com.exam.medilink.repositories;

import java.util.List;

public interface CrudRepository<T> {

    //Adds a new item to the repository and returns its id
    int create(T item);

    //Reads all the items in the repository
    List<T> readAll();

    //Reads a specific item from the repository
    T read(int id);

    //Updates an existing item in the repository
    //returns true upon success, false otherwise
    boolean update(T item);

    //Deletes an item in the repository
    //returns true upon success, false otherwise
    boolean delete(int id);
}
