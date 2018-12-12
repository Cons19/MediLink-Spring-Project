package com.exam.medilink.repositories;

import com.exam.medilink.models.User;

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
    String getItemsFileName() {
        return "users";
    }
}
