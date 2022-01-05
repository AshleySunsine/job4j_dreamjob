package ru.job4j.dream.store;

import ru.job4j.dream.model.User;

import java.util.Collection;

public interface StoreWithUser extends Store {
    void createUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    User findUserByEmail(int id);

    Collection<User> findAllUser();

    void setUser(int id);



}
