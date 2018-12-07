package com.exam.medilink.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product = new Product(1,"Hydrozid", "Best product ever");

    @Test
    public void getId() {
        assertEquals(1,product.getId());
    }

    @Test
    public void setId() {
        product.setId(2);
        assertEquals(2,product.getId());
    }

    @Test
    public void getName() {
        assertEquals("Hydrozid", product.getName());
    }

    @Test
    public void setName() {
        product.setName("Hydromed");
        assertEquals("Hydromed",product.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Best product ever", product.getDescription());
    }

    @Test
    public void setDescription() {
        product.setDescription("Forever and ever best product!");
        assertEquals("Forever and ever best product!", product.getDescription());
    }
}