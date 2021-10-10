package com.example.vero.service;

import java.util.List;

import com.example.vero.entity.User;
import com.example.vero.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {return ( List<User>) userRepository.findAll(); }

    @Override
    public User insertUser(User user) {
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUserId(Long id) {
        return userRepository.findUserByUserId(id);
    }

    @Override
    public User deleteUserByUserId(Long id) {
        userRepository.deleteById(id);
        return null;
    }


}
