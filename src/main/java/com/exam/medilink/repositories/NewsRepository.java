package com.exam.medilink.repositories;

import com.exam.medilink.models.News;

import java.util.List;

public class NewsRepository extends AbstractCrudRepository<News> {
    private static NewsRepository instance;
    public static  NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }
    private NewsRepository() {}

    @Override
    public int create(News item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<News> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public News read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(News item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    String getItemsFileName() {
        return "news";
    }

}