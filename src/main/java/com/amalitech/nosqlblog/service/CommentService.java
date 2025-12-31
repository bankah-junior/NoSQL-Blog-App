package com.amalitech.nosqlblog.service;

import com.amalitech.nosqlblog.model.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    boolean delete(String commentId);

    List<Comment> getByPost(String postId);

    List<Comment> getByUser(String userId);
}

