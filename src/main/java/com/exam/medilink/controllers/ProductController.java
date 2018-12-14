package com.exam.medilink.controllers;

import com.exam.medilink.models.Product;
import com.exam.medilink.repositories.CrudRepository;
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
public class ProductController {

//    private static CrudRepository<Product> productsRepository = ProductsRepository.getDummyInstance();
    //uncomment this line to use the actual repository
    private static CrudRepository<Product> productsRepository = ProductsRepository.getInstance();

    @GetMapping("/products")
    public String products(Model model) {

        return getProductsPage(model);
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        Product product = productsRepository.read(id);
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

        model.addAttribute("admin", false);
        model.addAttribute("productsList", filteredList);

        return "products";
    }

    @GetMapping("/product-edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Product item;
        if (id == -1) {
            item = new Product();
            item.setId(-1);
        } else {
            item = productsRepository.read(id);
        }
        model.addAttribute("productItem", item);
        return "product-edit";
    }

    @PostMapping("/product-edit")
    public String edit(@ModelAttribute("productItem") Product product) {
        if (product.getId() == -1) {
            productsRepository.create(product);
        } else {
            productsRepository.update(product);
        }
//        return "products";
        return "redirect:/products";
    }


//    @GetMapping("/product-create")
//    public String create( Model model) {
//
//        Product item;
//        item = new Product();
//        item.setId(-1);
//        productsRepository.create(item);
//        model.addAttribute("productItem", item);
//        return "products";
////        return "redirect:/product-edit";
//    }
//
//    @PostMapping("/product-create")
//    public String create(@ModelAttribute("productItem") Product product) {
//        if (product.getId() == -1) {
//            productsRepository.create(product);
//        } else {
//            productsRepository.update(product);
//        }
////        return "products";
//        return "redirect:/products";
//    }



    @GetMapping("/product-delete")
    public String delete(@RequestParam("id") int id) {
        productsRepository.delete(id);
//        return "products";
        return "redirect:/products";
    }

    static String getProductsPage(Model model) {
        model.addAttribute("productsList", productsRepository.readAll());
        return "products";
    }
}
