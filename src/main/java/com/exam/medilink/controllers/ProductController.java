package com.exam.medilink.controllers;

import com.exam.medilink.models.Product;
import com.exam.medilink.repositories.CrudRepository;
import com.exam.medilink.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private CrudRepository<Product> productsRepository = ProductsRepository.getDummyInstance();
    //uncomment this line to use the actual repository
//    private CrudRepository<Product> productsRepository = ProductsRepository.getInstance();

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("productsList", productsRepository.readAll());
        //test
        return "products";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        Product product = productsRepository.read(id);
//        product.setName(productsRepository.read(id).getName());

        model.addAttribute("title", product.getName());
        model.addAttribute("description", product.getDescription());

        return "product";
    }

    @PostMapping("/search")
    public String search(@RequestParam("q") String filter, Model model) {
        List<Product> productList = productsRepository.readAll();
        List<Product> filteredList = new ArrayList<>();

        if (filter.isEmpty()) {
            filteredList = productList;
        } else {
            filter = filter.toLowerCase().replaceAll(" ", "");
            for (Product product : productList) {
                String name = product.getName().toLowerCase().replaceAll(" ", "");
                if (name.contains(filter)) {
                    filteredList.add(product);
                }
            }
        }

        model.addAttribute("productsList", filteredList);

        return "products";
    }
}
