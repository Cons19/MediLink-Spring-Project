package com.exam.medilink.repositories;

import java.util.ArrayList;

public class UsersRepository extends AbstractCrudRepository<Object> {
    @Override
    public int create(Object item) {
        return 0;
    }

    @Override
    public ArrayList<Object> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
