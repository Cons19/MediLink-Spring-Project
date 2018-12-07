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

    private Product product1 = new Product(1, "First product");
    private Product product2 = new Product(2, "Second product");
    private Product product3 = new Product(3, "Third product");
    private Product product4 = new Product(4, "Fourth product");
    private Product product5 = new Product(5, "Fifth product");
    private Product product6 = new Product(6, "Sixth product");

    @GetMapping("/products")
    public String products() {

        product1.setDescription(productsRepository.returnDescription(product1.getId()));
        product2.setDescription(productsRepository.returnDescription(product2.getId()));
        product3.setDescription(productsRepository.returnDescription(product3.getId()));
        product6.setDescription(productsRepository.returnDescription(product6.getId()));
        product4.setDescription(productsRepository.returnDescription(product4.getId()));
        product5.setDescription(productsRepository.returnDescription(product5.getId()));

        return "products";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        switch(id) {
            case 1: model.addAttribute("description", product1.getDescription());
                    model.addAttribute("title", product1.getName());
                    break;
            case 2: model.addAttribute("description", product2.getDescription());
                    model.addAttribute("title", product2.getName());
                    break;
            case 3: model.addAttribute("description", product3.getDescription());
                    model.addAttribute("title", product3.getName());
                    break;
            case 4: model.addAttribute("description", product4.getDescription());
                    model.addAttribute("title", product4.getName());
                    break;
            case 5: model.addAttribute("description", product5.getDescription());
                    model.addAttribute("title", product5.getName());
                    break;
            case 6: model.addAttribute("description", product6.getDescription());
                    model.addAttribute("title", product6.getName());
                    break;
        }
        return "product";
    }
}
