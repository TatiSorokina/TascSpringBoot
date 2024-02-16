package com.example.springboot1.service;

import com.example.springboot1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    User editUser(User user);

    User getById(Long id);

}
