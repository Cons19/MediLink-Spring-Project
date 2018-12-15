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
        return getProductsPage(model, false);
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {
        model.addAttribute("productItem", productsRepository.read(id));
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
                if (product != null) {
                    String name = product.getName().toLowerCase().replaceAll(" ", "");
                    if (name.contains(filter)) {
                        filteredList.add(product);
                    }
                }
            }
        }
        model.addAttribute("admin", false);
        model.addAttribute("productsList", filteredList);
        return "products";
    }

    @GetMapping("/product-add")
    public String add(Model model) {
        Product item = new Product();
        item.setId(-1);
        model.addAttribute("productItem", item);
        return "product-edit";
    }

    @GetMapping("/product-edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Product item = productsRepository.read(id);

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
        return "redirect:/products";
    }

    @GetMapping("/product-delete")
    public String delete(@RequestParam("id") int id) {
        productsRepository.delete(id);
        return "redirect:/products";
    }

    static String getProductsPage(Model model, boolean isAdmin) {
        model.addAttribute("admin", isAdmin);
        model.addAttribute("productsList", productsRepository.readAll());
        return "products";
    }
}
