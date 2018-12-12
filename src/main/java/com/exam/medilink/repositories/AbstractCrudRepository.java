package com.exam.medilink.repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractCrudRepository<T> implements CrudRepository<T>{
    private final String ITEMS_FILE_NAME = getItemsFileName() + ".bin";

    public abstract int create(T item);
    public abstract List<T> readAll();
    public abstract T read(int id);
    public abstract boolean update(T item);
    public abstract boolean delete(int id);


    abstract String getItemsFileName();

    public boolean saveItems(List<T> newsList) {
        try (
                FileOutputStream fos = new FileOutputStream(ITEMS_FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(newsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<T> loadItems() {
        List<T> newsList;
        try (
                FileInputStream fis = new FileInputStream(ITEMS_FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            newsList = (List<T>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            newsList = new ArrayList<>();
        }

        return newsList;
    }
}
