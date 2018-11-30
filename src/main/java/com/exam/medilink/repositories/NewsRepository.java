package com.exam.medilink.repositories;

import java.util.ArrayList;

//#Razvan
//Repository connecting to the database of the Motorhome model
public class NewsRepository extends AbstractCrudRepository<Object> {


    @Override
    public int create(Object item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArrayList<Object> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}