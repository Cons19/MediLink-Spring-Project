package com.exam.medilink.controllers;

import com.exam.medilink.models.Product;
import com.exam.medilink.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductsRepository productsRepository = new ProductsRepository();
    private Product productMarius = new Product(1, "Marius");

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        productMarius.setDescription(productsRepository.returnDescription(productMarius.getId()));
        //System.out.println(productMarius.getDescription());
        model.addAttribute("description", productMarius.getDescription());
        return "product";
    }
}
