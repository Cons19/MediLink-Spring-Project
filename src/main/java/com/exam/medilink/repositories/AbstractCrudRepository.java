package com.exam.medilink.repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractCrudRepository<T> implements CrudRepository<T>{
    private final String ITEMS_FILE_NAME = getItemsFileName() + ".bin";

    AbstractCrudRepository() {

    }

    @Override
    public int create(T item) {
        List<T> itemsList = loadItems();

        itemsList.add(item);
        saveItems(itemsList);
        itemsList = loadItems();

        return itemsList.indexOf(item);
    }

    @Override
    public List<T> readAll() {
        return loadItems();
    }
    @Override
    public T read(int id) {
        return loadItems().get(id);
    }
    @Override
    public boolean update(T item) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }


    abstract String getItemsFileName();

    void saveItems(List<T> itemList) {
        try (
                FileOutputStream fos = new FileOutputStream(ITEMS_FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(itemList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<T> loadItems() {
        List<T> itemList;
        try (
                FileInputStream fis = new FileInputStream(ITEMS_FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            itemList = (List<T>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            itemList = new ArrayList<>();
        }

        return itemList;
    }
}
