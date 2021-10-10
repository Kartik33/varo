package com.example.vero.service;

import com.example.vero.entity.User;
import com.example.vero.entity.DeletedUsers;

public interface DeletedUserService {
    public DeletedUsers insertUser(User user, String addresses);
}
