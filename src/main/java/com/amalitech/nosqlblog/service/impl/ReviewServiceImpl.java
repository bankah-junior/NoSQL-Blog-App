package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.dao.ReviewDAO;
import com.amalitech.nosqlblog.dao.impl.ReviewDAOImpl;
import com.amalitech.nosqlblog.model.Review;
import com.amalitech.nosqlblog.service.ReviewService;
import com.amalitech.nosqlblog.utils.MongoDBConnection;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;

    public ReviewServiceImpl() {
        this.reviewDAO = new ReviewDAOImpl(MongoDBConnection.connect().getDatabase("java-demo"));
    }

    @Override
    public Review create(Review review) {
        return reviewDAO.save(review);
    }

    @Override
    public boolean delete(String reviewId) {
        return reviewDAO.deleteById(reviewId);
    }

    @Override
    public List<Review> getByPost(String postId) {
        return reviewDAO.findByPostId(postId);
    }

    @Override
    public double getAverageRatingForPost(String postId) {
        return reviewDAO.calculateAverageRating(postId);
    }
}
