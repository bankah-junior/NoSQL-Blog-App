package com.amalitech.nosqlblog.controller;

import com.amalitech.nosqlblog.model.User;
import com.amalitech.nosqlblog.service.impl.UserServiceImpl;

public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController() {
        this.userServiceImpl = new UserServiceImpl();
    }
     public User getById(String userId) {
        return userServiceImpl.getById(userId);
    }
}
