package com.exam.medilink.controllers;

import com.exam.medilink.models.User;
import com.exam.medilink.repositories.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private CrudRepository<User> userRepository = new CrudRepository<User>() {
        List<User> userList = new ArrayList<>();
        {
            userList.add(new User("pass"));
            userList.add(new User("password"));
            userList.add(new User("marius"));
            userList.add(new User("paul"));
            userList.add(new User("constantin"));
            userList.add(new User("dragos"));
        }
        @Override
        public int create(User item) {
            return -1;
        }

        @Override
        public List<User> readAll() {
            return userList;
        }

        @Override
        public User read(int id) {
            return userList.get(id);
        }

        @Override
        public boolean update(User item) {
            return false;
        }

        @Override
        public boolean delete(int id) {
            return false;
        }
    };

    private User administrator;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("password") String password, Model model) {
        //logout
        if (administrator != null) {
            administrator = null;
        }

        List<User> users = userRepository.readAll();
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                administrator = user;
                break;
            }
        }

        if (administrator != null) {
            return "redirect:/admin-page";
        } else {
            return "login";
        }
    }

    @GetMapping("/admin-page")
    public String admin() {
        if (administrator != null) {
            return "admin-page";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/admin-page")
    public String admin(@ModelAttribute("page") String page, Model model) {
        if (administrator != null) {
            if (page.equals("products")) {
                return ProductController.getProductsPage(model, true);
            } else if (page.equals("news")) {
                return NewsController.getNewsPage(model, true);
            } else {
                return "admin-page";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }
}
