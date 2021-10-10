package com.example.vero.service;

import com.example.vero.entity.DeletedUsers;
import com.example.vero.entity.User;
import com.example.vero.repository.DeletedUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletedUserServiceImpl implements DeletedUserService{

    @Autowired
    DeletedUsersRepository deletedUsersRepository;

    @Override
    public DeletedUsers insertUser(User user, String addresses) {
        DeletedUsers newUser = new DeletedUsers();
        newUser.setAddress(addresses);
        newUser.setEmail(user.getEmail());
        newUser.setUserId(user.getUserId());
        newUser.setfName(user.getfName());
        newUser.setlName(user.getlName());
        DeletedUsers createdUser = deletedUsersRepository.save(newUser);

        return createdUser;
    }

    
    
}
