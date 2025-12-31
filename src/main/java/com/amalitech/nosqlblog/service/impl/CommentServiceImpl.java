package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.model.Comment;
import com.amalitech.nosqlblog.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Override
    public Comment create(Comment comment) {
        return null;
    }

    @Override
    public boolean delete(String commentId) {
        return false;
    }

    @Override
    public List<Comment> getByPost(String postId) {
        return List.of();
    }

    @Override
    public List<Comment> getByUser(String userId) {
        return List.of();
    }
}
