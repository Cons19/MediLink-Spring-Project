package com.exam.medilink.repositories;

import java.util.List;

abstract class AbstractCrudRepository<T> implements CrudRepository<T>{

    public abstract int create(T item);
    public abstract List<T> readAll();
    public abstract T read(int id);
    public abstract boolean update(T item);
    public abstract boolean delete(int id);
}
