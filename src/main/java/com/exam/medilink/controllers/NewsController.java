package com.exam.medilink.controllers;

import com.exam.medilink.models.News;
import com.exam.medilink.repositories.CrudRepository;
import com.exam.medilink.repositories.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController
{

    private CrudRepository<News> newsRepository = NewsRepository.getDummyInstance();
    //uncomment this line to use the actual repository
//    private CrudRepository<News> newsRepository = NewsRepository.getInstance();

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

    @GetMapping("/news-delete")
    public String delete(@RequestParam("id") int id) {
        newsRepository.delete(id);
        return "news";
    }


}
