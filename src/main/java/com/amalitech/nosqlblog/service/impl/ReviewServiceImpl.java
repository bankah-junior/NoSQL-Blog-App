package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.dao.ReviewDAO;
import com.amalitech.nosqlblog.model.Review;
import com.amalitech.nosqlblog.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public Review create(Review review) {
        return null;
    }

    @Override
    public boolean delete(String reviewId) {
        return false;
    }

    @Override
    public List<Review> getByPost(String postId) {
        return List.of();
    }

    @Override
    public double getAverageRatingForPost(String postId) {
        return 0;
    }
}
