package com.amalitech.nosqlblog.service;

import com.amalitech.nosqlblog.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    boolean delete(String userId);

    User getById(String userId);

    User getByEmail(String email);

    List<User> getAll();
}

