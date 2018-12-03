package com.exam.medilink.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/product")
    public String product() {
        return "product";
    }
}
