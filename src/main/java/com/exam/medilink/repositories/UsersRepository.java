package com.exam.medilink.repositories;

import com.exam.medilink.models.User;

import java.util.List;

public class UsersRepository extends AbstractCrudRepository<User> {
    private static UsersRepository instance;
    public static  UsersRepository getInstance() {
        if (instance == null) {
            instance = new UsersRepository();
        }
        return instance;
    }
    private UsersRepository() {}

    @Override
    public int create(User item) {
        return 0;
    }

    @Override
    public List<User> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User read(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(User item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    String getItemsFileName() {
        return "users";
    }
}
