package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductsRepository extends AbstractCrudRepository<Product> {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String DIR = "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "static" + FILE_SEPARATOR + "product files" + FILE_SEPARATOR + "";

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
    public ArrayList<Product> readAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product read(int id) {

        Product product = new Product();
        String description = "";
        String line;
        File file = new File(DIR + id + ".txt");
        try {
            // FileReader reads text files in the default encoding
            FileReader fileReader = new FileReader(file);
            // FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                description += line;
                description += '\n';
            }

            bufferedReader.close();
            product.setDescription(description);
            return product;

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");

        }
        return null;
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
