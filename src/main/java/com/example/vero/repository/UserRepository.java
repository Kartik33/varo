package com.example.vero.repository;

import com.example.vero.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    
    public User findUserByEmail(String email);
    public User findUserByUserId(Long id);
}
