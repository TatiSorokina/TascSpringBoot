package com.example.springboot1.dao;

import com.example.springboot1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    User editUser(User user);

    User getById(Long id);

}

