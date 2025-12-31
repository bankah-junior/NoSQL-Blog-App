package com.amalitech.nosqlblog.service;

import com.amalitech.nosqlblog.model.Review;

import java.util.List;

public interface ReviewService {

    Review create(Review review);

    boolean delete(String reviewId);

    List<Review> getByPost(String postId);

    double getAverageRatingForPost(String postId);
}

