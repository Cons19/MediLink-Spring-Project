package com.exam.medilink.repositories;

import com.exam.medilink.models.News;

import java.util.ArrayList;

//#Razvan
//Repository connecting to the database of the Motorhome model
public class NewsRepository extends AbstractCrudRepository<News> {


    @Override
    public int create(News item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArrayList<News> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public News read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(News item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}