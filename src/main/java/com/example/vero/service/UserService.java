package com.example.vero.service;

import java.util.List;

import com.example.vero.entity.User;

public interface UserService {
    public List<User> getUsers();
    public User insertUser(User user);
    public User findUserByEmail(String email);
    public User findUserByUserId(Long id);
}
