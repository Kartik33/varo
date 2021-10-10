package com.example.vero.repository;

import com.example.vero.entity.DeletedUsers;

import org.springframework.data.repository.CrudRepository;

public interface DeletedUsersRepository extends CrudRepository<DeletedUsers,Long>{
    
}
