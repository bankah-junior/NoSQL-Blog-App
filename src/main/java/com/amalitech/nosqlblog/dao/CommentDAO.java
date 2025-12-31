package com.amalitech.nosqlblog.dao;

import com.amalitech.nosqlblog.model.Comment;

import java.util.List;

public interface CommentDAO extends BaseDAO<Comment> {
    List<Comment> findByPostId(String postId);
}

