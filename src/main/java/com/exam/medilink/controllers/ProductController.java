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

    private ProductsRepository pd = ProductsRepository.getInstance();

    private CrudRepository<Product> productsRepository = new CrudRepository<Product>() {

        List<Product> placeholderProducts = new ArrayList<>();
        {
            String[] names = new String[]{"First product", "Second product", "Third product", "Fourth product",
                    "Fifth product", "Sixth product"};
            for (int i = 0; i < names.length; i++) {
                placeholderProducts.add(new Product(placeholderProducts.size(), names[i]));
            }
        }

        @Override
        public int create(Product item) {
            item.setId(placeholderProducts.size());
            placeholderProducts.add(item);
            return 0;
        }

        @Override
        public List<Product> readAll() {
            return placeholderProducts;
        }

        @Override
        public Product read(int id) {
            return placeholderProducts.get(id);
        }

        @Override
        public boolean update(Product item) {
            Product oldProd;
            try {
                oldProd = placeholderProducts.get(item.getId());
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
            oldProd.setName(item.getName());
            oldProd.setDescription(item.getDescription());
            return true;
        }

        @SuppressWarnings("Duplicates")
        @Override
        public boolean delete(int id) {
            //setting to null instead of removing so the ids of the products remain unchanged
            try {
                //noinspection ResultOfMethodCallIgnored
                placeholderProducts.get(id);
            } catch (IndexOutOfBoundsException e) {
                return false;
            }

            placeholderProducts.set(id, null);
            return true;
        }
    };

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("productsList", productsRepository.readAll());
        //test
        return "products";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") int id, Model model) {

        Product product = pd.read(id);
        product.setName(productsRepository.read(id).getName());

        model.addAttribute("description", product.getDescription());
        model.addAttribute("title", product.getName());

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
