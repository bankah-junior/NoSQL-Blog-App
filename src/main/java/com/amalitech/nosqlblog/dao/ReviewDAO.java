package com.amalitech.nosqlblog.dao;

import com.amalitech.nosqlblog.model.Review;

import java.util.List;

public interface ReviewDAO extends BaseDAO<Review> {

    List<Review> findByPostId(String postId);

    double calculateAverageRating(String postId);
}
