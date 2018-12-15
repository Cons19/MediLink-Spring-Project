package com.exam.medilink.controllers;

import com.exam.medilink.models.News;
import com.exam.medilink.repositories.CrudRepository;
import com.exam.medilink.repositories.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController
{

//    private static CrudRepository<News> newsRepository = NewsRepository.getDummyInstance();
    //uncomment this line to use the actual repository
    private static CrudRepository<News> newsRepository = NewsRepository.getInstance();

    @GetMapping("/news")
    public String news(Model model) {
        return getNewsPage(model, false);
    }

    @GetMapping("/newsArticle")
    public String newsArticle(@RequestParam("id") int id, Model model) {
        model.addAttribute("newsItem", newsRepository.read(id));
        return "news-article";
    }

    @GetMapping("/news-add")
    public String add(Model model) {
        News item = new News();
        item.setId(-1);
        model.addAttribute("newsItem", item);
        return "news-edit";
    }

    @GetMapping("/news-edit")
    public String edit(@RequestParam("id") int id, Model model) {
        News item = newsRepository.read(id);

        model.addAttribute("newsItem", item);
        return "news-edit";
    }

    @PostMapping("/news-edit")
    public String edit(@ModelAttribute("newsItem") News news) {
        if (news.getId() == -1) {
            newsRepository.create(news);
        } else {
            newsRepository.update(news);
        }
        return "redirect:/news";
    }

    @GetMapping("/news-delete")
    public String delete(@RequestParam("id") int id) {
        newsRepository.delete(id);
        return "redirect:/news";
    }

    static String getNewsPage(Model model, boolean isAdmin) {
        model.addAttribute("admin", isAdmin);
        model.addAttribute("newsList", newsRepository.readAll());
        return "news";
    }
}
