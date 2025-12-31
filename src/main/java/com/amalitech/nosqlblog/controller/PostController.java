package com.amalitech.nosqlblog.controller;

import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.service.impl.PostServiceImpl;

import java.util.List;

public class  PostController {
    private final PostServiceImpl postService;

    public PostController() {
        this.postService = new PostServiceImpl();
    }

    public List<Post> findAll() {
        return postService.getAll();
    }
}
