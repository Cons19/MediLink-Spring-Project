package com.exam.medilink.controllers;

import com.exam.medilink.models.News;
import com.exam.medilink.models.Product;
import com.exam.medilink.models.User;
import com.exam.medilink.repositories.CrudRepository;
import com.exam.medilink.repositories.NewsRepository;
import com.exam.medilink.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private CrudRepository<User> userRepository = new CrudRepository<User>() {
        List<User> userList = new ArrayList<>();
        {
            userList.add(new User("iluvcatz"));
            userList.add(new User("bushdid911"));
            userList.add(new User("dindunuffin"));
            userList.add(new User("fuckingpassword"));
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
    private CrudRepository<Product> productCrudRepository = ProductsRepository.getInstance();
    private CrudRepository<News> newsCrudRepository = NewsRepository.getDummyInstance();

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
            //TODO: create administration view for the web app
            return "ADMIN_TEMPLATE";
        } else {
            model.addAttribute("result", -1);
            return "login";
        }
    }

    @GetMapping("/ADMIN_TEMPLATE")
    public String admin() {
        return "ADMIN_TEMPLATE";
    }

    @PostMapping("/ADMIN_TEMPLATE")
    public String admin(boolean placeholder) {
        return "ADMIN_TEMPLATE";
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
