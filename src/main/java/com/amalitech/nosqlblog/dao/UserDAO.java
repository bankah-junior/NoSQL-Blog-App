package com.amalitech.nosqlblog.dao;

import com.amalitech.nosqlblog.model.User;

import java.util.Optional;

public interface UserDAO extends BaseDAO<User> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

}

