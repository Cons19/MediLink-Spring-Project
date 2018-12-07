package com.exam.medilink.controllers;

import com.exam.medilink.models.User;
import com.exam.medilink.repositories.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    private CrudRepository<User> userRepository;
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

        ArrayList<User> users = userRepository.readAll();
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

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
