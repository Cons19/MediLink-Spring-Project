package com.exam.medilink.repositories;

import com.exam.medilink.models.News;

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
    String getItemsFileName() {
        return "news";
    }

}