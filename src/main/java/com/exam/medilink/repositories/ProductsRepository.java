package com.exam.medilink.repositories;

import com.exam.medilink.models.Product;

import java.io.*;
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
    public ArrayList<Product> readAll()
    {
        throw new UnsupportedOperationException();
    }

    public String returnDescription(int id) {

        String description = "";
        String line = "";
        File file = new File("src\\main\\resources\\product files\\" + id + ".txt");

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
            return description;

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");

        }
        return null;
    }

    @Override
    public Product read(int id) {
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
