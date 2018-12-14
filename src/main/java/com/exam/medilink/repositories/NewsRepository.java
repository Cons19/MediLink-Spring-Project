package com.exam.medilink.repositories;

import com.exam.medilink.models.News;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository extends AbstractCrudRepository<News> {
    private static CrudRepository<News> instance;
    public static  CrudRepository<News> getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }
    private NewsRepository() {}

    private static CrudRepository<News> dummyInstance;
    public static CrudRepository<News> getDummyInstance() {
        if (dummyInstance == null) {
            dummyInstance = new CrudRepository<News> () {
                List<News> placeholderNews = new ArrayList<>();
                {
                    Lorem lorem = LoremIpsum.getInstance();
                    for (int i = 0; i < 10; i++) {
                        placeholderNews.add(new News(placeholderNews.size(), lorem.getTitle(5, 10), lorem.getParagraphs(1, 4)));
                    }
                }

                @Override
                public int create(News item) {
                    item.setId(placeholderNews.size());
                    placeholderNews.add(item);
                    return 0;
                }

                @Override
                public List<News> readAll() {
                    return placeholderNews;
                }

                @Override
                public News read(int id) {
                    return placeholderNews.get(id);
                }

                @Override
                public boolean update(News item) {
                    News oldNews;
                    try {
                        oldNews = placeholderNews.get(item.getId());
                    } catch (IndexOutOfBoundsException e) {
                        return false;
                    }
                    oldNews.setTitle(item.getTitle());
                    oldNews.setDescription(item.getDescription());
                    return true;
                }

                @SuppressWarnings("Duplicates")
                @Override
                public boolean delete(int id) {
                    //setting to null instead of removing so the ids of all news remain unchanged
                    try {
                        //noinspection ResultOfMethodCallIgnored
                        placeholderNews.get(id);
                    } catch (IndexOutOfBoundsException e) {
                        return false;
                    }

                    placeholderNews.set(id, null);
                    return true;
                }
            };
        }
        return dummyInstance;
    }

    @Override
    String getItemsFileName() {
        return "news";
    }

}