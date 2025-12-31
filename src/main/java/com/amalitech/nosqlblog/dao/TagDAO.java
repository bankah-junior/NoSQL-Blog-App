package com.amalitech.nosqlblog.dao;

import com.amalitech.nosqlblog.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagDAO extends BaseDAO<Tag> {

    Optional<Tag> findByName(String name);

    void assignTagToPost(String postId, String tagId);

    List<Tag> findTagsByPostId(String postId);
}

