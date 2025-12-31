package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {


    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public boolean delete(String postId) {
        return false;
    }

    @Override
    public Post getById(String postId) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        return List.of();
    }

    @Override
    public List<Post> searchByTitle(String keyword) {
        return List.of();
    }

    @Override
    public List<Post> getByAuthor(String authorId) {
        return List.of();
    }
}

