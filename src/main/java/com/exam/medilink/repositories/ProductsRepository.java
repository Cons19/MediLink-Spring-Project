package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepository extends AbstractCrudRepository<Product> {
    private static CrudRepository<Product> instance;
    public static  CrudRepository<Product> getInstance() {
        if (instance == null) {
            instance = new ProductsRepository();
        }
        return instance;
    }
    private ProductsRepository() {}

    private static CrudRepository<Product> dummyInstance;
    public static  CrudRepository<Product> getDummyInstance() {
        if (dummyInstance == null) {
            dummyInstance = new CrudRepository<Product>() {

                List<Product> placeholderProducts = new ArrayList<>();
                {
                    Lorem lorem = LoremIpsum.getInstance();
                    for (int i = 0; i < 10; i++) {
                        placeholderProducts.add(new Product(placeholderProducts.size(), lorem.getTitle(1, 4),lorem.getParagraphs(1, 2)));
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
        }
        return dummyInstance;
    }

    @Override
    String getItemsFileName() {
        return "products";
    }
}
