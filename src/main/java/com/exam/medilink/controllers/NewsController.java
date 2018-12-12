package com.exam.medilink.controllers;

import com.exam.medilink.models.News;
import com.exam.medilink.repositories.CrudRepository;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

public class NewsController
{
    private CrudRepository<News> newsRepository = new CrudRepository<News>() {

        List<News> placeholderNews = new ArrayList<>();
        {
            String[] names = new String[]{"First news", "Second news", "Third news", "Fourth news",
                    "Fifth news", "Sixth news"};

            Lorem lorem = LoremIpsum.getInstance();

            for (int i = 0; i < names.length; i++) {
                placeholderNews.add(new News(placeholderNews.size(), names[i], lorem.getParagraphs(1, 4)));
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
            oldNews.setBody(item.getBody());
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
