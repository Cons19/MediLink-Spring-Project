package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;

import java.util.ArrayList;

public class ProductsRepository extends AbstractCrudRepository<Product> {
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
    public void update(Product item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
