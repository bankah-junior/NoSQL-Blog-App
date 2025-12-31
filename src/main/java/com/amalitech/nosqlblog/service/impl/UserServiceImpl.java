package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.cache.Cache;
import com.amalitech.nosqlblog.cache.LruCache;
import com.amalitech.nosqlblog.dao.UserDAO;
import com.amalitech.nosqlblog.model.User;
import com.amalitech.nosqlblog.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDAO userDao;
    private final Cache<String, User> userCache;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
        this.userCache = new LruCache<>(50);
    }

    @Override
    public User create(User user) {
        User saved = userDao.save(user);
        userCache.put(saved.getId(), saved);
        return saved;
    }

    @Override
    public User update(User user) {
        Boolean updated = userDao.update(user);
        if (updated) {
            userCache.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public boolean delete(String userId) {
        boolean deleted = userDao.deleteById(userId);
        if (deleted) {
            userCache.remove(userId);
        }
        return deleted;
    }

    @Override
    public User getById(String userId) {
        if (userCache.containsKey(userId)) {
            return userCache.get(userId);
        }

        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()) {
            userCache.put(userId, user.get());
        }
        return user.orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> user = userDao.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}

