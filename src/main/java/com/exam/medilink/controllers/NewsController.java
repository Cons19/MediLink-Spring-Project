package com.exam.medilink.controllers;

import com.exam.medilink.models.News;
import com.exam.medilink.repositories.CrudRepository;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController
{

    private CrudRepository<News> newsRepository = new CrudRepository<News>() {

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


    @GetMapping("/news")
    public String news(Model model) {

        model.addAttribute("newsList", newsRepository.readAll());
        return "news";
    }

    @GetMapping("/newsArticle")
    public String newsArticle(@RequestParam("id") int id, Model model) {

        News news = newsRepository.read(id);
        news.setTitle(newsRepository.read(id).getTitle());

        model.addAttribute("description", news.getDescription());
        model.addAttribute("title", news.getTitle());

        return "news-article";
    }


}
