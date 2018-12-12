package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductsRepositoryTest {

    private ProductsRepository mProductCrudRepository;
    private Lorem mLorem;
    private List<Product> mPlaceholderProducts;

    @Before
    public void setUp() {
        mProductCrudRepository = ProductsRepository.getInstance();
        mLorem = LoremIpsum.getInstance();
        mPlaceholderProducts = new ArrayList<>();

        Lorem lorem = LoremIpsum.getInstance();
        for (int i = 0; i < 10; i++) {
            mPlaceholderProducts.add(new Product(mPlaceholderProducts.size(), lorem.getTitle(1, 4),lorem.getParagraphs(1, 2)));
        }

        mProductCrudRepository.saveItems(mPlaceholderProducts);
    }

    @Test
    public void create() {
        Product item = new Product(-1, mLorem.getTitle(1, 4), mLorem.getParagraphs(1, 2));
        mPlaceholderProducts.add(item);
        int id = mPlaceholderProducts.indexOf(item);

        int id2 = mProductCrudRepository.create(item);
        assertEquals(id, id2);
        assertNotEquals(-1, id2);
        assertEquals(mProductCrudRepository.read(id2), mPlaceholderProducts.get(id2));

    }

    @Test
    public void readAll() {
        assertNotNull(mProductCrudRepository.readAll());
        assertEquals(mProductCrudRepository.readAll(), mPlaceholderProducts);
    }

    @Test
    public void readOne() {
        for (int i = 0; i < mPlaceholderProducts.size(); i++) {
            assertEquals(mProductCrudRepository.read(i), mPlaceholderProducts.get(i));
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}