package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;

public class ProductsRepository extends AbstractCrudRepository<Product> {
    private static ProductsRepository instance;
    public static  ProductsRepository getInstance() {
        if (instance == null) {
            instance = new ProductsRepository();
        }
        return instance;
    }
    private ProductsRepository() {}

    @Override
    String getItemsFileName() {
        return "products";
    }
}
