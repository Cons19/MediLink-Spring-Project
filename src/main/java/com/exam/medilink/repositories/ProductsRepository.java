package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;

import java.util.ArrayList;

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
    public int create(Product item) {
        return 0;
    }

    @Override
    public ArrayList<Product> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Product item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }
}
