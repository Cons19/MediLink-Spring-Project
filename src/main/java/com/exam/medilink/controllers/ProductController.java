package com.exam.medilink.controllers;

import com.exam.medilink.models.Product;
import com.exam.medilink.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductsRepository productsRepository = ProductsRepository.getInstance();
    private Product product1 = new Product(1, "Marius");

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        product1.setDescription(productsRepository.returnDescription(product1.getId()));
        //System.out.println(productMarius.getDescription());
        model.addAttribute("description", product1.getDescription());
        return "product";
    }
}
