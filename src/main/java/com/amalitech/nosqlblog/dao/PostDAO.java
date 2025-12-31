package com.amalitech.nosqlblog.dao;

import com.amalitech.nosqlblog.model.Post;

import java.util.List;

public interface PostDAO extends BaseDAO<Post> {

    List<Post> findByAuthorId(String authorId);

    List<Post> searchByTitle(String keyword);
}

